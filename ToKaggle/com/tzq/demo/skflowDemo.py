# -*- coding: utf-8 -*-
'''
Created on 2016��12��9��

@author: Tan Zhuqing
'''
from sklearn import datasets,metrics,preprocessing,cross_validation

boston = datasets.load_boston()

X,y = boston.data,boston.target


X_train,X_test,y_train,y_test = cross_validation.train_test_split(X,y,test_size=0.25,random_state=33)

scaler = preprocessing.StandardScaler()

X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)
print(X_train)

import skflow

tf_lr = skflow.TensorFlowLinearRegressor(steps=10000,learning_rate=0.01,batch_size=50)

tf_lr.fit(X_train,y_train)


tf_lr_y_predict = tf_lr.predict(X_test)

print('The mean absolute error of Tensorflow Linear Regressor on boston dataset is ',metrics.mean_absolute_error(tf_lr_y_predict,y_test))
print('The mean squared error of Tensorflow Linear Regressor on boston dataset is ',metrics.median_absolute_error(tf_lr_y_predict,y_test))
print('The R-squared value of Tensorflow Linear Regressor on boston dataset is ',metrics.r2_score(tf_lr_y_predict,y_test))
