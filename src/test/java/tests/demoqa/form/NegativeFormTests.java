package tests.demoqa.form;

import helpers.RandomFormData;
import helpers.annotations.JiraIssue;
import helpers.annotations.JiraIssues;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CheckResultSteps;
import steps.FillFormGroupSteps;
import tests.TestBase;

@Tag("form")
@JiraIssues({@JiraIssue("AUTO-17")})
@Feature("DemoQA form tests")
@Severity(SeverityLevel.NORMAL)
@Owner("OlegV")
@Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
public class NegativeFormTests extends TestBase {

    private final FillFormGroupSteps groupedSteps = new FillFormGroupSteps();
    private final CheckResultSteps checkSteps = new CheckResultSteps();

    @Test
    @Story("Field tests")
    @DisplayName("Testing a form with an empty \"First name\" field")
    void negativeFirstNameTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.firstName = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongFirstName();
    }

    @Test
    @Story("Field tests")
    @DisplayName("Testing a form with an empty \"Last name\" field")
    void negativeLastNameTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.lastName = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongLastName();
    }

    @Test
    @Story("Field tests")
    @DisplayName("Testing a form with an empty \"Email\" field")
    void negativeEmailTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.email = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongEmail();
    }

    @Test
    @Story("Field tests")
    @DisplayName("Testing a form with the \"Gender\" field value not selected")
    void negativeGenderTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.gender = "";
        groupedSteps.fillForm(rndData);
        checkSteps.CheckWrongGender();
    }

    @Test
    @Story("Field tests")
    @DisplayName("Testing a form with the \"Date of birth\" field value not selected")
    void negativeDateOfBirthTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.day = "";
        rndData.month = "";
        rndData.year = "";
        groupedSteps.fillForm(rndData);
        checkSteps.CheckWrongDateOfBirth();
    }
}
