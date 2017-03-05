# -*- coding: utf-8 -*-
'''
Created on 2017��1��4��

@author: Tan Zhuqing
'''

from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier
from sklearn.ensemble import GradientBoostingRegressor
import numpy as np
f=open("train_sample.txt")
f.readline()
data=np.loadtxt(f)
X=data[:,:-1]
y=data[:,-1]
print(X)
print(y)
print('start tarin')

clf2=RandomForestClassifier(n_estimators=100)
clf2.fit(X,y)
print(clf2.classes_)
f1=open("test_data_9feature.txt")
data1=np.loadtxt(f1)
X_new=data1[:,:]
print("testing data is ok")
result=clf2.predict_proba(X_new)
print("output result")
print(result)
f_result=open('result9.txt','w')
for i in range(0,len(result)):
    f_result.write(str(result[i])+'\n')