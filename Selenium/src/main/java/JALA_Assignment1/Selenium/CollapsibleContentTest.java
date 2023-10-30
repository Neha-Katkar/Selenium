package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CollapsibleContentTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://magnus.jalatechnologies.com");
    }

    @Test
    public void testLoginAndSingleCollapse() throws InterruptedException {
        // Find the email and password input fields and the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        // Click on the menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);

        // Single collapse
        driver.findElement(By.xpath("//ul[@id=\"MenusDashboard\"]/li[3]/ul/li[4]/a")).click();
        WebElement single = driver.findElement(By.xpath("//*[@id='headingOne']/h4/a"));
        single.click();

        // Get the text of the heading element
        String headingText = single.getText();

        // Print the heading text
        System.out.println("The Single Collapse: " + headingText);
        Thread.sleep(2000);
    }

    @Test
    public void testMultipleCollapses() throws InterruptedException {
        // Multiple collapses
        driver.findElement(By.xpath("//*[@id='frmCollapse']//ul/li[2]/a")).click();
        Thread.sleep(2000);

        WebElement headingFour = driver.findElement(By.xpath("//*[@id='headingFour']/h4/a"));
        headingFour.click();
        String headingText1 = headingFour.getText();

        // Print the heading text
        System.out.println("The Multiple Collapse 1: " + headingText1);
        Thread.sleep(1000);

        WebElement headingFive = driver.findElement(By.xpath("//*[@id='headingFive']/h4/a"));
        headingFive.click();
        String headingText2 = headingFive.getText();

        // Print the heading text
        System.out.println("The Multiple Collapse 2: " + headingText2);
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}
