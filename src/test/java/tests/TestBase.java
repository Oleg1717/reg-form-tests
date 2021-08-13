package tests;

import helpers.AllureAttachments;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.*;
import static config.Credentials.credentials;

public class TestBase {
    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        startMaximized = true;
        baseUrl = "https://demoqa.com";
        if (!credentials.remoteDriverUrl().equals("")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            remote = credentials.remoteDriverUrl();
        }
        browserCapabilities = capabilities;
    }

    @AfterEach
    @Step("Add attachments")
    public void tearDown() {
        AllureAttachments.getScreenshotAs("last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
    }
}

