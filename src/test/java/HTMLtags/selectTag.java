package HTMLtags;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class selectTag
{
    /* <button id="btn"> login </button>
        button = start tag
        id = attribute
        btn = value
       /button = end tag     */

    /* In HTML, tags represent the structural components of a document.
       An HTML element consists of a start tag, some content, and an end tag.   */


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
    public void dropdown() throws InterruptedException {

        // Select Box
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        Thread.sleep(10000);



        WebElement element_select= driver.findElement(By.id("dropdown"));
        Select dd = new Select(element_select);
        // dd.selectByIndex(1);

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        dd.selectByVisibleText("Option 2");

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
