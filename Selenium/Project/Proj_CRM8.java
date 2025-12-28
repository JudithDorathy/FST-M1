package FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Proj_CRM8 {
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
        
        // Go to Accounts
        driver.findElement(By.xpath("//a[text()='SALES']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Accounts']")).click();
        Thread.sleep(3000);
        
        // Get all rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='list view']/tbody/tr"));
        
        System.out.println("First 5 odd-numbered rows (Name column):\n");
        
        int oddRowCount = 0;
        int rowIndex = 1; // Start from 1 for human-readable numbering
        
        for (WebElement row : allRows) {
            // Check if it's a data row (not header/footer)
            String rowClass = row.getAttribute("class");
            if (rowClass.contains("oddListRow")) {
                oddRowCount++;
                
                if (oddRowCount <= 5) {
                    // Get the Name from 3rd column (based on your screenshot)
                    // In your table: Name is in 3rd column (1. Checkbox, 2. empty, 3. Name)
                    String name = row.findElement(By.xpath("./td[3]")).getText();
                    
                    // Also get other info if needed
                    String city = row.findElement(By.xpath("./td[4]")).getText();
                    String phone = row.findElement(By.xpath("./td[6]")).getText();
                    
                    System.out.println("Row " + rowIndex + ":");
                    System.out.println("  Name: " + name);
                    System.out.println("  City: " + city);
                    System.out.println("  Phone: " + phone);
                    System.out.println();
                }
            }
            rowIndex++;
        }
        
        driver.quit();
    }
}