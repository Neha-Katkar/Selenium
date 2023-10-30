package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest {

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
    public void testFrameContent() {
        // Click on the menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//ul[@id='MenusDashboard']/li[3]/ul/li[11]/a")).click();

        driver.switchTo().frame(1);

        // Find the element inside the iframe
        WebElement h1Element = driver.findElement(By.xpath("//h1[text()='Welcome to JALA Academy']"));

        // Get the text of the <h1> element
        String h1Text = h1Element.getText();

        // Print the text
        System.out.println("Text element: " + h1Text);

        // Switch back to the main window
        driver.switchTo().defaultContent();

        // Find the element inside the iframe
        WebElement elementInsideIframe = driver.findElement(By.id("tab_1"));

        // Verify that the element is present
        if (elementInsideIframe.isDisplayed()) {
            System.out.println("The element 'Frame One, Frame Two, Frame Three' is present inside the iframe.");
        } else {
            System.out.println("The element 'Frame One, Frame Two, Frame Three' is not present inside the iframe.");
        }
    }

    @AfterMethod
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
