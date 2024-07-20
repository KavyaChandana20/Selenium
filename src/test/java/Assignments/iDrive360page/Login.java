package Assignments.iDrive360page;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login
{
    @Test
    public void driveLogin() throws InterruptedException
    {
        EdgeOptions edgeOptions= new EdgeOptions();

        // This stops the pop-up[top right] to appears that comes when a browser is opened
        edgeOptions.addArguments("--guest");

        WebDriver driver  = new EdgeDriver(edgeOptions);

        driver.get("https://www.idrive360.com/enterprise/login");

        driver.manage().window().maximize();



        WebElement email= driver.findElement(By.id("username"));
        email.sendKeys("augtest_040823@idrive.com");

        WebElement pw=driver.findElement(By.id("password"));
        pw.sendKeys("123456");

        WebElement show =driver.findElement(By.className("id-hide-pwd"));
        show.click();

        Thread.sleep(2000);

        WebElement signIn = driver.findElement(By.id("frm-btn"));
        signIn.click();

        Thread.sleep(15000);

        // verifying current url
        String url =driver.getCurrentUrl();
        Assert.assertEquals("https://www.idrive360.com/enterprise/account?upgradenow=true", url);


        Thread.sleep(15000);

        //verifying free trial tet &
        WebElement trial =driver.findElement(By.className("id-card-title"));
        System.out.println(trial.getText());
        String freeTrial =trial.getText();
        Assert.assertEquals("Your free trial has expired",freeTrial);

        driver.quit();
    }
}
