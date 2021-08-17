package tests.demoqa.forms;

import helpers.RandomFormData;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.CheckResultSteps;
import steps.FillFormGroupSteps;
import tests.TestBase;

public class NegativeFormTests extends TestBase {

    private final FillFormGroupSteps groupedSteps = new FillFormGroupSteps();
    private final CheckResultSteps checkSteps = new CheckResultSteps();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Testing a form with an empty \"First name\" field")
    void negativeFirstNameTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.firstName = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongFirstName();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Testing a form with an empty \"Last name\" field")
    void negativeLastNameTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.lastName = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongLastName();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Testing a form with an empty \"Email\" field")
    void negativeEmailTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.email = "";
        groupedSteps.fillForm(rndData);
        checkSteps.checkWrongEmail();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Testing a form with the \"Gender\" field value not selected")
    void negativeGenderTest() {
        RandomFormData rndData = new RandomFormData();
        rndData.gender = "";
        groupedSteps.fillForm(rndData);
        checkSteps.CheckWrongGender();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
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
