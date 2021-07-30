package tests;

import components.RandomFormData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;

public class FormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomFormData rndData = new RandomFormData();

    @BeforeAll
    static void setup() {
        baseUrl = "https://demoqa.com";
        startMaximized = true;
    }

    @Test
    void positiveTypeTest() {

        registrationPage.openPage()
                .typeFirstName(rndData.firstName)
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
                .formSubmit();

        registrationPage.checkResultTitle();
        for (String key : rndData.dataForCheck.keySet()) {
            String value = rndData.dataForCheck.get(key);
            registrationPage.checkResultValue(key, value);
        }
    }
}
