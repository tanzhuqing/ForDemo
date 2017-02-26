# -*- coding: utf-8 -*-
#使用Apriori算法挖掘菜品订单关联规则
'''
Created on 2016��11��27��

@author: Tan Zhuqing
'''
from __future__ import print_function
import pandas as pd
from apriori import *

inputfile = 'E:\\pythonDataSet\\chapter5\\demo\\data\\menu_orders.xls'
outputfile = 'E:\\pythonDataSet\\chapter5\\demo\\data\\menu_orders_results.xls'

data = pd.read_excel(inputfile,header=None)

print (u'\n转换原始数据至0-1矩阵...')

ct = lambda x : pd.Series(1,index=x[pd.notnull(x)])
b = map(ct, data.as_matrix())

data = pd.DataFrame(list(b)).fillna(0)

print (u'\n转换完毕')

del b


support = 0.2
confidence = 0.5

ms = '---' 

find_rule(data,support,confidence,ms).to_excel(outputfile)
