# -*- coding: utf-8 -*-
'''
Created on 2017��1��3��

@author: Tan Zhuqing
'''

import csv
import random

num=1
csvfile=file('sample_17_negative_user_csv','wb')
writer=csv.writer(csvfile)
for line in csv.reader(file('17_negative.csv','r')):
    if num%200==0:
        writer.writerow(line)
    num=num+1
print(num)