package JALA_Assignment1.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PromptBoxTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPromptBox() throws InterruptedException {
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

        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[8]/a")).click();

        WebElement promptButton = driver.findElement(By.id("promptBtn"));
        promptButton.click();

        // Switch to the alert/prompt box
        Alert alert = driver.switchTo().alert();

        // Get the text of the prompt
        String promptText = alert.getText();
        System.out.println("Prompt text: " + promptText);

        // Enter text in the prompt
        String enteredText = "JALA Academy"; // You can replace this with your desired text
        alert.sendKeys(enteredText);

        Thread.sleep(1000);
        // Accept the prompt (Click OK)
        alert.accept();

        // Display the entered text
        System.out.println("Entered text: " + enteredText);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

