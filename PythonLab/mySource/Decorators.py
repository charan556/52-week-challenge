
######################################
# # http://thecodeship.com/patterns/guide-to-python-function-decorators/
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

# Functions can return other functions
def compose_greet_func():
    def get_message():
        return "Hello there!"

    return get_message

greet_4 = compose_greet_func()
print(greet_4())

# Decorating a method
def p_decorate(func):
    def func_wrapper(name):
        return "<p>{0}</p>".format(func(name))
    return func_wrapper

@p_decorate
def get_text_2(name):
    return "lorem ipsum, {0} dolor sit amet".format(name)

print(get_text_2("John"))

#multiple decorators
def p_decorate_2(func):
    def func_wrapper(name):
        return "<p>{0}</p>".format(func(name))
    return func_wrapper

def strong_decorate(func):
    def func_wrapper(name):
        return "<strong>{0}</strong>".format(func(name))
    return func_wrapper

def div_decorate(func):
    def func_wrapper(name):
        return "<div>{0}</div>".format(func(name))
    return func_wrapper

@div_decorate
@p_decorate_2
@strong_decorate
def get_text_using_decorators(name):
    return "lorem ipsum, {0} dolor sit amet".format(name)

print(get_text_using_decorators("John"))
