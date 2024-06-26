package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

        }

    }

    public String runTest() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call runBrowser() first.");
        }
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        String text = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style'])[1]")).getText();
        System.out.println(text);
        return text;
    }


    public void closeBrowser() {
        driver.close();
    }
}
