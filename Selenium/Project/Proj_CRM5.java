package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM5 {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        
        // a. Open browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // b. Navigate and login
        driver.get("http://alchemy.hguy.co/crm");
        
        // Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        
        // Wait for navigation menu to load
        Thread.sleep(3000);
        
        // c. Get color of navigation menu
        // Find the navigation menu element
        WebElement navMenu = driver.findElement(By.id("ajaxHeader"));

        
        String backgroundColor = navMenu.getCssValue("background-color");
        String color = navMenu.getCssValue("color");
        
        System.out.println("Navigation Menu Colors:");
        System.out.println("Background Color: " + backgroundColor);
        System.out.println("Text Color: " + color);
        
        // d. Close browser
        driver.quit();
    }
}