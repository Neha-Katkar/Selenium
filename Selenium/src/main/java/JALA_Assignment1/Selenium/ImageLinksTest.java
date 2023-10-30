package JALA_Assignment1.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImageLinksTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Chrome WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginToApplication() throws InterruptedException {
        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void navigateToImageLinks() throws InterruptedException {
        // Click on the menu item to navigate to the target page
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id=\"MenusDashboard\"]/li[3]/ul/li[9]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"frmLinks\"]//li[3]/a")).click();
    }

    @Test(priority = 3)
    public void retrieveImageLinks() {
        List<WebElement> imagelinks = driver.findElements(By.xpath("//div[@id='tab_3']//a[@target='_blank']"));
        System.out.println("No of links: " + imagelinks.size());

        // Loop through and print the links
        for (WebElement link : imagelinks) {
            System.out.println("Link: " + link.getAttribute("href"));
        }
    }

    @Test(priority = 4)
    public void clickImageLinks() {
        WebElement link1 = driver.findElement(By.xpath("//*[@id=\"tab_3\"]/div/a[1]/img"));
        link1.click();

        WebElement link2 = driver.findElement(By.xpath("//*[@id=\"tab_3\"]/div/a[2]/img"));
        link2.click();

        WebElement link3 = driver.findElement(By.xpath("//*[@id=\"tab_3\"]/div/a[3]/img"));
        link3.click();

        WebElement link4 = driver.findElement(By.xpath("//*[@id=\"tab_3\"]/div/a[4]/img"));
        link4.click();
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
