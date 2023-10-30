package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SliderTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://magnus.jalatechnologies.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
    }

    @Test
    public void testSliderInteraction() {
        Duration timeout = Duration.ofSeconds(120);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='MenusDashboard']//li[3]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='MenusDashboard']/li[3]/ul/li[6]/a"))).click();

        WebElement sliderElement = driver.findElement(By.xpath("//*[@id='blue']/div[1]/div[4]"));
        Actions action = new Actions(driver);

        // Click and hold the slider element
        action.clickAndHold(sliderElement).perform();

        // Drag the slider to the desired position
        action.moveByOffset(100, 0).perform(); // Adjust the offset as needed

        // Release the click to set the slider value
        action.release().perform();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
