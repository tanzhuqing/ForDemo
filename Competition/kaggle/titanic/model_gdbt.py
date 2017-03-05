# -*- coding: utf-8 -*-
'''
Created on 2017年2月18日

@author: Tan Zhuqing
'''

import pandas as pd
import xgboost as xgb
from sklearn.preprocessing import LabelEncoder
import numpy as np

train_df = pd.read_csv('train',header=0)
test_df = pd.read_csv('test',header=0)

from sklearn.base import TransformerMixin

class DataFrameInputer(TransformerMixin):
    def fit(self,X,y=None):
        self.fill = pd.Series([X[c].value_counts().index[0]
            if X[c].dtype == np.dtype('0') else X[c].median() for c in X],index=X.columns)
        return self
    
    def transform(self,X,y=None):
        return X.fillna(self.fill)
    

feature_columns_to_use = ['Pclass','Sex','Age','Fare','Parch']
nonnumeric_columns = ['Sex']

big_X = train_df[feature_columns_to_use].append(test_df[feature_columns_to_use])
big_X_imputed = DataFrameInputer().fit_transform(big_X)

le = LabelEncoder()
for feature in nonnumeric_columns:
    big_X_imputed[feature] = le.fit_transform(big_X_imputed[feature])
    

            