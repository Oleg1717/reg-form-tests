package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static AppConfig appConfig() {
        return ConfigFactory.newInstance().create(AppConfig.class, System.getProperties());
    }

    public static String getAppUrl() {
        return appConfig().appUrl();
    }

    public static String getMfcUrl() {
        return appConfig().apiMfcUrl();
    }

    public static String getApiExtUrl() {
        return appConfig().apiExtUrl();
    }

    public static String getMbBlancerUrl() {
        return appConfig().mbBalancer();
    }

    public static ProjectConfig projectConfig() {
        return ConfigFactory.newInstance()
                .create(ProjectConfig.class, System.getProperties());
    }
}
