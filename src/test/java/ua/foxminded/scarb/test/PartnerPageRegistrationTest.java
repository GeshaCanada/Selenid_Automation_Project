package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomDataGenerator2;

import java.time.Duration;
import java.util.List;
public class PartnerPageRegistrationTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";
    private String emailUrl = "https://skarbmail.foxminded.ua/";
    private String passwordValue = RandomDataGenerator2.generateStrongPassword();
    @BeforeMethod
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
    }
    @Test
    public void checkPartnerFormTest() {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/registration']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-success')]"))).click();

        List<WebElement> inputFields = driver.findElements(By.xpath("//input"));
        inputFields.get(0).sendKeys(RandomDataGenerator2.generateRandomEmail());
        inputFields.get(2).sendKeys(RandomDataGenerator2.generateRandomString());
        inputFields.get(3).sendKeys(RandomDataGenerator2.generateRandomString());
        inputFields.get(5).click();
        inputFields.get(6).sendKeys(passwordValue);
        inputFields.get(7).sendKeys(passwordValue);
        inputFields.get(8).sendKeys(RandomDataGenerator2.generateRandomString());
        inputFields.get(11).sendKeys(RandomDataGenerator2.generateRandomString());

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[3]/button"))).click();
    }
    @Test
    public void checkRegistrationPartnerFormTest() {
        driver.get(emailUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Подтверждение регистрации']//ancestor::span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]"))).click();
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
