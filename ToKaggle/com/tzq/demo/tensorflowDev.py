# -*- coding: utf-8 -*-
'''
Created on 2016��12��8��

@author: Tan Zhuqing
'''
import tensorflow as tf
import numpy as np
import pandas as pd

traindata = pd.read_csv('breast-cancer-train.csv')
testdata = pd.read_csv('breast-cancer-test.csv')

X_train = np.float32(traindata[['Clump Thickness','Cell Size']].T)
y_train = np.float32(traindata['Type'].T)
X_test = np.float32(testdata[['Clump Thickness','Cell Size']].T)
y_test = np.float32(testdata['Type'].T)

b = tf.Variable(tf.zeros([1]))
W =tf.Variable(tf.random_uniform([1,2],-1.0,1.0))
y=tf.matmul(W,X_train)+b

loss = tf.reduce_mean(tf.square(y-y_train))

optimizer = tf.train.GradientDescentOptimizer(0.01)

train = optimizer.minimize(loss)
init = tf.global_variables_initializer()

sess = tf.Session()
sess.run(init)

for step in range(0,1000):
    sess.run(train)   
    if step % 200 == 0:
        print(step,sess.run(W),sess.run(b))


test_negative = testdata.loc[testdata['Type'] == 0][['Clump Thickness','Cell Size']]
test_positive = testdata.loc[testdata['Type'] == 1][['Clump Thickness','Cell Size']]

import matplotlib.pyplot as plt

plt.scatter(test_negative['Clump Thickness'],test_negative['Cell Size'],marker='o',s=200,c='red')
plt.scatter(test_positive['Clump Thickness'],test_positive['Cell Size'],marker='x',s=150,c='black')

plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')

lx = np.arange(0,12)

ly = (0.5-sess.run(b) -lx * sess.run(W)[0][0])/sess.run(W)[0][1]

plt.plot(lx,ly,color='green')
plt.show()        