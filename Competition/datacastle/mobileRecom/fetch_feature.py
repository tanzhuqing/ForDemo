# -*- coding: utf-8 -*-
'''
Created on 2017��1��3��

@author: Tan Zhuqing
'''

import csv

def fetch_feature(sample_filename,feature_filename,item_brand):
    reader=csv.reader(file(sample_filename,'rb'))
    csvfile=file(feature_filename,'wb')
    writer=csv.writer(csvfile)
    
    user_item_click=dict() #(u,i)clicks number
    user_item_hide=dict() #(u,i)add  number
    user_item_shop_basket=dict() #(u,i)add to cart 
    num=0
    user_item_pair=set()
    user_basket=dict()
    user_item_shop=dict()
    item_num=dict()
    item_user=dict()
    item_click=dict()
    item_basket=dict()
    item_hide=dict()
    user_buy_brand=dict()
    user_buy_item_brand=dict()
    user_item_num=dict()
    user_brand=dict()
    user_buy=dict()
    user_click=dict()
    user_hide=dict()
    user_item_time=dict()
    user_click_item_brand=dict()
    user_basket_item_brand=dict()
    category_buy=dict()
    category_click=dict()
    category_basket=dict()
    categery_hide=dict()
    
    ######################## init ##########################
    for line in reader:
        item_brand[line[1]]=line[4]
        user_hide[line[0]]=0
        user_click[line[0]]=0
        user_buy[line[0]]=0
        user_brand[line[0]]=set()
        user_item_num[line[0]]=set()
        user_item_click[(line[0],line[1])]=0
        user_item_hide[(line[0],line[1])]=0
        user_item_shop_basket[(line[0],line[1])]=0
        user_item_pair.add((line[0],line[1]))
        user_item_shop[(line[0],line[1])]=0
        item_num[line[1]]=0
        item_user[line[1]]=set()
        item_click[line[1]]=0
        item_basket[line[1]]=0
        item_hide[line[1]]=0
        user_buy_brand[line[0]]=set()
        user_buy_item_brand[(line[0],item_brand[line[1]])]=0
        user_click_item_brand[(line[0],item_brand[line[1]])]=0
        user_basket_item_brand[(line[0],item_brand[line[1]])]=0
        user_basket[line[0]]=0
        category_buy[item_brand[line[1]]]=0
        category_click[item_brand[line[1]]]=0
        category_basket[item_brand[line[1]]]=0
        categery_hide[item_brand[line[1]]]=0
        num=num+1


     
    ####################### static feature###############################
    for line in csv.reader(file(sample_filename,'rb')):
        if line[5].find('2014-12-17')<0:
            time_s=line[5].split(' ')
            time_slot=time_s[0].split('-')
            month=int(time_slot[1])
            day=int(time_slot[2])
            dis_day=(12-month)*30+(17-day) ##dis time
            if(line[0],line[1]) not in user_item_time:
                user_item_time[(line[0],line[1])]=set()
                user_item_time[(line[0],line[1])].add(dis_day)
            else:
                user_item_time[line[0],line[1]].add(dis_day)
            if line[2]=='1':
                #######################user item click####################################
                if(line[0],line[1]) not in user_item_click:
                    user_item_click[(line[0],line[1])]=1
                else:
                    user_item_click[(line[0],line[1])]=1+user_item_click[(line[0],line[1])]
                #############user click#########################
                user_click[line[0]]=user_click[line[0]]+1
                user_click_item_brand[(line[0],item_brand[line[1]])]=1+user_click_item_brand[(line[0],item_brand[line[1]])]
                 
                category_click[item_brand[line[1]]]=category_click[item_brand[line[1]]]+1
                 
                item_click[line[1]]=item_click[line[1]]+1
            if line[2]=='2':
                if(line[0],line[1]) not in user_item_hide:
                    user_item_hide[(line[0],line[1])]=1
                else:
                    user_item_hide[(line[0],line[1])]=1+user_item_hide[(line[0],line[1])]
                #############user click#########################
                user_hide[line[0]]=user_hide[line[0]]+1
     
                category_hide[item_brand[line[1]]]=category_hide[item_brand[line[1]]]+1
                 
                item_hide[line[1]]=item_hide[line[1]]+1
            if line[2]=='3':
                if(line[0],line[1]) not in user_item_shop_basket:
                    user_item_shop_basket[(line[0],line[1])]=1
                else:
                     user_item_shop_basket[(line[0],line[1])]=1+user_item_shop_basket[(line[0],line[1])]
                 #############user click#########################
                 user_basket[line[0]]=user_basket[line[0]]+1
                 user_basket_item_brand[(line[0],item_brand[line[1]])]=1+user_basket_item_brand[(line[0],item_brand[line[1]])]
     
                 category_basket[item_brand[line[1]]]=category_basket[item_brand[line[1]]]+1
                 
                 item_basket[line[1]]=item_basket[line[1]]+1
             if line[2]=='4':
                 if(line[0],line[1]) not in user_item_shop:
                     user_item_shop[(line[0],line[1])]=1
                 else:
                     user_item_shop[(line[0],line[1])]=1+user_item_shop[(line[0],line[1])]
                 #############user click#########################
                 user_buy[line[0]]=user_buy[line[0]]+1
                 item_num[line[1]]=item_num[line[1]]+1
                 item_user[line[1]].add(line[0])
                 category_buy[item_brand[line[1]]]=category_buy[item_brand[line[1]]]+1
                 user_buy_brand[line[0]].add(item_brand[line[1]])
                 user_buy_item_brand[(line[0],item_brand[line[1]])]=1+user_buy_item_brand[(line[0],item_brand[line[1]])]
            #################user item ###################
             user_item_num[line[0]].add(line[1])
            ###################user brand#########################
             user_brand[line[0]].add(item_brand[line[1]])
        
        
    for k in user_item_pair:
        if user_buy[k[0]]!=0:
            comm_item_ratio = float("%.2f"%(len(user_item_num[k[0]])/user_buy[k[0]]))
        else:
            comm_item_ratio=0
              
        if len(user_buy_brand[k[0]])!=0:
            comm_brand_buy_ratio=float("%.2f"%(len(user_brand[k[0]])/len(user_buy_brand[k[0]])))
        else:
            comm_brand_buy_ratio=0
        
        if catogery_buy[item_brand[k[1]]]!=0:
            catogery_click_buy_ratio=float("%.2f"%(category_click[item_brand[k[1]]]/category_buy[item_brand[k[1]]]))
        else:
            catogery_click_buy_ratio=0
            
        if catogery_buy[item_brand[k[1]]]!=0:
            catogery_basket_buy_ratio=float("%.2f"%(category_basket[item_brand[k[1]]]/category_buy[item_brand[k[1]]]))
        else:
            catogery_basket_buy_ratio=0
              
        if user_buy[k[0]]!=0:
            buy_catogery_ratio=float("%.2f"%(user_buy_item_brand[(k[0],item_brand[k[1]])]/user_buy[k[0]]))
        else:
            buy_catogery_ratio=0
          
        if user_click[k[0]]!=0:
            click_catogery_ratio=float("%.2f"%(user_item_brand[(k[0],item_brand[k[1]])]/user_click[k[0]]))
        else:
            click_catogery_ratio=0
          
        if user_basket[k[0]]!=0:
            basket_catogery_ratio=float("%.2f"%(user_basket_item_brand[(k[0],item_brand[k[1]])]/user_basket[k[0]]))
        else:
            basket_catogery_ratio=0
          
        if user_buy[k[0]]!=0:
            click_buy_user_ratio=float("%.2f"%(user_click[k[0]]/user_buy[k[0]]))
        else:
            click_buy_user_ratio=0
          
        if user_item_shop[k]!=0:
            basket_buy_ratio=float("%.2f"%(user_item_shop_basket[k]/user_item_shop[k]))
        else:
            basket_buy_ratio=0
          
        if user_buy[k[0]]!=0:
            basket_buy_user_ratio=float("%.2f"%(user_basket[k[0]]/user_buy[k[0]]))
        else:
            basket_buy_user_ratio=0
        #################用户点击与购物车的比例###################
        if user_basket[k[0]]!=0:
            ratio_click_basket=float("%.2f"%(user_click[k[0]]/user_basket[k[0]]))
        else:
            ratio_click_basket=0
        ######################用户收藏与购物的比例#################
        if user_buy[k[0]]!=0:
            ratio_hide_buy=float("%.2f"%(user_hide[k[0]]/user_buy[k[0]]))
        else:
            ratio_hide_buy=0
        ######################该类型商品收藏与购买的比例#################
        if catogery_buy[item_brand[k[1]]]!=0:
            catogry_hide_buy=float("%.2f"%(catogery_hide[item_brand[k[1]]]/catogery_buy[item_brand[k[1]]]))
        else:
            catogry_hide_buy=0
            
        sort_user_item_time=list(user_item_time[k])
        eraliest_time=sort_user_item_time[-1]
        latest_time=sort_user_item_time[0]
        
        writer.writerow((k[0],k[1],user_item_click[k],user_click[k[0]],usr_item_hide[k],user_hide[k[0]],\
        usr_item_shop_basket[k],user_basket[k[0]],usr_item_shop[k],user_buy[k[0]],item_num[k[1]],len(item_user[k[1]]),\
        len(user_buy_brand[k[0]]),user_buy_item_brand[(k[0],item_brand[k[1]])],len(user_item_num[k[0]]),len(user_brand[k[0]]),
        user_click_item_brand[(k[0],item_brand[k[1]])],user_basket_item_brand[(k[0],item_brand[k[1]])],catogery_click[item_brand[k[1]]],
        catogery_hide[item_brand[k[1]]],catogery_basket[item_brand[k[1]]],catogery_buy[item_brand[k[1]]],item_click[k[1]],
        item_hide[k[1]],item_basket[k[1]],
        buy_catogry_ratio,click_buy_user_ratio,basket_buy_ratio,click_basket,basket_buy_user_ratio,ratio_hide_buy,
        ratio_click_basket,click_catogry_ratio,basket_catogry_ratio,catogry_click_buy,catogry_basket_buy,
        catogry_hide_buy,comm_item_ratio,comm_brand_buy_ratio,eraliest_time,latest_time))
        
 
 
 if __name__=='__main__':
     item_brand=dict()
     fetch_feature('./17/17_1_data.csv','./17/17_1_data_feature.csv',item_brand)
            
        
          
          
                          
                
            
                 