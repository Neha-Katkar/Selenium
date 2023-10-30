package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImageUploadTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://magnus.jalatechnologies.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//ul[@id='MenusDashboard']/li[3]/ul/li[5]/a")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testImageUpload() {
        // Perform image upload and other actions
        WebElement upload = driver.findElement(By.id("file"));
        upload.sendKeys("C:\\Users\\INTEL\\Desktop\\My_Work");
        driver.findElement(By.id("fileName")).sendKeys("Butterfly");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}