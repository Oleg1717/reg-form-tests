package config;

import org.aeonbits.owner.Config;

// to change .properties encoding use  iconv -f Windows-1251 -t UTF-8//TRANSLIT prod.properties -o prod.properties
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/users.properties"
})
public interface UsersConfig extends Config {
    @Key("user${user.number}.name")
    String name();
    @Key("user${user.number}.lastname")
    String lastname();
    @Key("user${user.number}.middlename")
    String middlename();
    @Key("user${user.number}.email")
    String email();
    @Key("user${user.number}.phone")
    String phone();
    @Key("user${user.number}.snils")
    String snils();
    @Key("user${user.number}.password")
    String password();

    @Key("user${user.number}.esia")
    String esia();
    @Key("user${user.number}.esia.password")
    String esiaPassword();
    @Key("user${user.number}.esia.id")
    String esiaId();
    @Key("user${user.number}.esia.guid")
    String esiaGuid();

    @Key("user${user.number}.esia")
    String sberId();
    @Key("user${user.number}.esia.password")
    String sberIdPassword();

    @Key("user${user.number}.vk")
    String vk();
    @Key("user${user.number}.vk.password")
    String vkPassword();

    @Key("user${user.number}.ok")
    String ok();
    @Key("user${user.number}.okPassword")
    String okPassword();

    @Key("user${user.number}.esia")
    String google();
    @Key("user${user.number}.esia.password")
    String googlePassword();

    @Key("user${user.number}.mailru")
    String mailru();
    @Key("user${user.number}.mailru.password")
    String mailruPassword();

    @Key("user${user.number}.esia")
    String fb();
    @Key("user${user.number}.esia.password")
    String fbPassword();

    @Key("user${user.number}.yandex")
    String yandex();
    @Key("user${user.number}.yandex.password")
    String yandexPassword();
    @Key("user${user.number}.yandex.answer")
    String yandexAnswer();
    @Key("user${user.number}.mesh")
    String mesh();

    @Key("user${user.number}.trusted")
    Boolean trusted();

    @Key("user${user.number}.locked")
    Boolean locked();

    @Key("user${user.number}.sso.${environment}")
    String sso();

    @Key("user${user.number}.birthDate")
    String birthDate();

    @Key("user${user.number}.orgInn")
    String orgInn();

    @Key("user${user.number}.orgOgrn")
    String orgOgrn();

    @Key("user${user.number}.orgName")
    String orgName();

    @Key("user${user.number}.orgId")
    String orgId();

    @Key("user${user.number}.instanceid.${environment}")
    String instanceId();
}