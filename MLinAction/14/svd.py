# -*- coding: utf-8 -*-
'''
Created on 2016��12��27��

@author: Tan Zhuqing
'''

from numpy import *
'''

U,Sigma,VT=linalg.svd([[1,1],[7,7]])

print(U)
print(Sigma)
print(VT)
'''

import svdRec
Data = svdRec.loadExData()
U,Sigma,VT=linalg.svd(Data)
print (Sigma)