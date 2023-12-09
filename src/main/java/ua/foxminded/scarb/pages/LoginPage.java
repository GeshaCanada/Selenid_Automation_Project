package ua.foxminded.scarb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.foxminded.scarb.User;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn-primary")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='navbarNav']/a[1]/i")
    private WebElement profileIcon;

    @FindBy(id = "positionInOrganization")
    private WebElement positionInput;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logIn() {
        loginLink.click();
        loginInput.sendKeys("grostikov23@gmail.com");
        passwordInput.sendKeys("Gg23021981Gg!");
        loginButton.click();
        return this;
    }

    public LoginPage populateLoginForm(User user) {
        loginLink.click();
        loginInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public LoginPage verifyUserInfo(User user) {
        profileIcon.click();
        String actualFirstName = firstNameInput.getText();
        String actualLastName = lastNameInput.getText();
        actualFirstName.equals(user.getUsername());
        actualLastName.equals(user.getLastname());
        return this;
    }
}

