package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import ua.foxminded.scarb.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginLink = $("a[href='/login']");
    private SelenideElement loginInput = $("#login");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $(".btn-primary");
    private SelenideElement profileIcon = $("#navbarNav a i");
    private SelenideElement positionInput = $("#positionInOrganization");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");

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


