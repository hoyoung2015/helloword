#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# dict字典
# dict的key必须是不可变对象,字符串、整数等都是不可变的

d = {'Michael': 95, 'Bob': 75, 'Tracy': 85}

# 迭代key
for x in d:
    print(x)
# 迭代value
for x in d.values():
    print(x)
for k, v in d.items():
    print(k, '=', v)

# 列表生成式
L = [k + '=' + str(v) for k, v in d.items()]
# ['Bob=75', 'Michael=95', 'Tracy=85']

d['Adam'] = 67
# 判断key是否存在
print('Thomas' in d)
# 如果key不存在返回None
print(d.get('Thomas'))
# 如果key不存在返回自定义的-1
print(d.get('Thomas', -1))
# 删除,key不存在会报错
print(d.pop('Adam'))




# set
# set和dict类似，也是一组key的集合，但不存储value。由于key不能重复，所以，在set中，没有重复的key。
# 重复元素在set中自动被过滤
s = set([1, 1, 2, 2, 3, 3])
# s.add(4)
s.add(4)
# 通过remove(key)方法可以删除元素
s.remove(4)

# set可以看成数学意义上的无序和无重复元素的集合，因此，两个set可以做数学意义上的交集、并集等操作
s1 = set([1, 2, 3])
s2 = set([2, 3, 4])
print(s1 & s2)
print(s1 | s2)