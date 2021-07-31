package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static io.qameta.allure.Allure.step;

public class TestBase {

    @BeforeAll
    static void setup() {
        baseUrl = "https://demoqa.com";
        startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        step("Add test attachments", () -> {
            Attach.getScreenshotAs("last screenshot");
            Attach.getSourceCode();
        });
    }
}
