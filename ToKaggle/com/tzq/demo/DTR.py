'''
Created on 2016-11-20

@author: Tan Zhuqing
'''


from sklearn.tree import DecisionTreeRegressor
from com.tzq.demo.LinearRegression import X_train, y_train,X_test,y_test, ss_y
from sklearn.metrics import mean_squared_error,mean_absolute_error

dtr = DecisionTreeRegressor()

dtr.fit(X_train, y_train)
dtr_y_predict = dtr.predict(X_test)

print 'R-squared value of DecisionTreeRegressor : ',dtr.score(X_test, y_test)
print 'The mean squared error of DecisionTreeRegressor:',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(dtr_y_predict))
print 'The mean absoluate error of DecisionTreeRegressor:',mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dtr_y_predict))