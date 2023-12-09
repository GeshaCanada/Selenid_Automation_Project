package ua.foxminded.scarb.test;

import org.instancio.Instancio;
import org.testng.annotations.Test;
import ua.foxminded.scarb.Volunteer;
import utils.RandomDataGenerator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;
import static org.instancio.Select.field;

public class VolunteerPageTestInstancio extends BaseTestNG {

    @Test
    public void checkVolunteerFormTest() {
        $(byCssSelector(".nav-link.ml-auto")).click();
        $(byCssSelector("[name=volunteers] .btn")).click();

        Volunteer volunteer = Instancio.of(Volunteer.class)
                .generate(field(Volunteer::getEmail), gen -> gen.text().pattern("#a#a#a#a#a#a@yahoo.com"))
                .generate(field(Volunteer::getPhoneNumber), gen -> gen.text().pattern(8 + "#d#d#d#d#d#d#d#d#d"))
                .set(field(Volunteer::getFirstName), RandomDataGenerator.generateRandomString())
                .set(field(Volunteer::getLastName), RandomDataGenerator.generateRandomString())
                .set(field(Volunteer::getPassword), RandomDataGenerator.generateStrongPassword())
                .create();

        $("#email").setValue(volunteer.getEmail());
        $("#phoneNumber").setValue(volunteer.getPhoneNumber());
        $("#firstName").setValue(volunteer.getFirstName());
        $("#lastName").setValue(volunteer.getLastName());
        $("#password").setValue(volunteer.getPassword());
        $("#confirmPassword").setValue(volunteer.getPassword());

        $(".btn-success").click();
    }
}
