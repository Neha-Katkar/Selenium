package JALA_Assignment1.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatuscodesTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://magnus.jalatechnologies.com");
        driver.manage().window().maximize();

        // Log in
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatusCodeLinks() {
        // Click on the menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//ul[@id='MenusDashboard']/li[3]/ul/li[9]/a")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id='frmLinks']//li[4]/a")).click();
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='tab_4']//a[@target='_blank']"));
        System.out.println("No of links: " + links.size());

        // Loop through and print the links
        for (WebElement link : links) {
            System.out.println("Link: " + link.getAttribute("href"));
        }

        WebElement First = driver.findElement(By.xpath("//*[@id='tab_4']/div/a[1]"));
        First.click();
        System.out.println("First Link: " + First.getText());

        WebElement Second = driver.findElement(By.xpath("//*[@id='tab_4']/div/a[2]"));
        Second.click();
        System.out.println("Second Link: " + Second.getText());

        WebElement Third = driver.findElement(By.xpath("//*[@id='tab_4']/div/a[3]"));
        Third.click();
        System.out.println("Third Link: " + Third.getText());

        WebElement Fourth = driver.findElement(By.xpath("//*[@id='tab_4']/div/a[4]"));
        Fourth.click();
        System.out.println("Fourth Link: " + Fourth.getText());
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
