package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement title = $("h4.text-dark-red");

    public String getTitleText() {
        return title.getText();
    }

}
