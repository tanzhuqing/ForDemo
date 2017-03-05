# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np
from _sqlite3 import Row

viewFile = "F:\\datacompetition\\dataset\\user_view.txt"
payFile = "F:\\datacompetition\\dataset\\user_pay.txt"

vdf = pd.read_table(viewFile,sep=',',names=['user_id','shop_id','time_stamp'])

vdata = {}
for index,row in vdf.iterrows():
    key = str(row[0])+"_"+str(row[1])
    if key in vdata:
        lst = vdata[key]
        lst.append(row[2])
    else:
        vdata[key] = [row[2]]
print(vdata.size())
#pdf = vdf = pd.read_table(payFile,sep=',',names=['user_id','shop_id','time_stamp'])


