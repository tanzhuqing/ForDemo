# -*- coding: utf-8 -*-
'''
Created on 2016��12��8��

@author: Tan Zhuqing
'''

import tensorflow as tf
import numpy as np
import pandas as pd;

# 使用 NumPy 生成假数据(phony data), 总共 100 个点.
#x_data = np.float32(np.random.rand(2, 100)) # 随机输入
#y_data = np.dot([0.100, 0.200], x_data) + 0.300

traindata = pd.read_csv('breast-cancer-train.csv')
testdata = pd.read_csv('breast-cancer-test.csv')

X_train = np.float32(traindata[['Clump Thickness','Cell Size']].T)
y_train = np.float32(traindata['Type'].T)

# 构造一个线性模型
# 
b = tf.Variable(tf.zeros([1]))
W = tf.Variable(tf.random_uniform([1, 2], -1.0, 1.0))
y = tf .matmul(W, X_train) + b

# 最小化方差
loss = tf.reduce_mean(tf.square(y - y_train))
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

# 初始化变量
init = tf.global_variables_initializer()

# 启动图 (graph)
sess = tf.Session()
sess.run(init)

# 拟合平面
for step in range(0, 201):
    sess.run(train)
    if step % 20 == 0:
        print (step, sess.run(W), sess.run(b))

