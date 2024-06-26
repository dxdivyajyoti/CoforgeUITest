package TestCase;

import PageObject.AmazonPageRepo;
import Utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;


public class AmazonPage extends BaseClass {
    public String expected;
    public WebDriver driver;
    AmazonPageRepo amazonHomePage = new AmazonPageRepo(driver);
    BaseClass bs = new BaseClass();

    @BeforeTest
    public void runBrowser() {
        bs.runBrowser("chrome");

    }

    @Test
    public void testcase() {
//       Enter the product name "iphone" in the search bar.
//       Click on the search button
        expected = bs.runTest();
        System.out.println(expected);
    }

    @AfterTest
    public void closeBrowser() {
        // Verify that the first result contains the text "Apple iPhone".
        if (expected.indexOf("Apple iPhone") != -1) {
            //Close the browser
            bs.closeBrowser();
        }

    }
}
