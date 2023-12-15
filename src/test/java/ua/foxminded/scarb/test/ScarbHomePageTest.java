package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScarbHomePageTest extends BaseTestNG {
    private static final Logger LOGGER = LogManager.getLogger(ScarbHomePageTest.class.getName());
    private HomePage pageHome;

    @Test
    public void homePageTitleTest() {
        LOGGER.info("Starting homePageTitleTest");

        pageHome = new HomePage();
        String actualTitle = pageHome.getTitleText();
        String expectedTitle = "SKARB NGO";

        LOGGER.debug("Actual Title: " + actualTitle);
        LOGGER.debug("Expected Title: " + expectedTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");

        LOGGER.info("homePageTitleTest completed successfully");
    }

}


