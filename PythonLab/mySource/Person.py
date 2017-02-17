import datetime

class Person:
    
    def __init__(self, name, surname, dob):
        self.name = name
        self.surname = surname
        self.dob = dob
        

p = Person("Charan", "Vallala", datetime.date(1986, 5, 25))

print(p)    
print(p.name)
print(p.dob)