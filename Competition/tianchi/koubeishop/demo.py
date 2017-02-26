# -*- coding: utf-8 -*-
'''
Created on 2017年2月25日

@author: Tan Zhuqing

'''

import numpy as np
import pandas as pd
from pip._vendor.requests.api import head


shopfile = "F:\\datacompetition\\dataset\\shop_info.txt"

payfile = "F:\\datacompetition\\dataset\\user_pay.txt"

viewfile = "F:\\datacompetition\\dataset\\user_view.txt"

user_pay_df = pd.read_table(payfile,sep=',',header=None,\
                            names=['user_id','shop_id','time_stamp'],\
                            dtype={'user_id':'str','shop_id':'str','time_stamp':'str'})


user_pay_df['time_stamp'] = user_pay_df['time_stamp'].str[:10]

print(user_pay_df.head(5))

customer_flow = user_pay_df.groupby(['shop_id','time_stamp']).size()

print(customer_flow)

for shop_id in range(1,2001):
    print("predicting:%d/2000"%shop_id)
    weekly_flow = pd.Series(np.zeros(7,dtype=int),
                            [d.strftime('%Y-%m-%d') for d in pd.date_range('10/25/2016',periods=7)])
    flow = customer_flow.loc[str(shop_id),'2016-10-25':'2016-10-31']
    
