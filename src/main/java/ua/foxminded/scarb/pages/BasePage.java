package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;
    protected String emailUrl = "https://skarbmail.foxminded.ua/";
    protected String registrationUrl = "https://skarb.foxminded.ua/registration/confirm";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
