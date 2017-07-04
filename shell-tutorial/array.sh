#!/usr/bin/env bash
#数组操作

arr=(value0 value1 value2)

#1)获取数组元素
#此时取的是第一个元素
echo ${arr}
#适用@或者*得到的是所有元素
echo ${arr[*]}
echo ${arr[@]}

#获取元素，必须有中括号
echo ${arr[0]}
echo ${arr[1]}

#1.1)分片，不包括结束下标
echo "split:${arr[@]:0:2}"

#2)元素赋值
arr[0]="hello"

echo ${arr[0]}
#2.1)模式替换
echo "replace:${arr[@]/hello/value0}"

#3)获取数组长度
echo ${#arr[*]}
echo ${#arr[@]}

#3.1)获得数组单个元素的长度
echo ${#arr[0]}
echo ${#arr[1]}



#4)数组遍历
for v in ${arr[*]};do
    echo "for in:${v}"
done

#5)删除
#删除单个元素，元素长度会变短
unset arr[1] && echo "clear one:${arr[*]}"
#清空整个数组
unset arr && echo "clear all:${arr[*]}"

