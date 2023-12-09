package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;


public class NgoPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(NgoPage.class.getName());

    // Используем SelenideElement вместо WebElement
    private SelenideElement registrationLink = $(By.xpath("//a[@href='/registration']"));
    private SelenideElement buttonNgo = $(By.xpath("//button[contains(@class, 'btn-warning')]"));
    private SelenideElement buttonSuccess = $(".btn-success"); // Пример использования CSS-селектора

    public NgoPage(WebDriver driver) {
        super(driver);
    }

    public NgoPage linkToNgoPage() {
        registrationLink.click();
        buttonNgo.click();
        return this;
    }

    public NgoPage setRegistrationNgoForm() {
        SoftAssert softAssert = new SoftAssert();
        String passwordValue = RandomStringGenerator.generateStrongPassword();
        List<WebElement> inputFields = driver.findElements(By.xpath("//input"));

        if (inputFields.size() == 14) {
            inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomEmail());
            inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(3).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(5).click();
            inputFields.get(6).sendKeys(passwordValue);
            inputFields.get(7).sendKeys(passwordValue);
            inputFields.get(8).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(11).sendKeys(RandomStringGenerator.generateRandomString());

        } else {
            softAssert.fail("Insufficient input fields found");
        }
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
