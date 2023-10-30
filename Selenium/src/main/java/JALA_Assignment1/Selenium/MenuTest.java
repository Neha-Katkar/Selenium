package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MenuTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMenuInteraction() throws InterruptedException {
        driver.get("http://magnus.jalatechnologies.com");

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        // Click on the menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);

        // Hover over the submenu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]//ul//li[2]/a[1]")).click();
        WebElement singlemenus = driver.findElement(By.id("b1"));
        singlemenus.click();

        // Verify if the radio button is not selected
        Assert.assertFalse(singlemenus.isSelected(), "Selenium selected");

        Thread.sleep(5000);

        // Additional interactions
        driver.findElement(By.xpath("//*[@id='frmMenu']//ul//li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='tab_2']/ul/li[1]/a")).click();
        WebElement element = driver.findElement(By.id("manualbtn"));
        element.click();

        // Get and print the text of the element
        String text = element.getText();
        System.out.println(text);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
