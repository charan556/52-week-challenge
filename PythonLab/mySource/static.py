class Person:
    TITLES = ('Dr', 'Mr', 'Mrs', 'Ms')
    
    def __init__(self, name, surname):
        self.name = name
        self.surname = surname
        
    def fullname(self):
        return "%s %s" % (self.name, self.surname)
    
    @classmethod
    def allowed_titles_starting_with(cls, key):
        return [t for t in cls.TITLES if t.startswith(key)]

    @staticmethod
    def allowed_titles_ending_with(key): 
        return [t for t in Person.TITLES if t.endswith(key)]

jane = Person("Charan", "Sandya")

print(jane.fullname())

print(jane.allowed_titles_starting_with("M"))
print(Person.allowed_titles_starting_with("M"))

print(jane.allowed_titles_ending_with("s"))
print(Person.allowed_titles_ending_with("s"))
