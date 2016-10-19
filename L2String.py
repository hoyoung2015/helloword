#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# Python 3版本中，字符串是以Unicode编码的

# 获取ASCII码
print(ord('A'))
# 由ASCII得到字符
print(chr(65))
# 16进制中文Unicode编码
print('\u4e2d\u6587')

# 纯英文的str可以用ASCII编码为bytes，内容是一样的，含有中文的str可以用UTF-8编码为bytes。
# 含有中文的str无法用ASCII编码，因为中文编码的范围超过了ASCII编码的范围，Python会报错。
# 转换为bytes
print(b'abc', 'abc'.encode('ascii'))
print(b'\xe4\xb8\xad\xe6\x96\x87', '中文'.encode('utf-8'))

# 计算字符长度
# 1个中文字符经过UTF-8编码后通常会占用3个字节，而1个英文字符只占用1个字节。
print(len('abc'))
print(len('中文'))
print(len('中文'.encode('utf-8')))

# 字符串格式化
print('Hi, %s, you have $%d.' % ('Michael', 1000000))
# 格式化转义
print('growth rate: %d %%' % 7)
