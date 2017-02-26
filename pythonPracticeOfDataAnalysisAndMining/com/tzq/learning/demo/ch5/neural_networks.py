# -*- coding: utf-8 -*-
#使用神经网络算法预测销售高低
'''
Created on 2016��11��27��

@author: Tan Zhuqing
'''

import pandas as pd

inputfile = 'E:\\pythonDataSet\\chapter5\\demo\\data\\sales_data.xls'
data = pd.read_excel(inputfile,index_col=u'序号')

data[data == u'好'] =1
data[data == u'是'] =1
data[data == u'高'] =1
data[data != 1]=-1

X = data.iloc[:,:3].as_matrix().astype(int)
y = data.iloc[:,3].as_matrix().astype(int)
print X,y

from keras.models import Sequential
from keras.layers.core import Dense,Activation

model = Sequential()
model.add(Dense(3,10))
model.add(Activation('relu'))
model.add(Dense(10,1))
model.add(Activation('sigmoid'))

model.compile(loss='binary_crossentropy',optimizer='adam',class_mode='binary')

model.fit(X,y,nb_epoch=1000,batch_size=10)
yp = model.predict_classes(X).reshape(len(y))


from cm_plot import *
cm_plot(y,yp).show()