package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WorkingLinkTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWorkingLinks() throws InterruptedException {
        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");

        // Find the email and password input fields and the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        // Click on a specific menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id=\"MenusDashboard\"]/li[3]/ul/li[9]/a")).click();

        // Find the links with the given XPath expression
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='tab_1']//a[@target='_blank']"));

        // Loop through and print the links
        for (WebElement link : links) {
            System.out.println("Link: " + link.getAttribute("href"));
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
