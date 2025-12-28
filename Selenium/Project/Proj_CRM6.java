package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Login
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        Thread.sleep(3000);
        
        // Find ACTIVITIES menu
        try {
            WebElement activitiesMenu = driver.findElement(By.xpath("//a[text()='ACTIVITIES']"));
            
            // Check existence and clickability
            boolean isDisplayed = activitiesMenu.isDisplayed();
            boolean isEnabled = activitiesMenu.isEnabled();
            boolean isClickable = isDisplayed && isEnabled;  // Fixed: evaluate separately
            
            System.out.println("=== Menu Check Results ===");
            System.out.println("Displayed: " + isDisplayed);
            System.out.println("Enabled: " + isEnabled);
            System.out.println("Clickable: " + isClickable);
            
            if (isClickable) {
                System.out.println("\n✓ SUCCESS: 'ACTIVITIES' menu exists and is clickable");
            } else {
                System.out.println("\n✗ FAILED: 'ACTIVITIES' menu is not clickable");
            }
            
        } catch (Exception e) {
            System.out.println("✗ ERROR: 'ACTIVITIES' menu not found: " + e.getMessage());
        }
        
        driver.quit();
    }
}