package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SearchResult;

import java.io.IOException;

import static utility.ConfigReader.getUrl;
public class SharedSD {


    static WebDriver driver;

    @Before
    public void openBrowser() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }

    @After
    public void closeBrowser()
    {
        // driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}
