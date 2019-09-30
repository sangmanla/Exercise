hours = float(input('Enter Hours:'))
rate = float(input('Enter Rate:'))
print('Pay:', hours * rate + (0 if hours <= 40 else (hours - 40) * rate * 0.5))