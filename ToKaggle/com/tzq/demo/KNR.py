'''
Created on 2016-11-18

@author: Tan Zhuqing
'''

from sklearn.neighbors import KNeighborsRegressor
from com.tzq.demo.LinearRegression import X_train, y_train, X_test,y_test, ss_y
from sklearn.metrics import mean_squared_error,mean_absolute_error

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
