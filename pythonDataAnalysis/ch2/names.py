# -*- coding: utf-8 -*-
'''
Created on 2017��1��14��

@author: Tan Zhuqing
'''


import pandas as pd
import matplotlib.pyplot as plt  
import numpy as np
from matplotlib.axis import YTick
from matplotlib.pyplot import yticks

years=range(1880,2010)

pieces=[]
columns=['name','sex','births']

for year in years:
    path='E:\\pythonDataSet\\pydata-book-master\\ch02\\names\\yob%d.txt' %year
    frame=pd.read_csv(path,names=columns)
    frame['year']=year
    pieces.append(frame)
    
names=pd.concat(pieces,ignore_index=True)

total_births=names.pivot_table('births',index='year',columns='sex',aggfunc=sum)

print(total_births.head())
#total_births.plot(title='Total births by sex and year')
#plt.show()
def add_prop(group):
    births=group.births
    group['prop']=births/births.sum()
    return group

names=names.groupby(['year','sex']).apply(add_prop)

print(np.allclose(names.groupby(['year','sex']).prop.sum(),1))

def get_top1000(group):
    return group.sort_values(by='births',ascending=False)[:1000]

grouped=names.groupby(['year','sex'])
top1000=grouped.apply(get_top1000)

boys=top1000[top1000.sex=='M']
girls=top1000[top1000.sex=='F']

total_births = top1000.pivot_table('births',index='year',columns='name',aggfunc=sum)

subset=total_births[['John','Harry','Mary','Marilyn','Julia']]
#subset.plot(subplots=True,figsize=(12,10),grid=False,title='Number of births per year')
#plt.show()

table=top1000.pivot_table('prop',index='year',columns='sex',aggfunc=sum)
#table.plot(title='Sum of table1000.prop by year and sex',yticks=np.linspace(0,1.2,13),xticks=range(1880,2020,10))
#plt.show()


df=boys[boys.year==2010]
print(df)

prop_cumsum=df.sort_values(by='prop',ascending=False).prop.cumsum()
print(prop_cumsum[:10])

def get_quantile_count(group,q=0.5):
    group=group.sort_values(by='prop',ascending=False)
    return group.prop.cumsum().searchsorted(q)+1

diversity=top1000.groupby(['year','sex']).apply(get_quantile_count)
diversity=diversity.unstack('sex')


get_last_letter = lambda x:x[-1]
last_letters=names.name.map(get_last_letter)
last_letters.name='last_letter'
table=names.pivot_table('births',index=last_letters,columns=['sex','year'],aggfunc=sum)
subtable=table.reindex(columns=[1910,1960,2010],level='year')
#print(subtable.head())
letter_prop=subtable/subtable.sum()

#fig,axes=plt.subplots(2,1,figsize=(10,8))
#letter_prop['M'].plot(kind='bar',rot=0,ax=axes[0],title='Male')
#letter_prop['F'].plot(kind='bar',rot=0,ax=axes[1],title='Female',legend=False)
#plt.show()

letter_prop=table/table.sum()
dny_ts=letter_prop.ix[['d','n','y'],'M'].T
print(dny_ts.head())
#dny_ts.plot()
#plt.show()

all_names=top1000.name.unique()
mask=np.array(['lesl' in x.lower() for x in all_names])
lesley_like=all_names[mask]
print(lesley_like)

filtered =top1000[top1000.name.isin(lesley_like)]
print(filtered.groupby('name').births.sum())

table=filtered.pivot_table('births',index='year',columns='sex',aggfunc='sum')
table=table.div(table.sum(1),axis=0)
print(table.tail())
table.plot(style={'M':'k-','F':'k--'})
plt.show()













