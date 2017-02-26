# -*- coding: utf-8 -*-
'''
Created on 2016��12��30��

@author: Tan Zhuqing
'''

import pandas as pd

from scipy.interpolate import lagrange

inputFile=''
outputFile=''

data = pd.read_excel(inputFile,header=None)

def ployinterp_column(s,n,k=5):
    y = s[list(range(n-k,n)),list(range(n+1,n+1+k))]
    y = y[y.notnull()]
    return lagrange(y.index,list(y))(n)


for i in data.columns:
    for j in range(len(data)):
        if(data[i].isnull())[j]:
            data[i][j]=ployinterp_column(data[i], j)
            

data.to_excel(outputFile,header=None,index=False)
