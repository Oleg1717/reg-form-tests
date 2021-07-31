package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.OutputType.BYTES;

public class Attach {

    @Attachment(value = "Screenshot: {elementName}", type = "image/png")
    public static byte[] getElementScreenshotAs(String selector,String elementName) {
        return $(selector).getScreenshotAs(BYTES);
    }

    @Attachment(value = "Screenshot: {screenshotName}", type = "image/png")
    public static byte[] getScreenshotAs(String screenshotName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(BYTES);
    }

    @Attachment(value = "Page source code", type = "text/plain")
    public static byte[] getSourceCode() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}
