#https://www.hackerrank.com/challenges/defaultdict-tutorial/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
from collections import defaultdict
d = defaultdict(list)
ini = input().split(" ")

for x in range(int(ini[0])):
    d[input()].append(x+1)
for x in range(int(ini[1])):
    result = ''
    for y in d[input()]:
        result = result + str(y) + ' '
    print(result != '' and result or '-1')