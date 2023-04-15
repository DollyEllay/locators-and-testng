package Syntaxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CSS_Selector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir") +"\\Bowsers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        // Click on Form Authentication by using cs selector
        driver.findElement(By.cssSelector("a[href = \"/login\"]")).click();

        // Enter username using CSS Selector
        driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("tomsmith");
      // driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("SuperSecretPassword!");

            // Enter Password using CSS Selector with 2 attributes
        driver.findElement(By.cssSelector("input[name=\"password\"][type=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
