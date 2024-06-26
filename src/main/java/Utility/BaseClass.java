package Utility;

import PageObject.AmazonPageRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;

    public void runBrowser(String browsername) {

        if (browsername == "chrome") {
            System.setProperty("webdriver.chrome.driver", "/Users/b0276648/Desktop/IQPT/CoforgeUITest/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get("https://www.amazon.in/");

        } else if (browsername == "safari") {

//add browser compatible code
        } else {
            //add browser compatible code
        }

    }

    public String runTest() throws InterruptedException {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call runBrowser() first.");
        }

        AmazonPageRepo amazonHomePage = new AmazonPageRepo(driver);
        amazonHomePage.enterSearchKeyword("iphone");
        amazonHomePage.clickSearchButton();
        amazonHomePage.getFirstItemDetails();
        String text = amazonHomePage.getFirstItemDetails();
        Thread.sleep(3000);
        return text;
    }


    public void closeBrowser() {
        driver.close();
    }
}
