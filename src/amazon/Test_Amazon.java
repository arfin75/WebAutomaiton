package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Amazon {

    WebDriver driver;
    String amazonUrl = "https://www.amazon.com/";

    @BeforeMethod
    public void setUp(){

        String chromeDriverPath = "BrowserDriver/mac/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test(enabled = true)
    public void searchBox() throws InterruptedException {
        // open browser and navigate to amazon url
        driver.get(amazonUrl);
        // find the in the search box "candy"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("candy");
        // wait time
        Thread.sleep(5000);
        // click on the serch button
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(5000);
        //validate
        String expectedText ="\"candy\"";
        String actualText = driver.findElement(By.cssSelector("#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col-26-of-32.sg-col-18-of-24.sg-col.sg-col-22-of-28.s-breadcrumb.sg-col-10-of-16.sg-col-30-of-36.sg-col-6-of-12 > div > div > span.a-color-state.a-text-bold")).getText();
        Assert.assertEquals(expectedText, actualText, "Test fail");

    }

    @Test(enabled = false)
    public void  checkHomePageTitle(){
        driver.get(amazonUrl);
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        // validation
        Assert.assertEquals(actualTitle,expectedTitle, "Test fail");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
