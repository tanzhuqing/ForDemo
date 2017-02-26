# -*- coding: utf-8 -*-
'''
Created on 2017��1��14��

@author: Tan Zhuqing
'''
import pandas as pd

unames=['user_id','gender','age','occupation','zip']
users=pd.read_table('E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\users.dat',sep='::',header=None,names=unames)
print(users[:5])
rnames=['user_id','movie_id','rating','timestamp']
ratings=pd.read_table("E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\ratings.dat",sep="::",header=None,names=rnames)
print(ratings[:5])
mnames=['movie_id','title','genres']
movies=pd.read_table('E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\movies.dat',sep="::",header=None,names=mnames)
print(movies[:5])

data=pd.merge(pd.merge(ratings,users),movies)

print(data.ix[0])

mean_ratings=data.pivot_table('rating',index='title',columns='gender',aggfunc='mean')
print(mean_ratings[:5])

rating_by_title=data.groupby('title').size()
print(rating_by_title[:10])
active_titles=rating_by_title.index[rating_by_title>=250]
print(active_titles)

mean_ratings=mean_ratings.ix[active_titles]
print(mean_ratings)

top_female_ratings=mean_ratings.sort_values(by='F',ascending=False)
print(top_female_ratings[:10])

mean_ratings['diff']=mean_ratings['M']-mean_ratings['F']
sorted_by_ratings=mean_ratings.sort_values(by='diff')
print(sorted_by_ratings[:15])
print(sorted_by_ratings[::-1][:15])


rating_std_by_title=data.groupby('title')['rating'].std()
rating_std_by_title=rating_std_by_title.ix[active_titles]

print(rating_std_by_title.sort_values(ascending=False)[:10])
