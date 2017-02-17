def divide(x,y):
    try:
        result  = x/y
    except ZeroDivisionError:
        print('division error')
    else:
        print('result is ',result)
    finally:
        print('Good bye world')

divide(2, 1)        
divide(2, 0)
