# -*- coding: utf-8 -*-
'''
Created on 2016��11��28��

@author: Tan Zhuqing
'''
import numpy as np
import pandas as pd

inputfilepath = 'E:\\pythonDataSet\\chapter5\\demo\\data\\consumption_data.xls'
k = 3
therashold = 2
iteration = 500
data = pd.read_excel(inputfilepath,index_col='Id')
data_zs = 1.0*(data-data.mean())/data.std()

from sklearn.cluster import KMeans
model = KMeans(n_clusters=k,max_iter=iteration)
model.fit(data_zs)

r = pd.concat([data_zs,pd.Series(model.labels_,index=data.index)],axis = 1)
r.columns = list(data.columns) + [u'聚类类别']

norm=[]
for i in range(k):
    norm_tmp = r[['R','F','M']][r[u'聚类类别']==i]-model.cluster_centers_[i]
    norm_tmp = norm_tmp.apply(np.linalg.norm,axis=1)
    norm.append(norm_tmp/norm_tmp.median())
norm = pd.concat(norm)

import matplotlib.pyplot as plt
plt.rcParams['font.sans-serif']=['SimHei']
plt.rcParams['axes.unicode_minus'] = False
norm[norm <= therashold].plot(style='ro')

discrete_points = norm[norm>therashold] 
discrete_points.plot(style='ro')

for i in range(len(discrete_points)):
    id= discrete_points.index[i]
    n = discrete_points.iloc[i]
    plt.annotate('(%s,%0.2f)'%(id,n),xy=(id,n),xytext=(id,n))

    
plt.xlabel(u'编号')
plt.ylabel(u'相对距离')
plt.show()
