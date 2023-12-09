package ua.foxminded.scarb.test;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.RandomDataGenerator;
import utils.RandomStringGenerator;

import static com.codeborne.selenide.Selenide.*;

public class PartnerPageTestDataGenerator extends BaseTestNG {

    private SelenideElement registrationLink = $(By.xpath("//a[@href='/registration']"));
    private SelenideElement btnPartner = $(By.xpath("//button[contains(@class, 'btn-success')]"));
    private SelenideElement email = $(By.xpath("//input[@type='email']"));
    private SelenideElement companyName = $(By.xpath("//input[@id='organizationName']"));
    private SelenideElement firstName = $(By.xpath("//input[@name='firstName']"));
    private SelenideElement lastName = $(By.xpath("//input[@name='lastName']"));
    private SelenideElement positionName = $(By.xpath("//input[@id='positionInOrganization']"));
    private SelenideElement sexBox = $(By.xpath("//input[@id='female']"));
    private SelenideElement password = $(By.cssSelector("input#password"));
    private SelenideElement confirmPassword = $(By.cssSelector("input#confirmPassword"));
    private SelenideElement btnSuccess = $(By.xpath("//form//div[3]/button"));

    @Test
    public void checkPartnerFormTest() {
        openRegistrationPage();
        fillRegistrationForm();
    }

    private void openRegistrationPage() {
        registrationLink.click();
        btnPartner.click();
    }

    private void fillRegistrationForm() {
        email.setValue(RandomStringGenerator.generateRandomEmail());
        companyName.setValue(RandomStringGenerator.generateRandomString());
        firstName.setValue(RandomStringGenerator.generateRandomString());
        lastName.setValue(RandomStringGenerator.generateRandomString());
        positionName.setValue(RandomStringGenerator.generateRandomString());
        sexBox.click();
        password.setValue(RandomDataGenerator.generateStrongPassword());
        confirmPassword.setValue(password.getValue()); // используем введенный ранее пароль
        btnSuccess.click();
    }
}
