package FST_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM {
    public static void main(String[] args) {
        // Auto-downloads the correct ChromeDriver version
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        try {
            driver.get("http://alchemy.hguy.co/crm");
            
            // Get the title
            String actualTitle = driver.getTitle();
            String expectedTitle = "SuiteCRM";
            
            System.out.println("Actual title: '" + actualTitle + "'");
            System.out.println("Expected title: '" + expectedTitle + "'");
            
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("✓ Title matches exactly!");
            } else {
                System.out.println("✗ Title does not match!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}