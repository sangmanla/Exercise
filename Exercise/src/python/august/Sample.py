test = input('Input number :')
try :
    iVal = int(test)
except:
    iVal = -1

if iVal == -1 :
    print('That is not a number.')
else :
    print('That is a number :', test)