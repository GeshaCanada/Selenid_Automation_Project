package ua.foxminded.scarb.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;

public class BaseTestNG {

    protected String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeMethod
    public void setUp() throws NotSupportedBrowserException {
        Configuration.browser = "chrome";
        configureDriver();
        Selenide.open(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    private void configureDriver() {
        Configuration.browserSize ="4000x2200";
        Configuration.timeout = 7000;
    }
}
