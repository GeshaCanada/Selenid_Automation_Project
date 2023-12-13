package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ua.foxminded.scarb.User;
import ua.foxminded.scarb.pages.LoginPage;

public class LoginTestNG extends BaseTestNG {

    private static final Logger LOGGER = LogManager.getLogger(LoginTestNG.class.getName());

    @Test
    public void userLoginTest() {
        LOGGER.info("Start checking userLoginTest");
        User user = new User.Builder()
                .setEmail("grostikov23@gmail.com")
                .setPassword("Gg23021981Gg!")
                .setPosition("Tester")
                .setLastname("Rostikov")
                .setUsername("Gennadii")
                .build();

        new LoginPage()
                .populateLoginForm(user)
                .verifyUserInfo(user);
        LOGGER.info("Finish checking userLoginTest");
    }
}