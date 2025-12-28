package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj_CRM7 {
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
        
        // Go to Leads
        driver.findElement(By.xpath("//a[text()='SALES']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Leads']")).click();
        Thread.sleep(3000);
        
        // Click first info icon (ℹ️)
        driver.findElement(By.xpath("(//td[@class='action-btn']//a)[1]")).click();
        Thread.sleep(2000);
        
        // Get phone from popup
        String phone = driver.findElement(By.xpath("//span[@class='phone']")).getText();
        System.out.println("Phone: " + phone);
        
        driver.quit();
    }
}