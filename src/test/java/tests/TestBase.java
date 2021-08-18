package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.Project.isVideoOn;
import static helpers.AllureAttachments.*;
import static helpers.DriverSettings.configure;
import static helpers.DriverUtils.getSessionId;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        configure();
    }

    @AfterEach
    @Step("Add attachments")
    public void addAttachments() {
        String sessionId = getSessionId();

        addScreenshotAs("last screenshot");
        addPageSource();
        addBrowserConsoleLogs();
//        AllureAttachments.attachNetwork(); // todo

        closeWebDriver();

        if (isVideoOn()) {
            addVideo(sessionId);
        }
    }
}

