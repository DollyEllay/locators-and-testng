package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class IDFirefox {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir") +"\\Bowsers\\geckodriver.exe" );

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
