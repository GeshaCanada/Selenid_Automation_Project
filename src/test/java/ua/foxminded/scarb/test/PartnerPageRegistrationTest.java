package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.PartnerPage;

public class PartnerPageRegistrationTest extends BaseTestNG {

    private static final Logger LOGGER = LogManager.getLogger(PartnerPage.class.getName());
    @Test
    public void checkPartnerFormAndRegistrationPartnerFormTest() {
        LOGGER.info("Starting checkPartnerFormAndRegistrationPartnerFormTest");

        new PartnerPage()
                .linkToPartnerPage()
                .setRegistrationForm()
                .confirmRegistration()
                .checkEmailConfirmationMessage();

        LOGGER.info("checkPartnerFormAndRegistrationPartnerFormTest completed successfully");
    }
}
