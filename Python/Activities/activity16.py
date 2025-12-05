class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Toyota", "Innova", "2022", "Manual", "White")
car2 = Car("Maruti", "Baleno", "2025", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2022", "Automatic", "Black")

car3.accelerate()
car2.stop()