package steps;

import helpers.AllureAttachments;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class FillFormSteps {

    private final static String FORM_TITLE = "Student Registration Form";

    @Step("Open student registration form")
    public FillFormSteps openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Enter first name")
    public FillFormSteps typeFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    @Step("Enter last name")
    public FillFormSteps typeLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    @Step("Enter email")
    public FillFormSteps typeEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    @Step("Select gender")
    public FillFormSteps selectGender(String gender) {
        if (!gender.equals("")) $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    @Step("Enter mobile number")
    public FillFormSteps typeMobileNumber(String mobileNumber) {
        $("#userNumber").val(mobileNumber);
        return this;
    }

    @Step("Set date of birth")
    public FillFormSteps setDateOfBirth(String day, String month, String year) {
        if (!day.equals("") && !month.equals("") && !year.equals("")) {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption(year);
            $(".react-datepicker__month-select").selectOption(month);
            $(format(".react-datepicker__day--0%s" +
                    ":not(.react-datepicker__day--outside-month)", day)).click();
        }
        return this;
    }

    @Step("Select subject")
    public FillFormSteps selectSubject(String subject) {
        $("#subjectsInput").val(subject).pressEnter();
        return this;
    }

    @Step("Select hobbies")
    public FillFormSteps selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Upload picture")
    public FillFormSteps uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath("img/" + fileName);
        return this;
    }

    @Step("Enter current address")
    public FillFormSteps typeCurrentAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    @Step("Select state")
    public FillFormSteps selectState(String state) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    @Step("Select city")
    public FillFormSteps selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    @Step("Submit form")
    public FillFormSteps clickSubmitButton() {
        $("#submit").click();
        return this;
    }

    @Step("Added screenshot: {elementName}")
    public FillFormSteps addElementScreenshot(String selector, String elementName) {
        AllureAttachments.addElementScreenshotAs(selector, elementName);
        return this;
    }


}




