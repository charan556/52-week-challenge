class Person:
    def __init__(self, height):
        self.height = height
        
    def get_height(self):
        return self.height
    
    def set_height(self, height):
        self.height = height

charan = Person(153)

charan.height += 1
charan.set_height(charan.height + 1)

print(charan.get_height())
