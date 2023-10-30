package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestNGTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");

        // Find the email and password input fields and the login button
        WebElement email = driver.findElement(By.xpath("//input[@id='UserName']"));
        email.sendKeys("training@jalaacademy.com");

        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("jobprogram");

        // Click the Signin
        WebElement signin = driver.findElement(By.xpath("//button[@id='btnLogin']"));
        signin.click();

        // Wait for a moment to allow the login process to complete
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the login was successful
        String expectedURL = "https://magnus.jalatechnologies.com/Home/Index";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login failed!");
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}
