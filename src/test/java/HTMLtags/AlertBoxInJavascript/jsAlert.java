package HTMLtags.AlertBoxInJavascript;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class jsAlert
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser()
    {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVerifyJSAlert() throws InterruptedException
    {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();


          // button[text()='Click for xpath Alert']  --> xpath func
         // button[@onClick='jsAlert'] --> xpath
        // button[onclick='jsAlert()'  --> ccs Selector
         WebElement al = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
         al.click();

        // wait until the pop-up comes
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

         String result = driver.findElement(By.id("result")).getText();
         System.out.println(result);
         Assert.assertEquals(result,"You successfully clicked an alert");

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
