package Basics;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Prog1
{
    public static void main(String[] args)
    {
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login"); //opens browser
        driver.navigate().to("https://app.vwo.com"); //opens browser
        System.out.println(driver.getTitle());
        driver.quit(); //closes browser
    }
}
