package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Homepage2 {

    WebDriver driver;
    String amazonUrl = "https://www.amazon.com/";
    //String ebayUrl = "https://www.ebay.com/";

    @BeforeMethod
    public void setUp(){

        String chromeDriverPath = "BrowserDriver/mac/chromedriver";
        //String firefoxDriverPath = "BrowserDriver/mac/geckodriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        driver = new ChromeDriver();

    }

    @Test
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
