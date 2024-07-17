package Basics;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Prog2
{
    public static void main(String[] args) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        // Browser - Headless (No UI) or full mode
        // 1.Headless - No UI, performance good, fast execution
        // 2. Full Mode - UI, performance lag, >100

        // Options - Browser  - start maximize, add extension, add options or param

        options.addArguments("--start-maximized"); // maximize browser
        // options.addArguments("--window-size=800,600");

        //options.addArguments("--guest");


        /* like how we use VPN to connect to internet,
        same way proxy is a machine through which we can connect to internet
         */
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("222.129.35.173:57114");
        options.setCapability("proxy", proxy);



        WebDriver driver = new EdgeDriver(options);
        driver.get("https://whatismyipaddress.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000); // Worst way to add a wait in the script
        driver.quit();
    }
}
