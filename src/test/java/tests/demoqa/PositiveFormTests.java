package tests.demoqa;

import components.AllFieldsRandomData;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageSteps;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class PositiveFormTests extends TestBase {

    private final RegistrationPageSteps steps = new RegistrationPageSteps();
    private final AllFieldsRandomData rndData = new AllFieldsRandomData();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Practice form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Student registration form test with random data")
    void positiveTypeTest() {
        steps.openPage();
        step("Fill student registration form", () ->
                steps.typeFirstName(rndData.firstName)
                        .typeLastName(rndData.lastName)
                        .typeEmail(rndData.email)
                        .selectGender(rndData.gender)
                        .typeMobileNumber(rndData.mobileNumber)
                        .setDateOfBirth(rndData.day, rndData.month, rndData.year)
                        .selectSubject(rndData.subject)
                        .selectHobby(rndData.hobby)
                        .uploadFile(rndData.fileName)
                        .typeCurrentAddress(rndData.currentAddress)
                        .selectState(rndData.state)
                        .selectCity(rndData.city)
                        .addElementScreenshot(".practice-form-wrapper", "full-filled form")
                        .formSubmit());

        step("Verify successful form submit", () -> {
            steps.checkResultTitle();
            for (String key : rndData.allDataForCheck.keySet()) {
                String value = rndData.allDataForCheck.get(key);
                steps.checkResultValue(key, value);
            }
        });

    }
}
