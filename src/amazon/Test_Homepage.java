package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Homepage {

    public static void main(String[] args) {

        String amazonUrl = "https://www.amazon.com/";
        //String ebayUrl = "https://www.ebay.com/";

        String chromeDriverPath = "BrowserDriver/mac/chromedriver";
        //String firefoxDriverPath = "BrowserDriver/mac/geckodriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.get(amazonUrl);
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        // validation
        Assert.assertEquals(actualTitle,expectedTitle, "Test fail");

       // driver.close(); //will close all the tabs
        driver.quit(); // will close only the open tab

        //firefox
//        WebDriver driver1 = new FirefoxDriver();
//        driver1.get(ebayUrl);
//        driver1.close();
        


    }


}
