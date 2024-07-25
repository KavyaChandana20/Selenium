package HTMLtags;

import org.testng.annotations.AfterTest;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;
import java.util.List;

public class checkboxTag
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
    public void testPositive() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        checkboxes.get(0).click(); // check
        checkboxes.get(1).click(); // by default it is checked, so it will uncheck now

        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
