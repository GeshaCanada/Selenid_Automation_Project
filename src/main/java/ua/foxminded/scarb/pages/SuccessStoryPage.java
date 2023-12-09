package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class SuccessStoryPage extends BasePage {

    // Используем SelenideElement вместо WebElement
    private SelenideElement title = $("[partialLinkText='Истории успеха']");
    private SelenideElement searchInput = $("input[id='storyNameSearchFilter']");
    private SelenideElement link = $("[partialLinkText='Показать больше']");
    private SelenideElement homeLink = $("h4.text-dark-red");

    public SuccessStoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public void clickPageTitle() {
        title.click();
    }

    public void setSearchQuery(String query) {
        searchInput.setValue(query).pressEnter();
    }

    public boolean isShowMoreLinkDisplayed() {
        return link.isDisplayed();
    }

    public boolean isShowMoreLinkEnabled() {
        return link.isEnabled();
    }

    public void clickShowMoreLink() {
        link.click();
    }

    public String getHomeLinkText() {
        return homeLink.getText();
    }

    public void clickHomeLink() {
        homeLink.click();
    }
}
