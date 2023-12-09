package ua.foxminded.scarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;

public class TaskPage extends BasePage {

    private SelenideElement dropDown = $("#tasksDropdown");
    private SelenideElement taskLink = $("a[href='/tasks/register/volunteer']");
    private SelenideElement taskName = $("#name");
    private SelenideElement choiceCategoryBtn = $(".dropdown-toggle");
    private SelenideElement categoryProgramming = $("#bs-select-1-5");
    private SelenideElement taskDescription = $("#description");
    private SelenideElement taskExpected = $("#expectedOutcome");
    private SelenideElement taskBenefit = $("#benefit");
    private SelenideElement savedMoney = $("#savedMoney");
    private SelenideElement stage1Task = $("input[name='stages[0].duration']");
    private SelenideElement stage2Task = $("input[name='stages[1].duration']");
    private SelenideElement buttonSuccess = $("button[value='PUBLISHED']");
    private SelenideElement deadLine = $("#deadline");
    private SelenideElement profile = $("//*[@id='navbarNav']/a[1]/i");
    private SelenideElement myTasks = $("a[href='#tasksSubmenu']");

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public TaskPage creationTask() {
        dropDown.click();
        taskLink.click();
        return this;
    }

    public TaskPage fillTaskForm(String taskNameValue, String taskDescriptionValue, String expectedValue, String benefitValue, String savedMoneyValue, String stage1Value, String stage2Value) {
        taskName.setValue(taskNameValue);
        choiceCategoryBtn.click();
        categoryProgramming.click();

        LocalDate currentDate = LocalDate.now();
        LocalDate deadlineDate = currentDate.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDeadline = deadlineDate.format(formatter);

        deadLine.setValue(formattedDeadline);
        taskDescription.setValue(taskDescriptionValue);
        taskExpected.setValue(expectedValue);
        taskBenefit.setValue(benefitValue);
        savedMoney.setValue(savedMoneyValue);
        stage1Task.setValue(stage1Value);
        stage2Task.setValue(stage2Value);

        return this;
    }

    public TaskPage submitTask() {
        buttonSuccess.click();
        return this;
    }

    public TaskPage checkTasks() {
        profile.click();
        myTasks.click();
        // Вызов функции для открытия страницы publishedTasks
        openPublishedTasksPage();
        return this;
    }

    private void openPublishedTasksPage() {
        // код для открытия страницы publishedTasks
    }
}
