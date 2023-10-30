package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutocompleteTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAutocomplete() throws InterruptedException {
        driver.get("http://magnus.jalatechnologies.com");

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='MenusDashboard']/li[3]/ul/li[3]/a")).click();

        // Single Value Autocomplete
        WebElement singleValue = driver.findElement(By.id("txtSingleAutoComplete"));
        singleValue.sendKeys("Selenium");

        // Press Enter to select the first suggestion
        singleValue.sendKeys(Keys.ENTER);

        String single = singleValue.getAttribute("value");
        Assert.assertEquals(single, "Selenium", "Single Value Autocomplete failed");

        // Multiple Value Autocomplete
        driver.findElement(By.xpath("//*[@id='frmMenu']//ul/li[2]/a")).click();

        WebElement multipleValue = driver.findElement(By.id("txtMultipleAutoComplete"));
        multipleValue.sendKeys("Java, Python, ActionScript");

        // Simulate pressing Enter to submit the input
        multipleValue.sendKeys(Keys.ENTER);

        String multiple = multipleValue.getAttribute("value");
        Assert.assertEquals(multiple, "Java, Python, ActionScript", "Multiple Value Autocomplete failed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

