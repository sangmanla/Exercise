#https://www.hackerrank.com/challenges/write-a-function/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
def is_leap(year):
    return year % 4 == 0 and (year % 100 != 0  or year % 400 == 0)

year = int(input())
print(is_leap(year))