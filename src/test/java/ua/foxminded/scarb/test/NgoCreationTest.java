package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.NgoPage;

public class NgoCreationTest extends BaseTestNG {

    private static final Logger LOGGER = LogManager.getLogger(NgoCreationTest.class);

    @Test(dataProvider = "NgoData")
    @Parameters("name")
    public void createNgoTest(String name) {

        LOGGER.info("Creating Ngo: " + name);

        new NgoPage()
                .linkToNgoPage()
                .logNgoNavigation()
                .setRegistrationNgoForm()
                .logNgoRegistrationForm()
                .logNgoSuccessPage();
    }

    @DataProvider(name = "NgoData")
    public Object[][] ngoData() {
        return new Object[][]{
                {"Ngo1"},
                {"Ngo2"},
                {"Ngo3"},
                {"Ngo4"}
        };
    }
}
