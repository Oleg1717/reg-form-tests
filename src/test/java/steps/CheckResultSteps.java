package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckResultSteps {

    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    @Step("Check result title")
    public void checkResultTitle() {
        $(".modal-title").shouldHave(text(RESULTS_TITLE));
    }

    @Step("Check the field {selector}")
    public void checkResultValue(String selector, String value) {
        $(".table-responsive").$(byText(selector)).parent()
                .shouldHave(text(value));
    }

    @Step("Check FirstName wrong value")
    public CheckResultSteps checkWrongFirstName() {
        assertThat($("#firstName").getCssValue("border-color"))
                .isEqualTo("rgb(220, 53, 69)");
        return this;
    }

    @Step("Check Last Name wrong value")
    public CheckResultSteps checkWrongLastName() {
        assertThat($("#lastName").getCssValue("border-color"))
                .isEqualTo("rgb(220, 53, 69)");
        return this;
    }

    @Step("Check Email wrong value")
    public CheckResultSteps checkWrongEmail() {
        assertThat($("#userEmail").getCssValue("border-color"))
                .isEqualTo("rgb(220, 53, 69)");
        return this;
    }

    @Step("Check Gender wrong value")
    public CheckResultSteps CheckWrongGender() {
        assertThat($("[for=gender-radio-1]").getCssValue("color"))
                .isEqualTo("rgba(220, 53, 69, 1)");
        return this;
    }

    @Step("Check DateOfBirth wrong value")
    public CheckResultSteps CheckWrongDateOfBirth() {
        assertThat($("#dateOfBirthInput").getCssValue("border-color"))
                .isEqualTo("rgb(220, 53, 69)");
        return this;
    }
}




