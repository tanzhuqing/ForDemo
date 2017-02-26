# -*- coding: utf-8 -*-
'''
Created on 2016��12��8��

@author: Tan Zhuqing
'''

import tensorflow as tf
import numpy as np

greeting = tf.constant('Hello Google Tensorflow!')

sess = tf.Session()
result = sess.run(greeting)
print(result)
sess.close()

matrix1=tf.constant([[3.,3.]])
matrix2=tf.constant([[2.],[2.]])

product = tf.matmul(matrix1,matrix2)

linear = tf.add(product,tf.constant(2.0))

with tf.Session() as sess:
    retult = sess.run(linear)
    print(result)


