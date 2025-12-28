package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM3 {
    public static void main(String[] args) {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        // Open browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to URL
        driver.get("http://alchemy.hguy.co/crm");
        
        // Get the first copyright text from footer
        // Look for text containing "Supercharged by" or "Powered By"
        WebElement copyright = driver.findElement(By.xpath("//a[contains(text(),'Supercharged') or contains(text(),'Powered')]"));
        
        // Get the text
        String copyrightText = copyright.getText();
        
        // Print the text to console
        System.out.println("First Copyright Text: " + copyrightText);
        
        // Close browser
        driver.quit();
    }
}