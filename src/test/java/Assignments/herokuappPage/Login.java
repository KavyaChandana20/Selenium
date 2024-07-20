package Assignments.herokuappPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login
{
    @Test
    public void Login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement name= driver.findElement(By.id("txt-username"));
        name.sendKeys("John Doe");

        WebElement pw=driver.findElement(By.id("txt-password"));
        pw.sendKeys("ThisIsNotAPassword");

        WebElement login= driver.findElement(By.id("btn-login"));
        login.click();

        Thread.sleep(5000);

        String url= driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", url);

        Thread.sleep(2000);

        WebElement title = driver.findElement(By.tagName("h2")); //Make Appointment
        System.out.println(title.getText());

        // checking whether "Make Appointment" title is displayed or not
        Assert.assertTrue(title.isDisplayed(),"Make Appointment");

        //booking appointment
//        WebElement facility= driver.findElement(By.id("combo_facility"));
//        facility.isSelected();

        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();

        WebElement radio = driver.findElement(By.id("radio_program_medicaid"));
        radio.click();

        WebElement date = driver.findElement(By.id("txt_visit_date"));
        date.sendKeys("17/09/2024");

        WebElement book = driver.findElement(By.id("btn-book-appointment"));
        book.click();

        Thread.sleep(7000);

        WebElement confirmation = driver.findElement(By.className("lead"));
        System.out.println(confirmation.getText());
        Assert.assertTrue(confirmation.isDisplayed(),"Please be informed that your appointment has been booked as following:");

        driver.quit();


    }
}
