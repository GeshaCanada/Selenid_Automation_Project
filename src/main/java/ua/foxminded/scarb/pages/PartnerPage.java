package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PartnerPage extends BasePage {

    private SelenideElement link = $(By.xpath("//a[@href='/registration']"));
    private SelenideElement buttonSuccess = $(By.xpath("//button[contains(@class, 'btn-success')]"));
    private SelenideElement buttonRegistration = $(By.xpath("//form//div[3]/button"));
    private SelenideElement registrationField = $(By.xpath("//*[text()='Подтверждение регистрации']//ancestor::span"));
    private SelenideElement registrationLink = $(By.xpath("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]"));
    private SelenideElement confirmationMessage = $(By.xpath("//*[contains(text(), 'Ваш email подтверждено')]"));

    public PartnerPage(WebDriver driver) {
        super(driver);
    }

    public PartnerPage linkToPartnerPage() {
        link.click();
        buttonSuccess.click();
        return this;
    }

    public PartnerPage setRegistrationForm() {
        SoftAssert softAssert = new SoftAssert();
        String passwordValue = RandomStringGenerator.generateStrongPassword();
        SelenideElement inputFieldsContainer = $(By.xpath("//form//div[@class='col-lg-6 col-md-6']"));
        if (inputFieldsContainer.findAll(By.tagName("input")).size() == 13) {
            inputFieldsContainer.$(By.name("email")).sendKeys(RandomStringGenerator.generateRandomEmail());
            inputFieldsContainer.$(By.name("lastName")).sendKeys(RandomStringGenerator.generateRandomString());
            inputFieldsContainer.$(By.name("firstName")).sendKeys(RandomStringGenerator.generateRandomString());
            inputFieldsContainer.$(By.name("gender")).click();
            inputFieldsContainer.$(By.name("password")).sendKeys(passwordValue);
            inputFieldsContainer.$(By.name("passwordConfirm")).sendKeys(passwordValue);
            inputFieldsContainer.$(By.name("position")).sendKeys(RandomStringGenerator.generateRandomString());
            inputFieldsContainer.$(By.name("company")).sendKeys(RandomStringGenerator.generateRandomString());
        } else {
            softAssert.fail("Insufficient input fields found");
        }
        softAssert.assertAll();
        buttonRegistration.click();
        return this;
    }

    public PartnerPage confirmRegistration() {
        open(emailUrl);
        registrationField.click();
        registrationLink.click();
        return this;
    }

    public void checkEmailConfirmationMessage() {
        Set<String> handles = getWebDriver().getWindowHandles();
        for (String handle : handles) {
            getWebDriver().switchTo().window(handle);
            if (getWebDriver().getCurrentUrl().equals(registrationUrl)) {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertNotNull(confirmationMessage, "Email confirmation message not found");
                softAssert.assertAll();
            }
        }
    }
}

