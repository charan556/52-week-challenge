class Item(object):
    """Base class"""
    
    @property
    def name(self):
        if not hasattr(self, '_name'):
            self._name = ''
        return self._name
    
    @name.setter
    def name(self, value):
        self._name = value
    
    def __init__(self, name, value):
        self.name = name
        self.value = value
    
    def __str__(self):
        return "{} : {}".format(self.name, self.value)

item_01 = Item("book", "pen")
print(item_01)
