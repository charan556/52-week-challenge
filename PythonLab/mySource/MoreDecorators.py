# Person decorator
def p_decorator(func):
    def func_wrapper(self):
        return "<p>{0}</p>".format(func(self))
    return func_wrapper

class Person(object):
    def __init__(self):
        self.name = "Charan"
        self.surname = "Vallala"
        
    @p_decorator
    def fullname(self):
        return self.name + " " + self.surname

my_person = Person()
print(my_person.fullname())        

# passing arguments to decorator
def tags(tag_name):
    def tags_decorator(func):
        def func_wrapper(name):
            return "<{0}>{1}<{0}>".format(tag_name, func(name))
        return func_wrapper
    return tags_decorator

@tags("div")
def get_text(name):
    return "Hello " + name

print(get_text("Charan Vallala"))
