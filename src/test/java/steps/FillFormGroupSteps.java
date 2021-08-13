package steps;

import helpers.RandomFormData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class FillFormGroupSteps {

    FillFormSteps steps = new FillFormSteps();
    CheckResultSteps checkSteps = new CheckResultSteps();

    @Step("Fill student registration form")
    public void fillForm(RandomFormData rndData) {

        steps.openPage()
                .typeFirstName(rndData.firstName)
                .typeLastName(rndData.lastName)
                .selectGender(rndData.gender)
                .setDateOfBirth(rndData.day, rndData.month, rndData.year)
                .uploadFile(rndData.fileName)
                .typeEmail(rndData.email)
                .typeMobileNumber(rndData.mobileNumber)
                .typeCurrentAddress(rndData.currentAddress)
                .selectState(rndData.state)
                .selectCity(rndData.city)
                .selectSubject(rndData.subject)
                .selectHobby(rndData.hobby)
                .addElementScreenshot(".practice-form-wrapper", "full-filled form")
                .clickSubmitButton();
        sleep(1000);
    }

    @Step("Verify successful form submit")
    public void checkResult(RandomFormData rndData) {
        checkSteps.checkResultTitle();
        for (String key : rndData.dataForCheck.keySet()) {
            String value = rndData.dataForCheck.get(key);
            checkSteps.checkResultValue(key, value);
        }
    }
}
