# -*- coding: utf-8 -*-
'''
Created on 2017��1��3��

@author: Tan Zhuqing
'''

import csv,file


reader=csv.reader(file('filter_user.csv','rb'))
csvfile=file('9_1_data.csv','wb')
wrtiter1=csv.writer(csvfile)

csvfile=file('9_3_data.csv','wb')
wrtiter2=csv.writer(csvfile)

csvfile=file('9_7_data.csv','wb')
wrtiter3=csv.writer(csvfile)

csvfile=file('9_all_data.csv','wb')
wrtiter4=csv.writer(csvfile)



positive_user_item=set()
num=0
for line in reader:
    if num==0:
        num=num+1
        continue
    time_s=line[5].split(' ')
    time_slot=time_s[0].split('-')
    month=int(time_slot[1])
    day=int(time_slot[2])
    dis_day=(12-month)*30+(19-day)
    if dis_day>=10 and dis_day<=11:
        wrtiter1.writerow(line)
    if dis_day>=10 and dis_day<=13:
        wrtiter2.writerow(line)
    if dis_day>=10 and dis_day<=17:
        wrtiter3.writerow(line)
    if dis_day>=10:
        wrtiter4.writerow(line)
    num=num+1
    