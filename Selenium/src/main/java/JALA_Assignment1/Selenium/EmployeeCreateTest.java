package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeCreateTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testEmployeeCreation() throws InterruptedException {
        driver.get("http://magnus.jalatechnologies.com");

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(1000);

        // Navigate to the employee creation page
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[2]")).click();
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[2]//ul//li/a")).click();

        // Fill in employee details
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Winslet");
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

        // Add any assertions or validation as needed
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
