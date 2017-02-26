'''
Created on 2016-10-13

@author: tzq
'''

import math
import numpy as np
import pandas as pd
from pandas  import DataFrame
from sklearn  import preprocessing
from sklearn.linear_model import  LogisticRegression
from sklearn.cross_validation import  train_test_split
from numpy import  loadtxt,where
from pylab import scatter,show,legend,xlabel,ylabel

min_max_scaler = preprocessing.MinMaxScaler(feature_range=(-1,1))
df = pd.read_csv("data.csv",header = 0)

df.columns = ["grade1","grade2","label"]

x = df["label"].map(lambda x:float(x.rstrip(';')))

X = df[["grade1","grade2"]]
X = np.array(X)
X = min_max_scaler.fit_transform(X)
Y = df["label"].map(lambda x:float(x.rstrip(';')))
Y = np.array(Y)



X_train,X_test,Y_train,Y_test = train_test_split(X,Y,test_size=0.33)

clf = LogisticRegression()
clf.fit(X_train, Y_train)
print 'score Scikit learn : ',clf.score(X_test, Y_test)


pos = where(Y == 1)
neg = where(Y == 0)
scatter(X[pos,0], X[pos,1], marker='o',c='b')
scatter(X[neg,0], X[neg,1], marker='x',c='r')
xlabel('Exam 1 score')
ylabel('Exam 2 score')
legend(['Not Admitted','Admitted'])




