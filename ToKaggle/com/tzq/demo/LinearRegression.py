'''
Created on 2016-11-18

@author: Tan Zhuqing
'''

from sklearn.datasets import load_boston
from sklearn.cross_validation import train_test_split
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import SGDRegressor
from sklearn.metrics import r2_score,mean_squared_error,mean_absolute_error
from sklearn.svm import SVR
from sklearn.neighbors import KNeighborsRegressor

boston = load_boston()

X=boston.data
y=boston.target
X_train,X_test,y_train,y_test = train_test_split(X,y,random_state=33,test_size=0.25)

print 'The max terget value is',np.max(boston.target)
print 'The min target value is',np.min(boston.target)
print 'The average target value is',np.mean(boston.target)

ss_X = StandardScaler()
ss_y = StandardScaler()

X_train = ss_X.fit_transform(X_train)
X_test = ss_X.transform(X_test)
y_train = ss_y.fit_transform(y_train)
y_test = ss_y.transform(y_test)

lr = LinearRegression()
lr.fit(X_train, y_train)
lr_y_predict = lr.predict(X_test)

sgdr = SGDRegressor()
sgdr.fit(X_train, y_train)
sgdr_y_predict = sgdr.predict(X_test)

print 'The value of default measurement of LinearRegression is',lr.score(X_test, y_test)
print 'The value of R-squared of LinearRegression is',r2_score(y_test, lr_y_predict)
print 'The mean squared error of LinearRegression is',mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(lr_y_predict))
print 'The mean absolute error of LinearRegression is',mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(lr_y_predict))


print 'The value of default measurement of SGDRegressor is',sgdr.score(X_test, y_test)
print 'The value of R-squared of SGDRegressor is',r2_score(y_test, sgdr_y_predict)
print 'The mean squared error of SGDRegressor is',mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(sgdr_y_predict))
print 'The mean absolute error of SGDRegressor is',mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(sgdr_y_predict))

linear_svr = SVR(kernel='linear')
linear_svr.fit(X_train, y_train)
linear_svr_y_predict = linear_svr.predict(X_test)

print 'R-squared value of linear SVR is ',linear_svr.score(X_test, y_test)
print 'The mean squared error of linear SVR is ',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(linear_svr_y_predict))
print 'The mean absolute error of linear SVR is ',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(linear_svr_y_predict))


poly_svr = SVR(kernel='poly')
poly_svr.fit(X_train, y_train)
poly_svr_y_predict = poly_svr.predict(X_test)


print 'R-squared value of Poly SVR is ',poly_svr.score(X_test, y_test)
print 'The mean squared error of Poly SVR is ',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(poly_svr_y_predict))
print 'The mean absolute error of Poly SVR is ',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(poly_svr_y_predict))


rbf_svr = SVR(kernel='rbf')
rbf_svr.fit(X_train, y_train)
rbf_svr_y_predict = rbf_svr.predict(X_test)


print 'R-squared value of RBF SVR is ',rbf_svr.score(X_test, y_test)
print 'The mean squared error of RBF SVR is ',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(rbf_svr_y_predict))
print 'The mean absolute error of RBF SVR is ',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(rbf_svr_y_predict))


uni_knr = KNeighborsRegressor(weights='uniform')
uni_knr.fit(X_train, y_train)
uni_knr_y_predict = uni_knr.predict(X_test)

print 'R-squared value of uniform-weighted LneighorRegression: ',uni_knr.score(X_test, y_test)
print 'The mean squared error of uniform-weighted KNeighorRegression: ',mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(uni_knr_y_predict))
print 'The mean absolute error of uniform-weighted KNeighorRegression: ',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(uni_knr_y_predict))


dis_knr = KNeighborsRegressor(weights='distance')
dis_knr.fit(X_train, y_train)
dis_knr_y_predict = dis_knr.predict(X_test)

print 'R-squared value of distance-weighted LneighorRegression: ',uni_knr.score(X_test, y_test)
print 'The mean squared error of distance-weighted KNeighorRegression: ',mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dis_knr_y_predict))
print 'The mean absolute error of distance-weighted KNeighorRegression: ',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dis_knr_y_predict))
