package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class ID {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Bowsers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/login");

        // Start Locators
        // Step 1: Enter user name
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Step 2: Enter Valid Password
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        // Step 3: Click Login Button
        driver.findElement(By.className("radius")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
