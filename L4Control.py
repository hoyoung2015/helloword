#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 条件判断
age = 3
if age >= 18:
    print('adult')
elif age >= 6:
    print('teenager')
else:
    print('kid')

# 只要x是非零数值、非空字符串、非空list等，就判断为True，否则为False
x = 'a'
if x:
    print('True')

# 循环
# for x in ...循环就是把每个元素代入变量x，然后执行缩进块的语句
names = ['Michael', 'Bob', 'Tracy']
for name in names:
    print(name)

# range(101)就可以生成0-100的整数序列
sum = 0
for x in range(101):
    sum = sum + x
print(sum)

sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print(sum)