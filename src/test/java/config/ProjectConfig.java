package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties"})
public interface ProjectConfig extends Config {

    @Config.Key("environment")
    String environment();

    @Config.Key("threads")
    @DefaultValue("2")
    int threads();

    @Config.Key("remote.driver.url")
    @Config.DefaultValue("")
    String remoteDriverUrl();

    @Config.Key("browser.name")
    @Config.DefaultValue("chrome")
    String browserName();

    @Config.Key("browser.version")
    String browserVersion();

    @Config.Key("browser.size")
    @Config.DefaultValue("1280x1024")
    String browserSize();

    @Config.Key("sso.values")
    String ssoValues();

    @Key("videoStorage")
    String videoStorage();
}
