# -*- coding: utf-8 -*-
'''
Created on 2016��12��19��

@author: Tan Zhuqing
'''

import pandas as pd
from sqlalchemy import create_engine

engine=create_engine('mysql+pymysql://root:123456@127.0.0.1:3306/test?charset=utf8')

sql=pd.read_sql('all_gzdata',engine,chunksize=10000)

