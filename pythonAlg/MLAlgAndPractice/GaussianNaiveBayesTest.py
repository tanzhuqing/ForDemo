'''
Created on 2016-8-18

@author: Administrator
'''

from sklearn import datasets
from sklearn.naive_bayes import GaussianNB



iris = datasets.load_iris()
gnb = GaussianNB()
y_pred = gnb.fit(iris.data, iris.target).predict(iris.data)
print("Number of mislabeled point out of a total %d points : %d"
      % (iris.data.shape[0],(iris.target != y_pred).sum()))
