package JALA_Assignment1.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TooltipTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testTooltip() throws InterruptedException {
        // Navigate to the login page
        driver.get("http://magnus.jalatechnologies.com");

        // Find the email and password input fields and the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(1000);

        // Click on the menu item
        driver.findElement(By.xpath("//ul[@id='MenusDashboard']//li[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@id=\"MenusDashboard\"]/li[3]/ul/li[7]/a")).click();

        // Locate the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.linkText("Tooltips"));

        // Instantiating Actions class
        Actions action = new Actions(driver);

        // Hovering on main menu
        action.moveToElement(mainMenu).perform();

        // Locate the element from Sub Menu
        WebElement subMenu = driver.findElement(By.id("btnTooltip"));
        subMenu.click();

        // Mouseover on sub menu
        action.moveToElement(subMenu).click().perform();

        System.out.println("Text : " + subMenu.getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
