# -*- coding: utf-8 -*-
'''
Created on 2016��12��19��

@author: Tan Zhuqing
'''


import pandas as pd
import spark
import pyspark


items = pd.read_csv('F:/datacompetition/fresh/tianchi_fresh_comp_train_item.csv')
users = pd.read_csv('F:/datacompetition/fresh/tianchi_fresh_comp_train_user.csv')

print(users.head(5))

#df = spark.read.csv('F:/datacompetition/fresh/tianchi_fresh_comp_train_item.csv')
