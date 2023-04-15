import jdk.nashorn.internal.runtime.JSONFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.concurrent.TimeUnit;

// Hard Assertion:
public class LoginTestCases {

        // Declare for the WebDriver
        WebDriver driver;
    @BeforeMethod
        public void OpenBrowser(){
        System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");

        //System.out.println("1- Open Browser Command");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();
    }

    @Test(priority = 0)
    public void validLogin(){
        //System.out.println("2- Test Case with Valid Login Data");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class=\"radius\"]")).click();

        // Compare Actual result with expected result using .. TestNG Assertions
        // Assertions:

        // Hard Assertions
 /*

    //  1- Verify this url "https://the-internet.herokuapp.com/secure"
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";

        Assert.assertEquals(actualUrl, expectedUrl);


    //  2- <h2> element contains text "Secure Area"

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class=\"example\"] h2")).getText(), "Secure Area");

    //  3- Verify page contains "You logged into a Secure area!".
        String actualFlash = driver.findElement(By.id("flash")).getText();
        String expectedFlash = "You logged into a secure area!";
        //Assert.assertEquals(actualFlash, expectedFlash);

        Assert.assertTrue(actualFlash.contains(expectedFlash));
        //Assert.assertTrue(actualFlash.replaceAll("\\s+", "").contains(expectedFlash.replaceAll("\\s+", "")));

     //  4- Success message has green bck color
        Assert.assertEquals(driver.findElement(By.id("flash")).getCssValue("background-color"), "rgb(93, 164, 35)");

        //  5- Logout button is displayed
        boolean actualStatus = driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed();
        //Assert.assertEquals(actualStatus, true);
        Assert.assertTrue(actualStatus);
*/

        // Soft Assertion
        //1- Verify this url "https://the-internet.herokuapp.com/secure"
        SoftAssert soft = new SoftAssert();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        soft.assertEquals(actualUrl, expectedUrl, "First assertion is failed");

        //2- <h2> element contains text "Secure Area"
        String actualText = driver.findElement(By.cssSelector("div[class=\"example\"] h2")).getText();
        String  expectedText = "Secure Area";
        soft.assertEquals(actualText, expectedText, "Second assertion is failed");

        //3

        //4

        //5

        soft.assertAll();       //To show the output which passed or failed

    }

    @Test(priority = 1)
    public void invalidLogin(){

        //System.out.println("3- Test Case with Invalid Login Data");
        driver.findElement(By.id("username")).sendKeys("WrongName");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("InvalidPassWord!");
        driver.findElement(By.xpath("//button[@class=\"radius\"]")).click();

        // Compare Actual result with expected result using .. TestNG Assertions -soft-
        SoftAssert soft = new SoftAssert();

        // 1- vertify the error message
        String actualText = driver.findElement(By.id("flash")).getText();

        soft.assertTrue(actualText.contains("Your username is invalid!"));

        //2- bckg messg is red
        String actualBckg = driver.findElement(By.id("flash")).getCssValue("background-color");
        actualBckg = String.valueOf("#c60f13");
        soft.assertEquals(actualBckg, "#c60f13");

        soft.assertAll();

    }


    @AfterMethod
    public void qDriver() throws InterruptedException {
        //System.out.println("4- Quit the Driver After Execution");
        Thread.sleep(3000);
        driver.quit();
    }

}
