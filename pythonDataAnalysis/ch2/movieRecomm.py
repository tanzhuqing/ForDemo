# -*- coding: utf-8 -*-
'''
Created on 2017��1��15��

@author: Tan Zhuqing
'''
import pandas as pd
import numpy as np
from numpy import *



unames=['user_id','gender','age','occupation','zip']
users=pd.read_table('E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\users.dat',sep='::',header=None,names=unames)
#print(users[:5])
rnames=['user_id','movie_id','rating','timestamp']
ratings=pd.read_table("E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\ratings.dat",sep="::",header=None,names=rnames)
#print(ratings[:5])
mnames=['movie_id','title','genres']
movies=pd.read_table('E:\\pythonDataSet\\pydata-book-master\\ch02\\movielens\\movies.dat',sep="::",header=None,names=mnames)
#print(movies[:5])

data=pd.merge(pd.merge(ratings,users),movies)
#print(data.head())

matrixData=data.pivot_table('rating',index='user_id',columns='movie_id')
#print(matrixData.shape)

matrixData=matrixData.fillna(0)
print(matrixData[0])

#U,sigma,Vt=linalg.svd(matrixData)
#print(U)

def ecludSim(inA,inB):
    return 1.0/(1.0+linalg.norm(inA-inB))

def pearsSim(inA,inB):
    if len(inA)<3:return 1.0
    return 0.5+0.5*corrcoef(inA, inB, rowvar=0)[0][1]

def cosSim(inA,inB):
    num=float(inA*inB)
    denom=linalg.norm(inA)*linalg.norm(inB)
    return 0.5+0.5*(num/denom)

def standEst(dataMat,user,simMeas,item):
    n=shape(dataMat)[1]
    simTotal=0.0
    ratSimTotal=0.0
    for j in range(n):
        userRating=dataMat[user,j]
        if userRating==0:continue
        overLap=nonzero(logical_and(dataMat[:,item].A>0,dataMat[:,j].A>0))[0]
        if len(overLap) ==0:similarity=0
        else:similarity=simMeas(dataMat[overLap,item],dataMat[overLap,j])
        print('the %d and %d similarity is:%f ' % (item,j,similarity))
        simTotal+=similarity
        ratSimTotal+=similarity*userRating
    if simTotal==0:return 0
    else:return ratSimTotal/simTotal
    
    
def recommend(dataMat,user,N=3,simMeas=cosSim,estMethod=standEst):
    unratedItems=nonzero(dataMat[user,:].A==0.0)[1]
    if len(unratedItems)==0:return 'you rated everyThing '
    itemScores=[]
    for item in unratedItems:
        estimatedScore=estMethod(dataMat,user,simMeas,item)
        itemScores.append((item,estimatedScore))
    return sorted(itemScores,key=lambda jj:jj[1],reverse=True)[:N]

    
    
print(recommend(matrixData, 10))
    
    