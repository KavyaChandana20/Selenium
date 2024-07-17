package Basics;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class PageLoad
{
    public static void main(String[] args)
    {
        //3 types of Page Load strategies
        // 1.Normal - Used by default, aits for all resources to donload
        // 2.Eager,
        // 3.None - Does not ait at all
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);


        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();



    }
}
