package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Proj_CRM9 {
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
        
        // Navigate to Leads
        driver.findElement(By.xpath("//a[text()='SALES']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Leads']")).click();
        Thread.sleep(3000);
        
        // Get column headers
        List<WebElement> headers = driver.findElements(By.xpath("//table[@class='list view']/thead//th/a"));
        System.out.println("Table Columns: ");
        for (int i = 0; i < headers.size(); i++) {
            System.out.println((i + 1) + ". " + headers.get(i).getText());
        }
        System.out.println();
        
        // Print first 10 rows
        List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@class,'oddListRow') or contains(@class,'evenListRow')]"));
        
        System.out.println("FIRST 10 LEADS:");
        System.out.println("══════════════════════════════════════════════════");
        
        for (int i = 0; i < Math.min(10, rows.size()); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            System.out.println("Lead #" + (i + 1) + ":");
            System.out.println("  Name: " + cells.get(2).getText());  // 3rd column
            System.out.println("  User: " + cells.get(7).getText());  // 8th column
            
            // Optional: Print all columns
            // for (int j = 0; j < cells.size(); j++) {
            //     if (j < headers.size()) {
            //         System.out.println("  " + headers.get(j).getText() + ": " + cells.get(j).getText());
            //     }
            // }
            System.out.println();
        }
        
        driver.quit();
    }
}