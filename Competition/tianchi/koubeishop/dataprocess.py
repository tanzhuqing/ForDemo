# -*- coding: utf-8 -*-
'''
Created on 2017年2月8日

@author: Tan Zhuqing
'''

import pandas as pd
import numpy as np
from _datetime import date, datetime
from _sqlite3 import Row


shopfile = "F:\\datacompetition\\dataset\\shop_info.txt";
FMT='%Y-%m-%d %H:%M:%S'

shopdata = pd.read_table(shopfile,sep=',',names=['shop_id','city_name','location_id','per_pay','score','comment_cnt','shop_level','cate_1_name','cate_2_name','cate_3_name'])

shopdata = shopdata.set_index(['location_id'])
print(shopdata.head(20))
#shopdata = pd.read_table(shopfile,sep=',',names=['shop_id','city_name','location_id','per_pay,score','comment_cnt','shop_level','cate_1_name','cate_2_name','cate_3_name'])
#shopdata = DataFrame(shopdata,columns=['shop_id','city_name','location_id','per_pay,score','comment_cnt','shop_level','cate_1_name','cate_2_name','cate_3_name'])
# 
# print(shopdata.describe())
# print(shopdata['city_name'].unique())
# print(shopdata['cate_1_name'].unique())
# print(shopdata['cate_2_name'].unique())
# print(shopdata['cate_3_name'].unique())
# print(shopdata['per_pay'].groupby(shopdata['city_name']).mean())
# print(shopdata['per_pay'].groupby(shopdata['cate_1_name']).mean())
# print(shopdata['per_pay'].groupby(shopdata['cate_2_name']).mean())
# print(shopdata['per_pay'].groupby(shopdata['cate_3_name']).mean())


viewFile = "F:\\datacompetition\\dataset\\user_view.txt"

vdf = pd.read_table(viewFile,sep=',',names=['user_id','shop_id','time_stamp'])


def getCitySet(shopdata):
    set={}
    
    
def gettime(dates):
    df = []
    i=0
    for row in dates:
        d = str(row.year)+"-"+str(row.month)+"-"+str(row.day)
        d = pd.to_datetime(d,format='%Y-%m-%d')
        df.append([i,d,row.hour])
        i+=1
    return pd.DataFrame(df,columns=['index','date','hour'])

def getdf(vdf):
    vdf['index'] = range(0,vdf.shape[0])
    vdf['date'] = pd.to_datetime(vdf['time_stamp'],format=FMT)
    tdf = gettime(vdf.date)
    vdf = vdf.drop(['date'],axis=1)
    vdf = pd.merge(vdf,tdf)
    vdf = vdf.drop(['index','time_stamp'],axis=1)
    return vdf



buyFile = "F:\\datacompetition\\dataset\\user_pay.txt"

#vdf = pd.read_table(viewFile,sep=',',names=['user_id','shop_id','time_stamp'])

# vdf = getdf(vdf)
# vdf['view'] = 1
# data = vdf.groupby(['shop_id'],axis=1)
# print(data['view'].sum())