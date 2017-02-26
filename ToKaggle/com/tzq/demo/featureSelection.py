'''
Created on 2016-11-22

@author: Tan Zhuqing
'''

import pandas as pd

titanic = pd.read_csv('http://biostat.mc.vanderbilt.edu/wiki/pub/Main/DataSets/titanic.txt')

y=titanic['survived']
X = titanic.drop(['row.names','name','survived'], axis=1)

X['age'].fillna(X['age'].mean(),inplace=True)
X.fillna('UNKNOWN',inplace = True)

from sklearn.cross_validation import train_test_split

X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.25,random_state=33)

from sklearn.feature_extraction import DictVectorizer
vec= DictVectorizer()
X_train = vec.fit_transform(X_train.to_dict(orient='record'))
X_test = vec.transform(X_test.to_dict(orient='record'))

print len(vec.feature_names_)


from sklearn.tree import DecisionTreeClassifier
dt = DecisionTreeClassifier(criterion='entropy')
dt.fit(X_train,y_train)
print dt.score(X_test, y_test)

from sklearn import feature_selection
fs = feature_selection.SelectPercentile(feature_selection.chi2,percentile=20)
X_train_fs = fs.fit_transform(X_train,y_train)
dt.fit(X_train_fs,y_train)
X_test_fs = fs.transform(X_test)

print dt.score(X_test_fs,y_test)

from sklearn.cross_validation import cross_val_score
import numpy as np

percentiles = range(1,100,2)
results =[]

for i in percentiles:
    fs = feature_selection.SelectPercentile(feature_selection.chi2,percentile=i)
    X_train_fs = fs.fit_transform(X_train,y_train)
    scores = cross_val_score(dt, X_train_fs, y_train, cv=5)
    results = np.append(results, scores.mean())
    
print results

opt = np.where(results == results.max())[0][0]
print opt
print percentiles[opt]

import pylab as pl
pl.plot(percentiles,results)
pl.xlabel('percentiles of features')
pl.ylabel('accuracy')
pl.show()

fs = feature_selection.SelectPercentile(feature_selection.chi2,percentile=7)
X_train_fs = fs.fit_transform(X_train,y_train)
dt.fit(X_train_fs,y_train)
X_test_fs = fs.transform(X_test)

print dt.score(X_test_fs,y_test)