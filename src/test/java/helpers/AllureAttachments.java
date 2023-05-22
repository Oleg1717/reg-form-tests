package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.DriverUtils.LOGGER;
import static helpers.DriverUtils.getVideoUrl;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static org.openqa.selenium.OutputType.BYTES;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class AllureAttachments {

    public static void BrowserLog() {
        attachAsText("log",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png", fileExtension = "png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain", fileExtension = "json")
    public static byte[] attachPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }


    @Attachment(value = "{attachName}", type = "text/plain")
    public static String addMessage(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] addPageSource() {
        return DriverUtils.getPageSourceAsBytes();
    }

    @Attachment(value = "Screenshot: {elementName}", type = "image/png")
    public static byte[] addElementScreenshotAs(String selector, String elementName) {
        return $(selector).getScreenshotAs(BYTES);
    }

    @Attachment(value = "Screenshot: {attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return DriverUtils.getScreenshotAsBytes();
    }

    public static void addBrowserConsoleLogs() {
        addMessage("Browser console logs", DriverUtils.getConsoleLogs());
    }

    public static void addVideo(String sessionId) {
        URL videoUrl = getVideoUrl(sessionId);
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            sleep(1000);

            for (int i = 0; i < 10; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    sleep(1000);
                } catch (IOException e) {
                    LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl);
                    e.printStackTrace();
                }
            }
            addAttachment("Video", "video/mp4", videoInputStream, "mp4");
        }
    }
}
