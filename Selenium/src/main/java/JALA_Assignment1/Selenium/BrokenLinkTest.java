package JALA_Assignment1.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkTest {

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
            driver.findElement(By.xpath("//ul[@id=\"MenusDashboard\"]/li[3]/ul/li[9]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"frmLinks\"]//li[2]/a")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBrokenLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='tab-pane active']//a[@target='_blank']"));
        System.out.println("Total Links: " + links.size());

        for (WebElement link : links) {
            String linkURL = link.getAttribute("href");
            if (linkURL != null && !linkURL.isEmpty()) {
                verifyLinkStatus(linkURL);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void verifyLinkStatus(String linkURL) {
        try {
            URL url = new URL(linkURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(linkURL + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(linkURL + " - " + httpURLConnection.getResponseMessage() + " - " + httpURLConnection.getResponseCode());
            }
        } catch (Exception e) {
            System.out.println(linkURL + " - Error: " + e.getMessage());
        }
    }
}
