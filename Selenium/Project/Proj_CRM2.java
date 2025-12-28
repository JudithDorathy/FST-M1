package FST_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Proj_CRM2 {
	 public static void main(String[] args) throws InterruptedException {
	        // Setup ChromeDriver automatically
	        WebDriverManager.chromedriver().setup();
	        
	        // Open browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // Navigate to URL
	        driver.get("http://alchemy.hguy.co/crm");
	        
	        // Wait for page to load
	        Thread.sleep(2000);
	        
	        // Find the header image (using the most likely selector)
	        WebElement image = driver.findElement(By.xpath("//img[contains(@src,'logo')]"));
	        
	        // Get the image URL
	        String imageUrl = image.getAttribute("src");
	        
	        // Print the URL to console
	        System.out.println("Header Image URL: " + imageUrl);
	        
	        // Close browser
	        driver.quit();
	    }
}
