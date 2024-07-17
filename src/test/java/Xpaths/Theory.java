package Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Theory
{
    @Test
    public void testVerifyFREETrial() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getTitle());


        // Default Locator Strategy - ID,  Name, Class
        // Xpath or CSS Selector Strategy
        //  Which is good, xpath or css Selector?
        //  Css Selectors -> little fast, Nowdays since more ram - xpath  == css selector
        // Xpath -> , css Seelctor -
        // 25Test - mixture, it depends - sometimes xpath easy -

        // Xpath or Css Selector - converted to each vice -
        // Css Selector - Css Engine - little fast to find the element

        // What is XPath?
        // XPath is a query language.
        // for selecting nodes from an XML document.
        // HTML -> it is a Tag based lang also a xml type of document
        // XPath was defined by the World Wide Web Consortium.
        // All the major browsers understand and supports it. W3C

        // Type of Xpath

        // Absolute Xpath - Full Xpath - Type #1
        // It is too long -
        // prone to change - any change in div or html - Axpath will  work
        // no body use Absolute Xpath


        // Relative Xpath (with Query)
        // Syntax - //tagName[@attribute='value']
        // Selenium -id -?
        // || //input[@id="js-login-confirm-email"]



        // Finding elements in diff ways
        //        WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));
        //        WebElement btnElement_CN = driver.findElement(By.className("btn-lg"));
        //        WebElement btnElement_PTEXT = driver.findElement(By.partialLinkText("Make"));
        //        WebElement btnElement_LTEXT = driver.findElement(By.partialLinkText("Make Appointment"));
        WebElement btnElement_AT = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));

        // Multiple "a" tag  - not recommended
        //WebElement btnElement_TagName = driver.findElement(By.tagName("a"));
        btnElement_AT.click();

        // Strategy to find the elements, in the below order
        // 1.id="txt-username" - Unique
        // 2.name="username" - Unique
        // 3.class="form-control" - Not Unique , if we have multiple classes with same name its useless
        // 4.Link text & Partial text
        // 5.Relative Xpath  OR Css Selectors
            // 5a.Functions --> R Xpath
            // 5b.Axes  --> R Xpath

        // "*" is slow, we are going to find the first all the elements
        //List<WebElement> username_element = driver.findElements(By.xpath("//*[@placeholder='Username']"));

        // here, input -> place holder
        List<WebElement> username_element = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_element.get(1).sendKeys("John Doe");


        // Xpath Functions
        // Where they are useful? - dynamic text or dynamic elements
        // They are useful when the attribute value is some constant and some dynamic
        // i.e., In scooty make scoot a constant , later "y" can be replaced with other alphabets like scooter
        //  title = "pramod_2323"
        // starts-with -> pramod, contains - Partial Match

        // //img[contains(@title,"Flip")]

        // //img[starts-with(@title,"Flip")]
        // substring-after

        // normalize-space--> removes space   title= " pramod "

        //a[text()="Make Appointment"] - Exact Match.
        // a[text()] is a func in Xpath, where "a" is an anchor tag


        // use operators [AND, OR] when we have to use multiple Attributes
        // tag_name[@name = 'Name value' and @id = ‘ID value’]
        // //a[text()="Make Appointment" and contains(@id,"btn-make-appointment")]


        // Xpath Axes-->Ability to find ancestor,child and descendant tags when you know about one particular tag.

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
