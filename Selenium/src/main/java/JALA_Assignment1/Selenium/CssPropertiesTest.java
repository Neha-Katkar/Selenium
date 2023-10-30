package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CssPropertiesTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCssProperties() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[10]/a")).click();

        // Find the first link in the "Leave Types" table
        WebElement link1 = driver.findElement(By.xpath("//*[@id=\"tab_1\"]/div/a[1]"));

        // Get the CSS properties of the link
        String linkFontSize = link1.getCssValue("font-size");
        String linkFontStyle = link1.getCssValue("font-style");
        String linkColor = link1.getCssValue("color");

        // Print the CSS properties to the console
        System.out.println("CSS properties of the link:");
        System.out.println("Font size: " + linkFontSize);
        System.out.println("Font style: " + linkFontStyle);
        System.out.println("Color: " + linkColor);

        // Find the label in the "Leave Types" table
        WebElement label = driver.findElement(By.xpath("//*[@id=\"tab_2\"]/div/span[2]"));

        // Get the CSS properties of the label
        String labelFontSize = label.getCssValue("font-size");
        String labelFontStyle = label.getCssValue("font-style");
        String labelColor = label.getCssValue("background-color");

        // Print the CSS properties to the console
        System.out.println("CSS properties of the label:");
        System.out.println("Font size: " + labelFontSize);
        System.out.println("Font style: " + labelFontStyle);
        System.out.println("Color: " + labelColor);

        driver.findElement(By.xpath("//*[@id=\"frmCssProperties\"]//ul/li[4]/a")).click();
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"tab_4\"]/div[1]"));

        // Additional test steps can be added here as needed

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
