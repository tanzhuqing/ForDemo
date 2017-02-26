'''
Created on 2016-11-20

@author: Tan Zhuqing
'''

from com.tzq.demo.LinearRegression import X_train, y_train,X_test,y_test, ss_y,\
    boston
from sklearn.metrics import mean_squared_error,mean_absolute_error
from sklearn.ensemble import RandomForestRegressor,ExtraTreesRegressor,GradientBoostingRegressor
import numpy as np

rft = RandomForestRegressor()
rft.fit(X_train,y_train)
rft_y_predict = rft.predict(X_test)
print'==========================================='

print 'R-squared value of RandomForestRegressor : ',rft.score(X_test,y_test)
print 'The mean squared error of RandomForestRegressor:',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(rft_y_predict))
print 'The mean absolute error of RandomForestRegressor:',mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(rft_y_predict))

etr = ExtraTreesRegressor()
etr.fit(X_train,y_train)
etr_y_predict = etr.predict(X_test)

print 'R-squared value of ExtraTreesRegressor : ',etr.score(X_test,y_test)
print 'The mean squared error of ExtraTreesRegressor:',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(etr_y_predict))
print 'The mean absolute error of ExtraTreesRegressor:',mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(etr_y_predict))


gbr = GradientBoostingRegressor()
gbr.fit(X_train, y_train)
gbr_y_predict = gbr.predict(X_test)

print 'R-squared value of GradientBoostingRegressor : ',gbr.score(X_test,y_test)
print 'The mean squared error of GradientBoostingRegressor:',mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(gbr_y_predict))
print 'The mean absolute error of GradientBoostingRegressor:',mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(gbr_y_predict))

print np.sort(zip(etr.feature_importances_,boston.feature_names),axis=0)