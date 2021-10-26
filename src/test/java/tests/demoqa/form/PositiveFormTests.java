package tests.demoqa.form;

import helpers.RandomFormData;
import helpers.annotations.JiraIssue;
import helpers.annotations.JiraIssues;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.FillFormGroupSteps;
import tests.TestBase;

@Feature("DemoQA form tests")
@JiraIssues({@JiraIssue("AUTO-17")})
public class PositiveFormTests extends TestBase {

    private final RandomFormData rndData = new RandomFormData();
    private final FillFormGroupSteps groupedSteps = new FillFormGroupSteps();

    @Test
    @AllureId("5615")
    @JiraIssues({@JiraIssue("AUTO-17")})
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @Story("Registration tests")
    @DisplayName("Student registration form test with random data")
    void positiveType() {
        groupedSteps.fillForm(rndData);
        groupedSteps.checkResult(rndData);
    }
}
