package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM4 {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        // a. Open the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // b. Navigate to the URL
        driver.get("https://alchemy.hguy.co/crm");
        
        // Wait for page to load
        Thread.sleep(2000);
        
        // c. Find and select the username and password fields
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));
        
        // d. Enter login credentials
        usernameField.sendKeys("admin");
        passwordField.sendKeys("pa$$w0rd");
        
        // e. Click login
        WebElement loginButton = driver.findElement(By.id("bigbutton"));
        loginButton.click();
        
        // Wait for login to complete
        Thread.sleep(3000);
        
        // Verify login was successful
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);
        
        // Check if we're on the dashboard (login successful)
        if (currentUrl.contains("index.php?module=Home&action=index")) {
            System.out.println("✓ Login successful!");
        } else {
            System.out.println("✗ Login may have failed");
        }
        
        // Close browser
        driver.quit();
    }
}