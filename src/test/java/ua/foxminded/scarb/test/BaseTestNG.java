package ua.foxminded.scarb.test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;



public class BaseTestNG {

    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeMethod
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        configureDriver();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void configureDriver() {
        driver.manage().window().maximize();
        //Configuration.timeout = 7000;
    }

}