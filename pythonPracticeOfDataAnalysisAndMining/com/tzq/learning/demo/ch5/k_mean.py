# -*- coding: utf-8 -*-
#使用K-means算法聚类消费行为特征数据

'''
Created on 2016��11��27��

@author: Tan Zhuqing
'''

import pandas as pd

inputfile = 'E:\\pythonDataSet\\chapter5\\demo\\data\\consumption_data.xls'
output = 'E:\\pythonDataSet\\chapter5\\demo\\data\\k_mean_test_data.xls'

k = 3
iteration = 500
data = pd.read_excel(inputfile,index_col='Id')
data_sz = 1.0 * (data - data.mean())/data.std()

from sklearn.cluster import KMeans
model = KMeans(n_clusters=k,max_iter=iteration)
model.fit(data_sz)

r1 = pd.Series(model.labels_).value_counts()
r2 = pd.DataFrame(model.cluster_centers_)
r = pd.concat([r2,r1],axis=1)
r.columnd = list(data.columns) + [u'类别数目']
print r

r = pd.concat([data,pd.Series(model.labels_,index=data.index)],axis = 1)
r.columns = list(data.columns)+ [u'聚类类别']
r.to_excel(output)