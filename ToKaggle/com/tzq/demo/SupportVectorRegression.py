'''
Created on 2016-11-18

@author: Tan Zhuqing
'''

from sklearn.datasets import load_boston
from sklearn.cross_validation import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import mean_squared_error,mean_absolute_error
from sklearn.svm import SVR



boston = load_boston()

X=boston.data
y=boston.target
X_train,X_test,y_train,y_test = train_test_split(X,y,random_state=33,test_size=0.25)

ss_X = StandardScaler()
ss_y = StandardScaler()

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

