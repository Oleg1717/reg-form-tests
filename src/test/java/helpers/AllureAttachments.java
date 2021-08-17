package helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static helpers.DriverUtils.getVideoUrl;
import static io.qameta.allure.Allure.addAttachment;
import static org.openqa.selenium.OutputType.BYTES;

public class AllureAttachments {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureAttachments.class);

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