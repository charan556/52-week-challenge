class Person:
    def __init__(self, name, surname):
        self.name = name
        self.surname = surname
    
    @property
    def fullname(self):
        return "%s %s" % (self.name, self.surname)
    
    @fullname.setter
    def fullname(self, value):
        name, surname = value.split(" ")
        self.name = name
        self.surname = surname

charan = Person("Charan", "Vallala")

# print(charan.fullname())  # use this if full name is not defined as property
print(charan.fullname)

charan.fullname = "Ishaan Vallala"
print(charan.fullname)
print(charan.name)
print(charan.surname)

print(dir(charan)) #inspecting an object

