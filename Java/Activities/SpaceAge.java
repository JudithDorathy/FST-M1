public class SpaceAge {
    // Constants for Earth orbital period in seconds
    private static final double EARTH_ORBITAL_PERIOD_SECONDS = 31557600.0;
    
    // Orbital periods relative to Earth years
    private static final double MERCURY_ORBITAL_PERIOD = 0.2408467;
    private static final double VENUS_ORBITAL_PERIOD = 0.61519726;
    private static final double MARS_ORBITAL_PERIOD = 1.8808158;
    private static final double JUPITER_ORBITAL_PERIOD = 11.862615;
    private static final double SATURN_ORBITAL_PERIOD = 29.447498;
    private static final double URANUS_ORBITAL_PERIOD = 84.016846;
    private static final double NEPTUNE_ORBITAL_PERIOD = 164.79132;
    
    private double ageInSeconds;
    
    // Constructor
    public SpaceAge(double ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }
    
    // Calculate age on Earth
    public double onEarth() {
        return ageInSeconds / EARTH_ORBITAL_PERIOD_SECONDS;
    }
    
    // Calculate age on Mercury
    public double onMercury() {
        return onEarth() / MERCURY_ORBITAL_PERIOD;
    }
    
    // Calculate age on Venus
    public double onVenus() {
        return onEarth() / VENUS_ORBITAL_PERIOD;
    }
    
    // Calculate age on Mars
    public double onMars() {
        return onEarth() / MARS_ORBITAL_PERIOD;
    }
    
    // Calculate age on Jupiter
    public double onJupiter() {
        return onEarth() / JUPITER_ORBITAL_PERIOD;
    }
    
    // Calculate age on Saturn
    public double onSaturn() {
        return onEarth() / SATURN_ORBITAL_PERIOD;
    }
    
    // Calculate age on Uranus
    public double onUranus() {
        return onEarth() / URANUS_ORBITAL_PERIOD;
    }
    
    // Calculate age on Neptune
    public double onNeptune() {
        return onEarth() / NEPTUNE_ORBITAL_PERIOD;
    }
    
    // Method to display all ages
    public void displayAllAges() {
        System.out.printf("Age in seconds: %.0f\n", ageInSeconds);
        System.out.printf("Earth:   %.2f years\n", onEarth());
        System.out.printf("Mercury: %.2f years\n", onMercury());
        System.out.printf("Venus:   %.2f years\n", onVenus());
        System.out.printf("Mars:    %.2f years\n", onMars());
        System.out.printf("Jupiter: %.2f years\n", onJupiter());
        System.out.printf("Saturn:  %.2f years\n", onSaturn());
        System.out.printf("Uranus:  %.2f years\n", onUranus());
        System.out.printf("Neptune: %.2f years\n", onNeptune());
    }
}