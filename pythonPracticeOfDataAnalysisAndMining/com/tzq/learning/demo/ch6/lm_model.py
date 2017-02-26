# -*- coding: utf-8 -*-
'''
Created on 2016��12��30��

@author: Tan Zhuqing
'''


import pandas  as pd
from random import shuffle #随机函数，用来打乱数据


datafile='E:\\pythonDataSet\\chapter6\\test\\data\\model.xls'
data=pd.read_excel(datafile)
data=data.as_matrix()

shuffle(data)

p=0.8
train = data[:int(len(data)*p),:]
test = data[int(len(data)*p):,:]

from keras.models import Sequential
from keras.layers.core import Dense,Activation

netFile = 'E:\\pythonDataSet\\chapter6\\test\\data\\test_model_result.xls'
net = Sequential() #建立神经网络
net.add(Dense(3,10)) #添加输入层（3节点）到隐藏层（10节点）的连接
net.add(Activation('relu')) #隐藏层使用relu激活函数
net.add(Dense(10,1))#添加隐藏层（10节点）到输出层（1节点）的连接
net.add(Activation('sigmoid')) #输出层使用sigmoid激活函数
net.compile(loss='binary_crossentropy',optimizer='adam',class_mode="binary") #编译模型，使用adam方法求解

net.fit(train[:,:3],nb_epoch=1000,batch_size=1)
net.save_weights(netFile) # 保存模型

predict_result = net.predict_classes(train[:,:3]).reshape(len(train)) #预测结果变形



