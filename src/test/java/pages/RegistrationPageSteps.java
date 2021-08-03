package pages;

import components.CalendarSelectDate;
import helpers.Attach;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPageSteps {

    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";
    private final CalendarSelectDate calendarSelectDate = new CalendarSelectDate();

    @Step("Open student registration form")
    public RegistrationPageSteps openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Enter first name")
    public RegistrationPageSteps typeFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    @Step("Enter last name")
    public RegistrationPageSteps typeLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    @Step("Enter email")
    public RegistrationPageSteps typeEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    @Step("Select gender")
    public RegistrationPageSteps selectGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    @Step("Enter mobile number")
    public RegistrationPageSteps typeMobileNumber(String mobileNumber) {
        $("#userNumber").val(mobileNumber);
        return this;
    }

    @Step("Set date of birth")
    public RegistrationPageSteps setDateOfBirth(String day, String month, String year) {
        calendarSelectDate.selectDate(day, month, year);
        return this;
    }

    @Step("Select subject")
    public RegistrationPageSteps selectSubject(String subject) {
        $("#subjectsInput").val(subject).pressEnter();
        return this;
    }

    @Step("Select hobbies")
    public RegistrationPageSteps selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Upload picture")
    public RegistrationPageSteps uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath("img/"+fileName);
        return this;
    }

    @Step("Enter current address")
    public RegistrationPageSteps typeCurrentAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    @Step("Select state")
    public RegistrationPageSteps selectState(String state) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    @Step("Select city")
    public RegistrationPageSteps selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    @Step("Submit form")
    public RegistrationPageSteps formSubmit() {
        $("#submit").click();
        return this;
    }

    @Step("Check result title")
    public void checkResultTitle() {
        $(".modal-title").shouldHave(text(RESULTS_TITLE));
    }

    @Step("Check the field {selector}")
    public void checkResultValue(String selector, String value) {
        $(".table-responsive").$(byText(selector)).parent()
                .shouldHave(text(value));
    }

    @Step("Added screenshot: {elementName}")
    public RegistrationPageSteps addElementScreenshot(String selector, String elementName) {
        Attach.getElementScreenshotAs(selector, elementName);
        return this;
    }

    @Step("Check email wrong value")
    public RegistrationPageSteps checkWrongEmail() {
        assertThat($("#userEmail").getCssValue("border-color"))
                .isEqualTo("rgb(220, 53, 69)");
        return this;
    }

}




