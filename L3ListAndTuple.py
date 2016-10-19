#!/usr/bin/env python3
# -*- coding: utf-8 -*-
classmates = ['Michael', 'Bob', 'Tracy']
classmates.sort()
print(classmates)
# 获取最后一个元素
print(classmates[-1])

# list是一个可变的有序表，可以往list中追加元素到末尾
classmates.append('Adam')

# 把元素插入到指定的位置
classmates.insert(1, 'Jack')

# 删除末尾元素并返回，类似于出栈
print(classmates.pop())
# 删除指定位置并返回
print(classmates.pop(1))

# 可以直接赋值
classmates[1] = 'Sarah'
# list里面的元素的数据类型也可以不同
L = ['Apple', 123, True]

# 嵌套
s = ['python', 'java', ['asp', 'php'], 'scheme']
# 切片
L = list(range(100))
# [0, 1, 2, 3, 4]
print(L[:5])
# [95, 96, 97, 98, 99]
print(L[-5:])
# 所有数每20取一个，[0, 20, 40, 60, 80]
print(L[::20])
# 原样复制
print(L[:])

# 带下标迭代
for i,v in enumerate(['a','b','c']):
    print(i,v)

# tuple一旦初始化就不能修改

# 定义一个元素的tuple,(1)是错误的
t = (1,)

# “可变的”tuple
t = ('a', 'b', ['A', 'B'])
t[2][0] = 'X'
t[2][1] = 'Y'