# -*- coding: utf-8 -*-
#使用ID3决策树算法预测销量高低

'''
Created on 2016��11��27��

@author: Tan Zhuqing
'''
import pandas as pd

filename='E:\\pythonDataSet\\chapter5\\demo\\data\\sales_data.xls'
data = pd.read_excel(filename,index_col=u'序号')

data[data == u'好'] =1
data[data == u'是'] =1
data[data == u'高'] =1
data[data != 1]=-1

X = data.iloc[:,:3].as_matrix().astype(int)
y = data.iloc[:,3].as_matrix().astype(int)

from sklearn.tree import DecisionTreeClassifier as DTC
dtc = DTC(criterion='entropy')
dtc.fit(X,y)

from sklearn.tree import export_graphviz
from sklearn.externals.six import StringIO

with open("tree.dot",'w') as f:
    f = export_graphviz(dtc, feature_names=X.columns, out_file=f)
