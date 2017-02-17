class Person:
    deceased = False
    pets = []
    
    def mar_as_deceased(self):
        self.deceased = True
        
    def add_pet(self, pet):
        self.pets.append(pet)
               
p = Person()
print(p.deceased)        
p.mar_as_deceased()
print(p.deceased)
p.add_pet("cat")
print(p.pets)
