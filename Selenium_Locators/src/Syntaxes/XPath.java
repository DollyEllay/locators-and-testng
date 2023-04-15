package Syntaxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class XPath {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.geckodriver.driver", System.getProperty("user,dir")+"\\Bowsers\\geckodriver.exe" );

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        // Enter the Elements with using Absolute Xpath:
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input[1]")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input[1]")).sendKeys("SuperSecretPassword!");

        // Enter The Elements using Relative XPath.
        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("tomsmith");

        // Enter the Element with Multiple Attributes [2]
        driver.findElement(By.xpath("//input[@type=\"password\" and @name=\"password\"]")).sendKeys("SuperSecretPassword!");

        // Enter the Element using Ancestors:
        driver.findElement(By.xpath("//form[@action=\"/authenticate\"]//button[@type=\"submit\" ]")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
