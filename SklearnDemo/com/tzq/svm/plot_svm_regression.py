'''
Created on 2016-10-21

@author: Tan Zhuqing
'''
import numpy as np
from sklearn.svm import SVR
import matplotlib.pyplot as plt
from cProfile import label

X = np.sort(5*np.random.rand(40,1), axis=0)
y = np.sinc(X).ravel()
print X
print '---------------'
print y

y[::5] += 3 * (0.5 - np.random.rand(8))
print '------------------'
print y

svr_rbf = SVR(kernel='rbf',C=1e3,gamma=0.1)
svr_lin = SVR(kernel='linear',C=1e3)
svr_poly = SVR(kernel='poly',C=1e3,degree=2)
y_rbf = svr_rbf.fit(X, y).predict(X)
y_lin = svr_lin.fit(X, y).predict(X)
y_poly = svr_poly.fit(X, y).predict(X)

lw = 2
plt.scatter(X, y,color='darkorange',label='data')
plt.hold('on')
plt.plot(X,y_rbf,color='navy',lw=lw,label='RBF model')
plt.plot(X,y_lin,color='c',lw=lw,label='Linear model')
plt.plot(X,y_poly,color='cornflowerblue',lw=lw,label='Polynomial model')

plt.xlabel('data')
plt.ylabel('target')
plt.title('SVR')
plt.legend()
plt.show()