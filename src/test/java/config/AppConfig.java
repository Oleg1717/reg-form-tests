package config;

import org.aeonbits.owner.Config;

// to change .properties encoding use  iconv -f Windows-1251 -t UTF-8//TRANSLIT prod.properties -o prod.properties
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})
public interface AppConfig extends Config {

    @Key("app.url")
    String appUrl();

    @Key("api.ext.url")
    String apiExtUrl();

    @Key("ldap.store.id")
    String ldapStoreId();

    @Key("api.mfc.url")
    String apiMfcUrl();

    @Key("api.mfc.domain")
    @DefaultValue("")
    String apiMfcDomain();

    @Key("mb.balancer")
    String mbBalancer();

    @Key("elk.sudir")
    String elkSudir();


}