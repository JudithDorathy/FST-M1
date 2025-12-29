package FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1n {
    WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        // Auto-download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testTrainingSupport() {
        driver.get("https://training-support.net");
        
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "Training Support");
        
        driver.findElement(By.linkText("About Us")).click();
        
        String newTitle = driver.getTitle();
        System.out.println("New page title is: " + newTitle);
        Assert.assertEquals(newTitle, "About Training Support");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}