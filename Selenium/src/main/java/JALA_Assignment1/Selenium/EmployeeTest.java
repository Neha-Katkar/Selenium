package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();

        // Maximize The window
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");
    }

    @Test
    public void testEmployeeRegistration() throws InterruptedException {
        // Find the email and password input fields and the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[2]")).click();
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[2]//ul//li/a")).click();

        driver.findElement(By.id("FirstName")).sendKeys("john");
        driver.findElement(By.id("LastName")).sendKeys("winslet");
        driver.findElement(By.id("EmailId")).sendKeys("john@gmail.com");
        driver.findElement(By.id("MobileNo")).sendKeys("1234567890");
        driver.findElement(By.id("DOB")).sendKeys("02/09/1999");
        driver.findElement(By.id("rdbMale")).click();
        driver.findElement(By.id("Address")).sendKeys("ABCD");
        driver.findElement(By.id("CountryId")).sendKeys("USA");
        driver.findElement(By.id("chkOtherCity")).click();
        driver.findElement(By.id("OtherCity")).sendKeys("Philadelphia");
        driver.findElement(By.id("chkSkill_5")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        
        Thread.sleep(1000);

        // Navigate to the search page
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[2]//ul//li[2]/a")).click();

        // Perform search
        driver.findElement(By.id("Name")).sendKeys("Purna");
        driver.findElement(By.id("MobileNo")).sendKeys("8019367116");
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(3000);

        // Clear search criteria
        driver.findElement(By.id("btnClear")).click();
        Thread.sleep(1000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
