package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LinkText_PartialLink_Text {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir") +"\\Bowsers\\geckodriver.exe" );

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/login");

        //driver.findElement(By.linkText("Elemental Selenium")).click();
        driver.findElement(By.partialLinkText("ium")).click();

        Thread.sleep(3000);
        driver.quit();
    }

}
