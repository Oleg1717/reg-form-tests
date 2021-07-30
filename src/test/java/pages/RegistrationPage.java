package pages;

import components.CalendarSelectDate;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {

    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";
    private final CalendarSelectDate calendarSelectDate = new CalendarSelectDate();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage typeMobileNumber(String mobileNumber) {
        $("#userNumber").val(mobileNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarSelectDate.selectDate(day, month, year);
        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        $("#subjectsInput").val(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/"+fileName));
        return this;
    }

    public RegistrationPage typeCurrentAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void formSubmit() {
        $("#submit").click();
    }

    public void checkResultTitle() {
        $(".modal-title").shouldHave(text(RESULTS_TITLE));
}

    public void checkResultValue(String selector, String value) {
        $(".table-responsive").$(byText(selector)).parent()
                .shouldHave(text(value));
}
}




