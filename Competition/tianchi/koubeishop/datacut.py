# -*- coding: utf-8 -*-
'''
Created on 2017年2月16日

@author: Tan Zhuqing
'''

import numpy as np
import pandas as pd
import datetime

shopfile = "F:\\datacompetition\\dataset\\shop_info.txt"
t = datetime.date(2016, 1, 1)


payfile = "F:\\datacompetition\\dataset\\user_pay.txt"

viewfile = "F:\\datacompetition\\dataset\\user_view.txt"
file = open(payfile, 'rb')
print(file.readline())
for i in file:
    lins=[]
    