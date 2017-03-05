# -*- coding: utf-8 -*-
'''
Created on 2017年2月17日

@author: Tan Zhuqing
'''

import numpy as np
import pandas as pd

from sklearn.model_selection import KFold,cross_val_score


from sklearn.linear_model import LinearRegression
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier


titanic = pd.read_table("train",sep=',', header = 0)

titanic['Age'] = titanic['Age'].fillna(titanic['Age'].median())
 
titanic.loc[titanic['Sex']=="male","Sex"] = 0
titanic.loc[titanic['Sex']=="female","Sex"] = 1

titanic['Embarked'] = titanic['Embarked'].fillna('S')
titanic.loc[titanic['Embarked']=='S','Embarked']=0
titanic.loc[titanic['Embarked']=='C','Embarked']=1
titanic.loc[titanic['Embarked']=='Q','Embarked']=2

predictors =  ["Pclass", "Sex", "Age", "SibSp", "Parch", "Fare", "Embarked"]

alg = LogisticRegression()
 
scores = cross_val_score(alg,titanic[predictors],titanic['Survived'],cv=3)
 
print(("Accuracy of Logistic Regression on the training set is "+str(scores.mean())))



alg = RandomForestClassifier(n_estimators=1000,min_samples_leaf=5,max_features='auto',n_jobs=2,random_state=10)
 
scores=cross_val_score(alg,titanic[predictors],titanic['Survived'],cv=3)
 
print(("Accuracy of Random Forest on the training set is "+str(scores.mean())))

titanic_test = pd.read_table("test",sep=',', header = 0)

titanic_test['Age'] = titanic_test['Age'].fillna(titanic_test['Age'].median())
 
titanic_test.loc[titanic_test['Sex']=="male","Sex"] = 0
titanic_test.loc[titanic_test['Sex']=="female","Sex"] = 1

titanic_test['Embarked'] = titanic_test['Embarked'].fillna('S')
titanic_test.loc[titanic_test['Embarked']=='S','Embarked']=0
titanic_test.loc[titanic_test['Embarked']=='C','Embarked']=1
titanic_test.loc[titanic_test['Embarked']=='Q','Embarked']=2

titanic_test['Fare'] = titanic_test['Fare'].fillna(titanic_test['Fare'].median())

alg.fit(titanic[predictors], titanic['Survived'])

predictions = alg.predict(titanic_test[predictors])

submission = pd.DataFrame({'PassengerId':titanic_test['PassengerId'],
                           'Survived':predictions})

submission.to_csv('result_RF',index=False)
