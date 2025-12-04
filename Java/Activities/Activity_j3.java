public class Activity_j3 {
    public static void main(String[] args) {
        // Test with 1,000,000,000 seconds (as given in the example)
        double ageInSeconds = 1000000000.0;
        
        // Create SpaceAge object
        SpaceAge person = new SpaceAge(ageInSeconds);
        
        // Display all ages
        person.displayAllAges();
        
        // Or access individual planet ages:
        System.out.println("\nIndividual access:");
        System.out.printf("Earth age: %.2f years\n", person.onEarth());
        System.out.printf("Mars age:  %.2f years\n", person.onMars());
    }
}