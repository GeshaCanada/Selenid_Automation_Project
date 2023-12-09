package ua.foxminded.scarb.test;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import utils.RandomDataGenerator;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class VolunteerPageTestDataGenerator extends BaseTestNG {

    @Test
    public void checkVolunteerFormTest() {
        $(byCssSelector(".nav-link.ml-auto")).click();
        $(byCssSelector("[name=volunteers] .btn")).click();

        String firstNameValue = RandomDataGenerator.generateRandomString();
        String lastNameValue = RandomDataGenerator.generateRandomString();
        String emailValue = RandomDataGenerator.generateRandomString() + "@gmail.com";
        String phoneValue = RandomDataGenerator.generateRandomNumber();
        String passwordValue = RandomDataGenerator.generateStrongPassword();

        $("#firstName").setValue(firstNameValue);
        $("#lastName").setValue(lastNameValue);
        $("#email").setValue(emailValue);
        $("#phoneNumber").setValue(phoneValue);
        $("#password").setValue(passwordValue);
        $("#confirmPassword").setValue(passwordValue);

        $(".btn-success").click();
    }
}
