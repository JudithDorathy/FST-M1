public class Car {
    // Variables
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    
    // Constructor
    public Car() {
        tyres = 4;
        doors = 4;
    }
    
    // Method to display car characteristics
    public void displayCharacteristics() {
        System.out.println("Car Characteristics:");
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make Year: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }
    
    // Method to accelerate the car
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }
    
    // Method to brake the car
    public void brake() {
        System.out.println("Car has stopped.");
    }
}