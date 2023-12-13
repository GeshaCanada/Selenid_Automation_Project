package ua.foxminded.scarb.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;

import static com.codeborne.selenide.Selenide.*;

public class NgoPage {

    private static final Logger LOGGER = LogManager.getLogger(NgoPage.class.getName());

    private final SelenideElement registrationLink = $x("//a[@href='/registration']");
    private final SelenideElement buttonNgo = $x("//button[contains(@class, 'btn-warning')]");
    private final SelenideElement buttonSuccess = $(".btn-success");

    public NgoPage linkToNgoPage() {
        registrationLink.click();
        buttonNgo.click();
        return this;
    }

    public NgoPage setRegistrationNgoForm() {
        SoftAssert softAssert = new SoftAssert();
        String passwordValue = RandomStringGenerator.generateStrongPassword();
        ElementsCollection inputFields = $$("input");

        inputFields.shouldHave(CollectionCondition.size(14)); // Проверка количества полей

        inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomEmail());
        inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(3).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(5).click();
        inputFields.get(6).sendKeys(passwordValue);
        inputFields.get(7).sendKeys(passwordValue);
        inputFields.get(8).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(11).sendKeys(RandomStringGenerator.generateRandomString());

        softAssert.assertAll();
        buttonSuccess.click();
        return this;
    }

    public NgoPage logNgoNavigation() {
        LOGGER.debug("Navigated to Ngo Page");
        return this;
    }

    public NgoPage logNgoRegistrationForm() {
        LOGGER.debug("Filled Ngo Registration Form");
        return this;
    }

    public NgoPage logNgoSuccessPage() {
        LOGGER.debug("Navigated to Success Page");
        return this;
    }
}
