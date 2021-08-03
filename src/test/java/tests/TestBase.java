package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.*;
import static config.Credentials.credentials;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;


public class TestBase {
    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        browserCapabilities = capabilities;
        startMaximized = true;
        baseUrl = "https://demoqa.com";

        String remoteHost = System.getProperty("remoteHost");
        //if (!remoteHost.isBlank()) {
        System.out.println(remoteHost);
        if (remoteHost != null && !remoteHost.isEmpty()) {
            remote = format("https://%s:%s@%s", credentials.login()
                    , credentials.password()
                    , System.getProperty("remoteHost"));
        }
    }

    @AfterEach
    public void tearDown() {
        step("Add attachments", () -> {
            Attach.getScreenshotAs("last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });


    }
}

