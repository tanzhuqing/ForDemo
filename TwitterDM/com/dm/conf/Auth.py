# -*- coding: utf-8 -*-
'''
Created on 2017��1��10��

@author: Tan Zhuqing
'''

import twitter

import json

CONSUMER_KEY="59poZ3HXIDwgGFrdiDzMSaVAb"
CONSUMER_SECRET="asguPJUOxR4oLTjOHEjqxVhhXP3pSARi1OqyWfhOz5HNDuvqMw"
OAUTH_TOKEN="818809914604695556-FJWoWTCPltU5LttfUVhJQKmUBxCvKBl"
OAUTH_TOKEN_SECRET="uoQ76f8xauLIIJnFfHLpTK61X5u4WrjN1ojUqtZ6KsKNW"

auth=twitter.oauth.OAuth(OAUTH_TOKEN,OAUTH_TOKEN_SECRET,CONSUMER_KEY,CONSUMER_SECRET)

twitter_api=twitter.Twitter(auth=auth)

print(twitter_api)

WORLD_WOE_ID=1
US_WOE_ID=23424977

world_trends=twitter_api.trends.place(_id=WORLD_WOE_ID)
us_trends=twitter_api.trends.place(_id=US_WOE_ID)

#print(json.dumps(world_trends,indent=1))

#print(json.dumps(us_trends,indent=1))

world_trend_set=set([trend['name'] for trend in world_trends[0]['trends']])

us_trends_set=set([trend['name'] for trend in us_trends[0]['trends']])

common_trends=world_trend_set.intersection(us_trends_set)

print(common_trends)


