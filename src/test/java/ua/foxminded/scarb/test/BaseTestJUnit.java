package ua.foxminded.scarb.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;



public class BaseTestJUnit {

    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";


    @BeforeEach
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        configureDriver();
        driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    private void configureDriver() {
        driver.manage().window().maximize();
        Configuration.timeout = 7000;
    }
}