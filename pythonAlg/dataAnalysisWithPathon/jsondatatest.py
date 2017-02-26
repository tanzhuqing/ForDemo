#!/usr/bin/python
# encoding: utf-8
'''

Created on 2016年8月7日

@author: tanzhuqing
'''
import json
from _collections import defaultdict

from collections import Counter

path="D:/workspace/pydata-book-master/ch02/usagov_bitly_data2012-03-16-1331923249.txt"
records = [json.loads(line) for line in open(path)]

print(records[0])
print(records[0]['tz'])


time_zones = [rec['tz'] for rec in records if 'tz' in rec ]

print time_zones[:10]


def get_counts(sequence):
    counts = defaultdict(int)
    for x in sequence:
        counts[x] += 1
    return counts


counts = get_counts(time_zones)
print counts['America/New_York']

def top_counts(count_dict, n=10):
    value_key_pairs = [(count,tz) for tz,count in count_dict.items()]
    value_key_pairs.sort()
    return value_key_pairs[-n:]

print top_counts(counts)

counts = Counter(time_zones)
print counts.most_common(10)
