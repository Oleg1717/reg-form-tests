package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.Project.isVideoOn;
import static helpers.AllureAttachments.*;
import static helpers.DriverSettings.configure;
import static helpers.DriverUtils.getSessionId;

public class TestBase {
    @BeforeAll
    static void setup() {
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

