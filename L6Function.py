#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# return None可以简写为return

# 定义一个什么事也不做的空函数
def nop():
    pass

# 数据类型检查可以用内置函数isinstance()实现
print(isinstance(1, (int, float)))

import math
# 返回多个值，但实际返回值是一个tuple
def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny


x, y = move(100, 100, 60, math.pi / 6)
print(x, y)

# 默认参数必须指向不变对象
def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    return L


# 可变参数
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum


print(calc(1, 2, 3))
# 将list/tuple转为可变参数
print(calc(*[1, 2, 3]))

# 关键字参数允许你传入0个或任意个含参数名的参数，这些关键字参数在函数内部自动组装为一个dict
def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)


person('tom', 20, city='Beijing')

# 简化可变参数调用
# kw获得的dict是extra的一份拷贝，对kw的改动不会影响到函数外的extra
extra = {'city': 'Beijing', 'job': 'Engineer'}
person('tom', 20, **extra)

# 命名关键字参数
# 命名关键字参数需要一个特殊分隔符*，*后面的参数被视为命名关键字参数
# 命名关键字可以有默认值
def people(name, age, *, city='Beijing', job):
    print(name, age, city, job)
people('Jack', 24, city='Beijing', job='Engineer')

# 如果函数定义中已经有了一个可变参数，后面跟着的命名关键字参数就不再需要一个特殊分隔符*了
def man(name, age, *args, city, job):
    print(name, age, args, city, job)