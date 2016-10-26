__author__ = 'v_huyang01'
from sklearn import datasets

digits = datasets.load_digits()
print(digits.data)
print(digits.target)