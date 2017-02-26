# -*- coding: utf-8 -*-
'''
Created on 2016��12��9��

遍历

@author: Tan Zhuqing
'''
#遍历一个表示为邻接集的图结构的连通分量
def walk(G,s,S=set()):
    P,Q=dict(),set()
    P[s] = None
    Q.add(s)
    while Q:
        u=Q.pop()
        for v in G[u].difference(P,S):
            Q.add(v)
            P[v]=u
    return P

#找出图的连通分量
def components(G):
    comp = []
    seen = set()
    for u in G:
        if u in seen:continue
        C=walk(G, u)
        seen.update(C)
        comp.append(C)
    return comp
    

#递归的树遍历算法
def tree_walk(T,r):
    for u in T[r]:
        tree_walk(T, u)
        
#递归版的深度优先搜索
def rec_dfs(G,s,S=None):
    if S is None:S=set()
    S.add(s)
    for u in G[s]:
        if u in S:continue
        rec_dfs(G, s, S)
        
#迭代版深度优先搜索
def iter_dfs(G,s):
    S,Q=set(),[]
    Q.append(s)
    while Q:
        u = Q.pop()
        if u in S:continue
        S.add(u)
        Q.extend(G[u])
        yield u
        

#通用性的图遍历函数
def traverse(G,s,qtype=set):
    S,Q=set(),qtype()
    Q.add(s)
    while Q:
        u = Q.pop()
        if u in S:continue
        S.add(u)
        for v in G[u]:
            Q.add(v)
        yield u
        
#带时间戳的深度优先搜索
def dfs(G,s,d,f,S=None,t=0):
    if S is None:S=set()
    d[s]=t;t+=1
    S.add(s)
    for u in G[s]:
        if u in S:continue
        t=dfs(G,u,d,f,S,t)
    f[s]=t;t+=1
    return t

#基于深度优先搜索的拓扑排序
def dfs_topsort(G):
    S,res=set(),[]
    def recurse(u):
        if u in S:return
        S.add(u)
        for v in G[u]:
            recurse(v)
        res.append(u)
    for u in G:
        recurse(u)
    res.reverse()
    return res

#迭代深度的深度优先搜索
def iddfs(G,s):
    yielded = set()
    def recurse(G,s,d,S=None):
        if s not in yielded:
            yield s
            yielded.add(s)
        if d==0:return
        if S is None:S=set()
        S.add(s)
        for u in G[s]:
            if u in S:continue
            for v in recurse(G, s, d-1, S):
                yield v
    n=len(G)
    for d in range(n):
        if len(yielded)==n:break
        for u in recurse(G, s, d):
            yield