package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoutTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogout() throws InterruptedException {
        driver.get("http://magnus.jalatechnologies.com");

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        WebElement logout = driver.findElement(By.xpath("//a[@href='/Account/SignOut']"));
        logout.click();

        WebElement loginAfterLogout = driver.findElement(By.id("btnLogin"));

        // Check if the login button is displayed after logout
        Assert.assertTrue(loginAfterLogout.isDisplayed(), "Logout failed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
