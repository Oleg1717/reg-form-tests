package tests.demoqa.forms;

import helpers.RandomFormData;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.FillFormGroupSteps;
import tests.TestBase;

public class PositiveFormTests extends TestBase {

    private final RandomFormData rndData = new RandomFormData();
    private final FillFormGroupSteps groupedSteps = new FillFormGroupSteps();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Student registration form test with random data")
    void positiveTypeTest() {
        groupedSteps.fillForm(rndData);
        groupedSteps.checkResult(rndData);
    }
}
