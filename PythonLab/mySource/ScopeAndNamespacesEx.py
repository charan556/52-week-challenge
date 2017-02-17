a = 0

if a == 0:
    b = 1
    
def my_func(c):
    d = 3
    print(c)
    print(d)

def my_func2():
    global a
    a = 3
    print(a)
     
    
# my_func(7)
my_func2()


print("Step1: ", a)
print("Step2: ", b)     
print("step3: ", a)   


