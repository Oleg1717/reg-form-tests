package helpers;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static config.ConfigHelper.getAppUrl;
import static config.ConfigHelper.projectConfig;

public class DriverSettings {

    private static final Logger LOG = LoggerFactory.getLogger("Config properties");

    public static void configureSelenide() {
        LOG.info("Environment: {}", projectConfig().environment());
        LOG.info("Threads: {}", projectConfig().threads());
        LOG.info("Remote driver url: {}", projectConfig().remoteDriverUrl());
        LOG.info("Base url: {}", getAppUrl());
        LOG.info("Browser name: {}", projectConfig().browserName());
        LOG.info("Browser version: {}", projectConfig().browserVersion());
        LOG.info("Browser size: {}", projectConfig().browserSize());

        Configuration.baseUrl = getAppUrl();
        Configuration.browser = projectConfig().browserName();
        Configuration.browserVersion = projectConfig().browserVersion();
        Configuration.browserSize = projectConfig().browserSize();

        if (!projectConfig().remoteDriverUrl().equals("")) {
            //capabilities.setCapability("enableVNC", true);
            Configuration.remote = projectConfig().remoteDriverUrl();
        }
    }
}