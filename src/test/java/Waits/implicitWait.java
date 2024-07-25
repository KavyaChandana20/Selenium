package Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class implicitWait
{

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVerifyFREETrial() throws InterruptedException {

        // Implicit Wait -
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Gives No Such Element Exception.

        // Navigate to the - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        System.out.println(driver.getTitle());
        // Search Element
        driver.manage().window().maximize();
        // #gh-ac
        // input[id="gh-ac"] -> xpath -> //input[@id="gh-ac"]
        WebElement searchBox = driver.findElement(By.cssSelector("abc"));
        searchBox.sendKeys("macmini"); // Find the "macmini"

        // .gh-spr
//        WebElement searchBoxButton = driver.findElement(By.cssSelector(".gh-spr"));
        WebElement searchBoxButton = driver.findElement(By.cssSelector("input[value='Search']"));
        searchBoxButton.click();

    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
