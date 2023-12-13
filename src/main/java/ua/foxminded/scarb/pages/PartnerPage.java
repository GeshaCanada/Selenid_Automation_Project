package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class PartnerPage {

    protected String emailUrl = "https://skarbmail.foxminded.ua/";

    protected String registrationUrl = "https://skarb.foxminded.ua/registration/confirm";

    private final SelenideElement link = $x("//a[@href='/registration']");
    private final SelenideElement buttonSuccess = $x("//button[contains(@class, 'btn-success')]");
    private final SelenideElement buttonRegistration = $x("//form//div[3]/button");
    private final SelenideElement registrationField = $x("//*[text()='Подтверждение регистрации']//ancestor::span");
    private final SelenideElement registrationLink = $x("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]");
    private final SelenideElement confirmationMessage = $x("//*[contains(text(), 'Ваш email подтверждено')]");

    public PartnerPage linkToPartnerPage() {
        link.click();
        buttonSuccess.click();
        return this;
    }

    public PartnerPage setRegistrationForm() {
        SoftAssert softAssert = new SoftAssert();
        String passwordValue = RandomStringGenerator.generateStrongPassword();


        $("input[name='email']").setValue(RandomStringGenerator.generateRandomEmail());
        $("input[name='lastName']").setValue(RandomStringGenerator.generateRandomString());
        $("input[name='firstName']").setValue(RandomStringGenerator.generateRandomString());
        $("input[name='sex']").click();
        $("input[name='password']").setValue(passwordValue);
        $("input[name='confirmPassword']").setValue(passwordValue);
        $("input[name='positionInOrganization']").setValue(RandomStringGenerator.generateRandomString());
        $("input[name='organizationName']").setValue(RandomStringGenerator.generateRandomString());

        buttonRegistration.click();

        softAssert.assertAll();
        return this;
    }

    public PartnerPage confirmRegistration() {
        open(emailUrl);
        registrationField.click();
        registrationLink.click();
        return this;
    }

    public void checkEmailConfirmationMessage() {
        switchTo().window(1);
        SoftAssert softAssert = new SoftAssert();

        if (url().startsWith(registrationUrl)) {
            softAssert.assertTrue(confirmationMessage.text().contains("Ваш email подтверждено"),
                    "Expected email confirmation message not found");
        } else {
            softAssert.fail("Expected registration URL not found");
        }

        softAssert.assertAll();
    }
}

