

public class Activity_j1 {
    public static void main(String[] args) {
        // Create a Car object
        Car myCar = new Car();
        
        // Initialize car properties
        myCar.color = "Red";
        myCar.transmission = "Automatic";
        myCar.make = 2022;
        
        // Display car characteristics
        myCar.displayCharacteristics();
        
        // Test car methods
        myCar.accelarate();
        myCar.brake();
    }
}