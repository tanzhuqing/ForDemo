# -*- coding: utf-8 -*-
#ARIMA 时序模型
'''
Created on 2016��11��28��

@author: Tan Zhuqing
'''

import pandas as pd
import numpy as np

discfile = 'E:\\pythonDataSet\\chapter5\\demo\\data\\arima_data.xls'
forecastnum = 5

data = pd.read_excel(discfile,index_col=u'日期')

import matplotlib.pyplot as plt

plt.rcParams['font.sans-serif'] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False
data.plot()
plt.show()

from statsmodels.graphics.tsaplots import plot_acf
plot_acf(data).show()

from statsmodels.tsa.stattools import adfuller as ADF
print(u'原始序列的ADF检验结果为：',ADF(data[u'销量']))

D_data = data.diff().dropna()
D_data.columns = [u'销量差分']
D_data.plot()
plt.show()
plot_acf(D_data).show()

from statsmodels.graphics.tsaplots import plot_pacf
plot_pacf(D_data).show()
print (u'差分序列的ADF检验结果为：',ADF(D_data[u'销量差分']))

from statsmodels.stats.diagnostic import acorr_ljungbox
print(u'差分序列白噪声检验结果为：',acorr_ljungbox(D_data, lags=1))

from statsmodels.tsa.arima_model import ARIMA
data=np.array(data,dtype=np.float)
pmax = int(len(D_data)/10)
qmax = int(len(D_data)/10)
bic_matrix = []
for p in range(pmax+1):
    tmp=[]
    for q in range(qmax+1):
        try:
            tmp.append(ARIMA(data,(p,1,q)).fit().bic)
        except:
            tmp.append(None)
    bic_matrix.append(tmp)
    

bic_matrix = pd.DataFrame(bic_matrix)
p,q = bic_matrix.stack().idxmin()
print (u'BIC最小的p值和q值为：%s、%s'%(p,q))
model = ARIMA(data,(p,1,q)).fit()
model.summary2()
model.forecast(5)