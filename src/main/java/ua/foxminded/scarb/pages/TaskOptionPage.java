package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class TaskOptionPage extends BasePage {

    // Используем SelenideElement вместо WebElement
    @FindBy(css = "div.statistic button")
    private SelenideElement button;

    @FindBy(css = "h2")
    private SelenideElement title;

    public TaskOptionPage(WebDriver driver) {
        super(driver);
    }

    public String getButtonText() {
        return button.getText();
    }

    public void clickTaskButton() {
        button.click();
    }

    public String getTitleTaskText() {
        return title.getText();
    }
}
