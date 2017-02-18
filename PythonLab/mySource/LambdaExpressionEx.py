# https://www.youtube.com/watch?v=UKdy9eQU4q4
from ansible.modules.core.packaging.os.apt import remove
from __builtin__ import int
def square(x): return x * x
print(square(10))

square_2 = lambda x: x * x
print(square_2(10))

# sum of three numbers using lambda exp
def sumRGBB(r, g, b): return r + g + b
sum_rgb = lambda r, g, b:r + g + b

print(sum_rgb(1, 2, 3))

# remove duplicates using lambda exp
remove_dups = lambda iterable: set(iterable)
print(remove_dups("rooot"))
print(remove_dups([1, 1, 3, 4, 12, 3, 2]))

#even numbers
def evens(lst):
    
    even = []
    for num in lst:
        if num % 2 == 0:
            even.append(num)
        
    return even
    
    
print(evens(range(100)))
    
#lambda expression
def evens_lambda(lst):
    
    even = []
    is_even = lambda n: n % 2 == 0
    
    for num in lst:
        if is_even(num):
            even.append(num)
    
    return even

print(evens_lambda(range(10)))

#one line - lambda  - even numbers
l_evens = lambda lst:filter(lambda num: num % 2 == 0, lst)

print(l_evens(range(100)))
