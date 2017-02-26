# -*- coding: utf-8 -*-
'''
Created on 2017年2月19日

@author: Tan Zhuqing
'''

import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from random import shuffle


train=pd.read_csv('train.csv',header=0)
test = pd.read_csv('test.csv',header=0)

print('Training data : ' + str(train.shape[0]) + 'rows, '+str(train.shape[1])+' columns')
print('Testing data : ' + str(test.shape[0]) + 'rows, '+str(test.shape[1])+' columns')

#print(train.info())

train.columns = ["Id", "MonthsLast",'NumberDonations',"Volume","MonthsFirst","Donated2007"]
test.columns = ["Id", "MonthsLast",'NumberDonations',"Volume","MonthsFirst"]

print(float(np.sum(train['Donated2007']))/len(train['Donated2007']))

train['Consistency'] = (train['MonthsFirst'] - train['MonthsLast'])/train['NumberDonations']

train = train[["Id", "MonthsLast",'NumberDonations',"Volume","MonthsFirst","Consistency","Donated2007"]]
train.Consistency[train.Consistency==0]=train.MonthsLast[train.Consistency==0]

test["Consistency"] = (test["MonthsFirst"] - test["MonthsLast"])/test["NumberDonations"]
test.Consistency[test.Consistency == 0] = test.MonthsLast[test.Consistency == 0]

train = train.drop("Id", axis=1)

corr = train.corr()

mask = np.zeros_like(corr, dtype=bool)
mask[np.triu_indices_from(mask)] = True

f,ax = plt.subplots(figsize=(11,9))
sns.set(style='white')

cmap = sns.diverging_palette(220,10,as_cmap=True)

sns.heatmap(corr,mask=mask,cmap=cmap,vmax=.3,square=True,xticklabels=True,yticklabels=True,linewidths=.5,
            cbar_kws={'shrink':.5},ax=ax)

#plt.show()

sns.set(style='ticks',color_codes=True)
sns.pairplot(train, hue="Donated2007", diag_kind = "kde",palette = dict([(0, "blue"), (1, "red")]),vars=["MonthsLast",'NumberDonations',"Volume","MonthsFirst","Consistency"])
#plt.show()

from sklearn import metrics


train = train.drop("Volume",axis=1)
test = test.drop("Volume", axis=1)


labels = train['Donated2007']

train = train.drop("Donated2007",axis=1)

from sklearn.preprocessing import MinMaxScaler

min_max_scaler = MinMaxScaler(feature_range=(0,1))

trainMatrix = train.as_matrix().astype(float)

train_scaled = min_max_scaler.fit_transform(trainMatrix)
train_scaled = pd.DataFrame(train_scaled)
train_scaled.columns = train.columns.values.tolist()
testMatirx = test.as_matrix().astype(float)
test_scaled = min_max_scaler.fit_transform(testMatirx)
test_scaled = pd.DataFrame(test_scaled)
test_scaled.columns = test.columns.values.tolist()

from sklearn.model_selection import train_test_split
TrainFeats,TestFeats,TrainLabels,TestLabels = train_test_split(train_scaled,labels,test_size=0.25)

print(TrainFeats.shape)
print(TestFeats.shape)
print(TrainLabels.shape)
print(TestLabels.shape)
# from sklearn.model_selection import StratifiedKFold
# kf = StratifiedKFold(len(TrainLahels),n_splits=5,shuffle=False,random_state=123)

from sklearn import model_selection
kf = model_selection.KFold(n_splits=5,shuffle=False,random_state=123)


score_train = np.array([])
score_test = np.array([])

for train_index,test_index in kf.split(TrainLabels,TestLabels):
     CVTrainFeats, CVTestFeats = TrainFeats[train_index], TrainFeats[test_index]
     CVTrainLabels, CVTestLabels = TrainLabels[train_index], TrainLabels[test_index]


colNames = train.columns.values.tolist()
print(colNames)

