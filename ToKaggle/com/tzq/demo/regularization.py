'''
Created on 2016-11-22

@author: Tan Zhuqing
'''
from pip._vendor.colorama.win32 import handles

X_train = [[6],[8],[10],[14],[18]]
y_train = [[7],[9],[13],[17.5],[18]]

from sklearn.linear_model import LinearRegression
regression = LinearRegression()
regression.fit(X_train, y_train)

import numpy as np

xx = np.linspace(0, 26, 100)
xx = xx.reshape(xx.shape[0],1)
yy = regression.predict(xx)

import matplotlib.pyplot as plt
plt.scatter(X_train, y_train)
plt1,=plt.plot(xx,yy,label='Degree=1')



print 'The R-squared value of Linear Regression performing on the training data is ',regression.score(X_train, y_train)

from sklearn.preprocessing import PolynomialFeatures
poly2= PolynomialFeatures(degree=2)
X_train_poly2 = poly2.fit_transform(X_train)

regression_poly2 = LinearRegression()
regression_poly2.fit(X_train_poly2, y_train)
xx_poly2 = poly2.transform(xx)
yy_poly2 = regression_poly2.predict(xx_poly2)


plt2,=plt.plot(xx,yy_poly2,label='Degree=2')



print 'The R-squared value of Polynominal Regressor(Degree=2) performing on the training data is ',regression_poly2.score(X_train_poly2, y_train)


poly4 = PolynomialFeatures(degree=4)
X_train_poly4 = poly4.fit_transform(X_train)
regression_poly4 = LinearRegression()
regression_poly4.fit(X_train_poly4, y_train)

xx_poly4 = poly4.transform(xx)
yy_poly4 = regression_poly4.predict(xx_poly4)

plt4,=plt.plot(xx,yy_poly4,label='Degree=4')

plt.axis([0,25,0,25])
plt.xlabel('Diameter of Pizza')
plt.ylabel('Priceof Pizza')
plt.legend(handles=[plt1,plt2,plt4])
plt.show()

print 'The R-squared value of Polynominal Regressor(Degree=4) performing on the training data is ',regression_poly4.score(X_train_poly4, y_train)

X_test = [[6],[8],[11],[16]]
y_test = [[8],[12],[15],[18]]

print regression.score(X_test,y_test)

X_test_poly2 = poly2.transform(X_test)
print regression_poly2.score(X_test_poly2, y_test)

X_test_poly4 = poly4.transform(X_test)
print regression_poly4.score(X_test_poly4,y_test)

from sklearn.linear_model import Lasso

lasso_poly4 = Lasso()
lasso_poly4.fit(X_train_poly4, y_train)
print lasso_poly4.score(X_test_poly4, y_test)
print lasso_poly4.coef_

from sklearn.linear_model import Ridge
ridge_poly4 = Ridge()

ridge_poly4.fit(X_train_poly4, y_train)
print ridge_poly4.score(X_test_poly4, y_test)
print ridge_poly4.coef_
