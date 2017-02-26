# -*- coding: utf-8 -*-
'''
Created on 2017��1��11��

@author: Tan Zhuqing
'''



import pandas as pd

user_pay_info = pd.read_table("E:\\pythonDataSet\\dataset\\user_pay")
user_view_info = pd.read_table("E:\\pythonDataSet\\dataset\\user_view")

print(user_pay_info.shape)