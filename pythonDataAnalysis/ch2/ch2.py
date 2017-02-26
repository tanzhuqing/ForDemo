# -*- coding: utf-8 -*-
'''
Created on 2017��1��14��

@author: Tan Zhuqing
'''

import json

from collections import Counter

path="E:\\pythonDataSet\\pydata-book-master\\ch02\\usagov_bitly_data2012-03-16-1331923249.txt"

print(open(path).readline())

records=[json.loads(line) for line in open(path)]

print(records[0])

print(records[0]['tz'])

time_zones=[rec['tz'] for rec in records if 'tz' in rec]
print(time_zones)

counts=Counter(time_zones)

print(counts.most_common(10))


from pandas import DataFrame,Series
import pandas as pd
import numpy as np
frame = DataFrame(records)
tz_counts=frame['tz'].value_counts()
clean_tz=frame['tz'].fillna("Missing")
clean_tz[clean_tz=='']='Unknown'
tz_counts=clean_tz.value_counts()


print(tz_counts[:10])

tz_counts[:10].plot(kind='barh',rot=0)

results=Series([x.split()[0] for x in frame.a.dropna()])

print(results.value_counts()[:10])
results=Series([x.split()[0] for x in frame.c.dropna()])

print(results.value_counts()[:10])


cframe = frame[frame.a.notnull()]
os = np.where(cframe['a'].str.contains('Windows'),'Windows',"Not Windows")

print(os[:10])

by_tz_os=cframe.groupby(['tz',os])
agg_counts=by_tz_os.size().unstack().fillna(0)
print(agg_counts[:10])

indexer=agg_counts.sum(1).argsort()
print(indexer[:10])

count_subset = agg_counts.take(indexer)[-10:]
print(count_subset)



























