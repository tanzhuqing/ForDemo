#!/usr/bin/python
# encoding: utf-8

'''
Created on 2016��8��7��

@author: tanzhuqing
'''


import json
import numpy
from pandas import  DataFrame
path="D:/workspace/pydata-book-master/ch02/usagov_bitly_data2012-03-16-1331923249.txt"
records = [json.loads(line) for line in open(path)]

frame = DataFrame(records)

print frame