package Assignments.VWOpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class VWO_Login
{
    @Test
    public void vwoLogin() throws InterruptedException
    {
        EdgeOptions edgeOptions= new EdgeOptions();

        // This stops the pop-up[top right] to appear that comes when a browser is opened
        edgeOptions.addArguments("--guest");

        WebDriver driver  = new EdgeDriver(edgeOptions);

        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("contact+atb7x@thetestingacademy.com");

        WebElement pw=driver.findElement(By.id("login-password"));
        pw.sendKeys("Wingify@1234");


        WebElement signIn=driver.findElement(By.id("js-login-btn"));
        signIn.click();

        Thread.sleep(10000);

        // finding the name on dashboard & printing it
        WebElement nameOnDashboard = driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println(nameOnDashboard.getText());

        Thread.sleep(10000);
        driver.quit();
    }
}
