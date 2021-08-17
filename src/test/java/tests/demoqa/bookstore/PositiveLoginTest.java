package tests.demoqa.bookstore;

import com.github.javafaker.Faker;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PositiveLoginTest extends TestBase {

    private final Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userName = firstName+"."+lastName;
    public String password = faker.internet()
            .password(8, 20, true, true, true);

    @Test
    @Disabled
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Book store application", url = "https://demoqa.com/login")
    @DisplayName("Login page test with random data")
    void newUserTest() {
        step("Check new user creation", () -> {
            step("Open book store application login page", () -> {
                open("/login");
                $(".main-header").shouldHave(text("Login"));
            });
            step("Click NewUser button", () -> {
                $("#newUser").click();
                $(".main-header").shouldHave(text("Register"));
            });
            step("Fill full user data", () -> {
                step("Fill UserName field", () -> $("#firstname").val(firstName));
                step("Fill Password field", () -> $("#lastname").val(lastName));
                step("Fill UserName field", () -> $("#userName").val(userName));
                step("Fill Password field", () -> $("#password").val(password));
            });
            step("Check Captcha", () -> $("#g-recaptcha").click());
            step("Register to book store", () -> $("#register")).click();
            //step("Check that the new user is registered", switchTo().alert()::accept);
            sleep(8);
        });
    }

    @Test
    @Disabled
    @Severity(SeverityLevel.NORMAL)
    @Owner("OlegV")
    @Link(name = "ToolsQA: Book store application", url = "https://demoqa.com/login")
    @DisplayName("Login page test with existing user")
    void existingUserTest() {
        step("Check new user creation", () -> {
            step("Open book store application login page", () -> {
                open("/login");
                $(".main-header").shouldHave(text("Login"));
            });
            step("Fill user data", () -> {
                step("Fill UserName field", () -> $("#userName").val(userName));
                step("Fill Password field", () -> $("#password").val(password));
            });
            step("Click NewUser button", () -> {
                $("#newUser").click();
                $(".main-header").shouldHave(text("Register"));
            });

        });
    }

}
