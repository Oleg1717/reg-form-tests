package helpers;

import config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static config.Project.config;
import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

public class DriverSettings {

    public static void configure() {
        browser = config.browser();
        browserVersion = config.browserVersion();
        browserSize = config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (Project.isWebMobile()) { // for chrome only
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", config.browserMobileView());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            remote = config.remoteDriverUrl();
        }

        capabilities.setCapability(CAPABILITY, chromeOptions);
        browserCapabilities = capabilities;
        startMaximized=true;
        baseUrl = "https://demoqa.com";
    }
}
