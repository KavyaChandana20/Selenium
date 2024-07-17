package VWOwebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Freetrial2
{
    // instead of writing "psvm()" write @Test & Func
    @Test
    public void testVerifyFREETrial()
    {

        /* TC --> 1.click on free trial.
         2.Enter email
         3.select the check bo
         4.click on create a free trial acc
         5.Verify that "An account with this email already exists" if registered acc is given
         */
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--guest");

        WebDriver driver  = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        // linkText, partialLinkText --> used only for anchor tags
        WebElement freeTrialLink = driver.findElement(By.linkText("Start a free trial"));
        //WebElement freeTrial = driver.findElement(By.partialLinkText("Start a free"));
        freeTrialLink.click();

        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("admin@admin.com");

        WebElement gdprConsentCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        gdprConsentCheckbox.click();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Verifying that "An account with this email already exists"
        WebElement error_msg_email_exist = driver.findElement(By.className("invalid-reason"));
        System.out.println(error_msg_email_exist.getText()); // capturing the error message

        try
        {
            Thread.sleep(5000);
        }

        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
