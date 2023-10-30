package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CSSPropertiesTest3 {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCSSProperties() throws InterruptedException {
        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");

        // Find the email and password input fields and the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[10]/a")).click();
        
        driver.findElement(By.xpath("//*[@id=\"frmCssProperties\"]//ul/li[5]/a")).click();
        WebElement bar1 = driver.findElement(By.xpath("//*[@id=\"tab_5\"]/div[1]"));
        
        // Get the CSS properties of the element
        String fontSize = bar1.getCssValue("font-size");
        String fontStyle = bar1.getCssValue("font-style");
        String color = bar1.getCssValue("color");
        
        // Print the CSS properties to the console
        System.out.println("CSS properties of the element:");
        System.out.println("Font size: " + fontSize);
        System.out.println("Font style: " + fontStyle);
        System.out.println("Color: " + color);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

