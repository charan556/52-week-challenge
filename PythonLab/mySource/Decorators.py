
######################################
## http://thecodeship.com/patterns/guide-to-python-function-decorators/
######################################

# Assign functions to variables
def greet(name):
    return "hello " + name

greet_someone = greet
print(greet_someone("Charan"))

# Define functions inside other FunctionS
def greet_2(name):
    def get_message():
        return "Hello "

    result = get_message() + name
    return result

print(greet_2("Charan2"))

# Functions can be passed as arguments to other functions
def greet_3(name):
    return "Hello " + name 

def call_func(func):
    other_name = "Charan3"
    return func(other_name)  

print(call_func(greet_3))

#Functions can return other functions
def compose_greet_func():
    def get_message():
        return "Hello there!"

    return get_message

greet_4 = compose_greet_func()
print(greet_4())