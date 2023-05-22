package pages.authorization;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static config.ConfigHelper.getAppUrl;
import static helpers.utils.RandomUtils.getRandomString;

public class LoginPage {

    //old design
/*     private final SelenideElement entryForm = $(".form-wrapper");
    private final SelenideElement systemHeader = $("div.system-header");
    private final SelenideElement pageTitle = $("h1.page-title");
    private final SelenideElement appName = pageTitle.$("span.app-name");
    private final SelenideElement rememberedUsersLink = $(".mus-back");
    private final SelenideElement notMeButton = $(".btn.btn-link.mus-back");
    private final SelenideElement loginInput = $("#login");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement recoveryPasswordLink = $("div#recoveryEnter");
    private final SelenideElement enterButton = $("#bind");
    private final SelenideElement mailRuIcon = $(".meth-mail");
    private final SelenideElement esiaIcon = $(".meth-esia");
    private final SelenideElement smsIcon = $(".meth-sms");
    private final SelenideElement registerLink = $("#regEnter");
    private final SelenideElement hintMessage = $(".parsley-required");
    private final SelenideElement blockquoteDangerMessage = $(".fs14");*/

    //new design
    private final SelenideElement entryForm = $(".system-main__form");
    private final SelenideElement systemHeader = $(".system-header__h1");
    private final SelenideElement pageTitle = $(".page-title");
    private final SelenideElement appName = $(".system-header__desc");
    private final SelenideElement rememberedUsersLink = $(".noAccount__button");// todo объединить в один элемент
    private final SelenideElement notMeButton = $(".hasAccount__button"); //todo объединить в один элемент
    private final SelenideElement loginInput = $("#login");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement showPasswordCheckbox = $("[data-js=form-toggle-password]");
    private final SelenideElement recoveryPasswordLink = $("#recoveryEnter > a");
    private final SelenideElement enterButton = $(".form-login__submit");
    private final SelenideElement toggleButton = $(".item.formFooter__button.formFooter__toggle");
    private final SelenideElement mailRuIcon = $(".meth-mail");
    private final SelenideElement okIcon = $(".meth-ok");
    private final SelenideElement VkIcon = $(".meth-vk");
    private final SelenideElement YandexIcon = $(".meth-yandex");
    private final SelenideElement esiaIcon = $(".meth-esia");
    private final SelenideElement smsIcon = $(".meth-sms");
    private final SelenideElement registerLink = $("#regEnter");
    private final SelenideElement hintMessage = $(".parsley-required");
    private final SelenideElement blockquoteDangerMessage = $(".blockquote-danger");
    private final SelenideElement recoveryPasswordLinkInMessage = blockquoteDangerMessage.$("a");

    //новый дизайн
    @Step("Проверить сообщение на главной странице с новым дизайном")
    public void checkLoginPageNewDesign() {
        $(".system-header__h1").shouldHave(text("Доступ к информационным ресурсам города Москвы"));
        $(".top h1.page-title").shouldHave(text("Вход"));
    }

    @Step("Проверить сообщение на главной странице")
    public void checkLoginPage() {
        systemHeader.shouldHave(text("Доступ к информационным ресурсам города Москвы"));
        pageTitle.shouldHave(text("Вход"));
    }

    @Step("Проверить название приложения")
    public void checkAppName(String appNameValue) {
        appName.shouldHave(text(appNameValue));
    }

    @Step("Ввести логин")
    public void enterLogin(String login) {
        loginInput.setValue(login);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Нажать кнопку 'Другие методы входа'")
    public void clickToggleButton() {
        toggleButton.click();
    }
    @Step("Нажать кнопку 'Войти'")
    public void clickEnter() {
        enterButton.click();
    }

    @Step("Клик по иконке Mail")
    public void clickMailIcon() {
        clickToggleButton();
        mailRuIcon.click();
    }

    @Step("Клик по иконке Ok")
    public void clickOkIcon() {
        clickToggleButton();
        okIcon.click();
    }

    @Step("Клик по иконке Vk")
    public void clickVkIcon() {
        clickToggleButton();
        VkIcon.click();
    }

    @Step("Клик по иконке Yandex")
    public void clickYandexIcon() {
        clickToggleButton();
        YandexIcon.click();
    }


    @Step("Клик по иконке Госуслуги")
    public void clickEsiaIcon() {
        esiaIcon.click();
    }

    @Step("Нажать на ссылку \"Восстановить пароль\"")
    public void clickRecovery() {
        recoveryPasswordLink.click();
    }

    @Step("Нажать на ссылку \"Восстановить пароль\" в тексте ошибки")
    public void clickRecoveryLinkInMessage() {
        recoveryPasswordLinkInMessage.click();
    }

    @Step("Открыть приложение")
    public void openApplication(String url) {
        open(url);
    }

    @Step("Перейти на портал")
    public void openLoginPage() {
        open("/sps/profile");
        checkLoginPage();
    }

    @Step("Клик 'Запомненные пользователи'")
    public void clickMemorizedUsers() {
        rememberedUsersLink.click();
    }

    @Step("Клик 'Это не я'")
    public void clickNotMeBtn() {
        sleep(3000);
        notMeButton.click();
    }

    @Step("Клик по кнопке 'Код в Смс'")
    public void clickSmsButton() {
        smsIcon.click();
    }

    @Step("Выбрать метод входа 'Код в Смс'")
    public void chooseSmsMethod() {
        clickToggleButton();
        clickSmsButton();
    }


    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegistrationLink() {
        registerLink.click();
    }

    @Step("Проверить отсутствие запомненных пользователей на странице входа")
    public void checkNoRememberUsers() {
        entryForm.shouldNotHave(text("Запомненные пользователи"));
    }

    @Step("Авторизация ЮЛ через приложение")
    public void authLegalEntity(String login, String password) {
        if (($(".MuiButton-label")).exists()) {
            $(byText("Войти")).click();
        }
        mainAuth(login, password);
    }

    @Step("Авторизоваться в УЗ")
    public void mainAuth(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickEnter();
    }

    @Step("Повторно авторизоваться в УЗ")
    public void secondAuth(String password) {
        enterPassword(password);
        clickEnter();
    }

    @Step("Авторизоваться в УЗ без логина")
    public void mainAuthWithoutLogin(String password) {
        enterPassword(password);
        clickEnter();
    }

    @Step("Авторизоваться в УЗ без пароля")
    public void mainAuthWithoutPassword(String login) {
        enterLogin(login);
        clickEnter();
    }

    @Step("Перейти на страницу восстановления пароля")
    public void openRecoveryPage() {
        openLoginPage();
        clickRecovery();
    }

    @Step("Переход на страницу регистрации пользователя")
    public void openRegistrationPage() {
        openLoginPage();
        clickRegistrationLink();
    }

    @Step("Сообщение с подсказкой 'Введите логин'")
    public void authWithoutLogin() {
        hintMessage.shouldHave(text("Введите логин"));
    }

    @Step("Сообщение с подсказкой 'Введите пароль'")
    public void authWithoutPassword() {
        hintMessage.shouldHave(text("Введите пароль"));
    }

    @Step("Проверить сообщение после входа с прошлым паролем")
    public void authWithoutOldPassword() {
        blockquoteDangerMessage.shouldHave(text("Введен некорректный логин или пароль"));
    }

    @Step("Сообщение об ошибке авторизации")
    public void authErrorMessage() {
        blockquoteDangerMessage.shouldHave(text("Введен некорректный логин или пароль.\n" +
                "Телефон может быть введен в любом формате, например, +79991234567.\n" +
                "СНИЛС должен быть указан в виде последовательности цифр через дефисы или без разделителей.\n" +
                "Электронная почта должна содержать символ @.\n" +
                "Логин школьника в Электронном дневнике может содержать цифры, латинские буквы.\n" +
                "\n" +
                "Если вы не помните пароль, то воспользуйтесь функцией «Восстановить пароль»"));
    }

    @Step("Проверить сообщение об ошибке")
    public void checkAccountIsBlockedMessage() {
        blockquoteDangerMessage.shouldHave(text("Ваша учетная запись заблокирована или удалена."));
    }

    @Step("Проверить сообщение об ошибке")
    public void checkAccountIsBlockedMessageAfterESIALogin() {
        blockquoteDangerMessage.shouldHave(text("Ваша учетная запись заблокирована"));
    }

    // todo перенести в recoveryPasswordPage
    @Step("Переход к странице смены пароля, с возможностью ее пропуска")
    public void checkTransferToPasswordChangePage() {
        $("#altPswdFm").shouldHave(text("Ваш пароль не соответствует парольным политикам."));
    }


    //region Открытие приложений
    @Step("Перейти в приложение без 2фа №1")
    public void open2faOff1() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_off_1&redirect_uri=http://localhost/");
        checkAppName("test_2fa_off_1");
    }

    @Step("Перейти в приложение без 2фа №1")
    public void open2faOff1BipActionHintOpenReg() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_1&redirect_uri=http://localhost/&bip_action_hint=open_reg");
        checkAppName("test_2fa_off_1");
    }

    @Step("Перейти в приложение с 2фа №1")
    public void open2faOn1() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_on_1&redirect_uri=http://localhost/");
        checkAppName("test_2fa_on_1");
    }

    @Step("Перейти в приложение с 2фа по TOTP")
    public void open2faTotp() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_for_totp&redirect_uri=http://localhost/");
        checkAppName("test_for_totp");
    }

    @Step("Перейти в приложение autotest_lastinfopage")
    public void openLastInfoPage() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=autotest_lastinfopage&redirect_uri=http://localhost/");
        checkAppName("autotest_lastinfopage");
    }

    @Step("Перейти в приложение для удаления УЗ")
    public void openDeleteAccountApp() {
        openApplication("/bsprofile/req/delete");
  /*      checkAppName("Приложение для удаления учётной записи");*/
    }

    @Step("Перейти в приложение test_for_sms_auth")
    public void openAgApp() {
        openApplication("/sps/oauth/ae?client_id=test_for_sms_auth&response_type=code&scope=openid+profile+contacts&access_type=offline&redirect_uri=https://localhost/");
        checkAppName("test_for_sms_auth");
    }

    @Step("Переход на портал для авторизации ЮЛ")
    public void openTestForOrg() {
        openApplication("/sps/oauth/ae?client_id=autotest_orgchoice&response_type=code&scope=openid+profile&access_type=offline&redirect_uri=http://localhost");
    }

    @Step("Перейти в приложение test_select_org3f_apps")
    public void openTestSelectOrg3fApps() {
        openApplication("/sps/oauth/ae?client_id=test_select_org3f_apps&response_type=code&scope=openid+profile&access_type=offline&redirect_uri=http://localhost");
    }

    @Step("Открыть приложение test_no_ksid_block_app")
    public void openTestNoKsidBlockApp() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_no_ksid_block_app&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение 'test_delay_apps'")
    public void openTestDelayApps() {
        openApplication("/sps/oauth/ae?response_type=code&client_id=test_delay_apps&scope=openid+profile&redirect_uri=http://localhost");
    }

    @Step("Перейти в приложение с 2фа №1 с prompt=login")
    public void open2faOn1PromptLogin() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_on_1&redirect_uri=http://localhost/&prompt=login");
        checkAppName("test_2fa_on_1");
    }

    @Step("Открыть приложение test_2fa_off_2")
    public void openTest2faOff2() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_2&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение с 2фа №2")
    public void open2faOn2() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_on_2&redirect_uri=http://localhost/");
        checkAppName("test_2fa_on_2");
    }

    @Step("Переход на страницу с добавлением разрешений")
    public void goToAddPermissionPage() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=scope_autotest&redirect_uri=http://localhost/");
    }

    @Step("Открыть приложение test_multiaccount")
    public void openTestMultiaccount() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_multiaccount&redirect_uri=http://localhost/");
    }

    @Step("Открыть приложение test_2fa_on_2 в новой вкладке")
    public void newTabTest2faOn2() {
        String a = getAppUrl() + "/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_on_2&redirect_uri=http://localhost/";
        Selenide.executeJavaScript("window.open('" + a + "');");
    }

    @Step("Открыть приложение test_2fa_on_1 в новой вкладке")
    public void newTabTest2faOn1() {
        String a = getAppUrl() + "/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_on_1&redirect_uri=http://localhost/";
        Selenide.executeJavaScript("window.open('" + a + "');");
    }

    @Step("Открыть приложение test_2fa_off_1 в новой вкладке")
    public void newTabTest2faOff1() {
        String a = getAppUrl() + "/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_1&redirect_uri=http://localhost/";
        Selenide.executeJavaScript("window.open('" + a + "');");
    }

    @Step("Открыть приложение test_2fa_off_2 в новой вкладке")
    public void newTabTest2faOff2() {
        String a = getAppUrl() + "/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_2&redirect_uri=http://localhost/";
        Selenide.executeJavaScript("window.open('" + a + "');");
    }

    @Step("Открыть профиль (для SSO)")
    public void openLoginPageSso() {
        open("/sps/profile");
    }

    @Step("Перейти в приложение с новым дизайном без 2фа")
    public void openLoginPageNewDesign2faOff() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_1&redirect_uri=http://localhost/");
        checkLoginPageNewDesign();
    }

    @Step("Перейти на страницу выбора аккаунтов без LogOut (test_multiaccount)")
    public void openSelectAccApp() {
        open("/sps/oauth/ae?response_type=code&client_id=test_select_acc_apps&scope=openid+profile&redirect_uri=http://localhost");
    }

    @Step("Вызвать prompt=login")
    public void openPromptLogin() {
        open("/sps/oauth/ae?prompt=login&response_type=code&client_id=test_multiaccount&scope=openid+profile&redirect_uri=http://localhost");
    }

    @Step("Вызвать prompt=none")
    public void openPromptNone() {
        open("/sps/oauth/ae?prompt=none&response_type=code&client_id=test_multiaccount&scope=openid+profile&redirect_uri=http://localhost");
    }

    @Step("Перейти в приложение с 2фа №1 (по SSO)")
    public void open2faOn1Sso() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_on_1&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение с 2фа №1 с prompt=login")
    public void open2faOn1PromptNone() {
        openApplication("/sps/oauth/ae?scope=openid+profile&response_type=code&client_id=test_2fa_on_1&redirect_uri=http://localhost&prompt=none");
        checkAppName("test_2fa_on_1");
    }

    @Step("Перейти в приложение с 2фа №1 с prompt=login (по SSO)")
    public void open2faOn1PromptNoneSso() {
        open("/sps/oauth/ae?scope=openid+profile&response_type=code&client_id=test_2fa_on_1&prompt=none&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение с 2фа №1")
    public void reOpen2faOn1() {
        switchTo().window(1);
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_on_1&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение с 2фа №1")
    public void reOpen2faOn2() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_on_2&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение с 2фа №1")
    public void reOpen2faOff2() {
        open("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&client_id=test_2fa_off_2&redirect_uri=http://localhost/");
    }

    @Step("Перейти в приложение без 2фа №2")
    public void open2faOff2() {
        openApplication("/sps/oauth/ae?scope=openid+profile&access_type=online&response_type=code&state=342a2c0c-d9ef-4cd6-b328-b67d9baf6a7f&client_id=test_2fa_off_2&redirect_uri=http://localhost/");
        checkAppName("test_2fa_off_2");
    }

    @Step("Перейти в приложение для авторизации ЮЛ (oati.fors.ru)")
    public void loginLegalEntity() {
        open("/sps/oauth/ae?client_id=oati.fors.ru&response_type=code&scope=openid&access_type=offline&redirect_uri=http://oati-app.fors.ru/orders-oati-owner/sudir/login");
    }

    @Step("Перейти в приложение для авторизации ЮЛ (test_for_org)")
    public void openTestForOrg(String s) {
        open("/sps/oauth/ae?client_id=test_for_org&response_type=code&scope=openid+profile&access_type=offline&redirect_uri=http://localhost");
    }

    @Step("Перейти в систему ЕИС ОАТИ АРМ “Балансодержатель” для авторизации ЮЛ")
    public void loginLegalEntity2() {
        open("https://212.46.14.26:9929/orders-oati-owner");
    }
    //endregion

    //region Не используемые

    //Используется в Outdated тесте 416
    @Step("Авторизоваться в УЗ в режиме 'Чужой компьютер'")
    public void mainAuthNotRemember(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickNotRemember();
        clickEnter();
    }

    @Step("Проверить сообщение об ошибке в приложении Test_delay_apps")
    public void checkErrorByEntryTestDelayApps() {
        blockquoteDangerMessage.shouldHave(text("В настоящий момент для вас недоступен вход в приложение"));
    }

    @Step("Сообщение после авторизации в УЗ, зарегистрированной без пароля")
    public void authAccountWithoutPassword() {
        blockquoteDangerMessage.shouldHave(text("Необходимо задать новый пароль. Воспользуйтесь функцией «Восстановить пароль».\n" +
                "Для получения подробной информации перейдите по ссылке"));
    }

    @Step("Клик Подтвердить при логауте")
    public void clickConfirmLogout() {
        $("#confirm").click();
    }

    @Step("Клик 'Подтвердить' без ввода кода из смс")
    public void clickConfirmWithoutSms() {
        $("#verifyBtn").click();
        $(".parsley-custom-error-message").should(appear);
        $(".parsley-custom-error-message").shouldHave(text("Введите код подтверждения"));
    }

    @Step("Ввести случайный код из смс")
    public void enterRandomVerificationSmsCode() {
        $("#sms-code").val(getRandomString(5));
        $("#verifyBtn").click();
        $(".text-danger").should(appear);
        $(".text-danger").shouldHave(text("Введен некорректный код подтверждения."));
    }

    @Step("Ввести прошлый код из смс")
    public void enterPreviousVerificationSmsCode(String oldcode) {
        $("#sms-code").val(oldcode);
        $("#verifyBtn").click();
        $(".text-danger").should(appear);
        entryForm.shouldHave(text("Введен некорректный код подтверждения."));
    }

    @Step("Подождать пока время действия кода истечет")
    public void waitUntilSmsCodeNotValid() {
        $("#resendDiv").shouldHave(text("Отправить повторно"), Duration.ofSeconds(310));
    }

    @Step("Возможность подтвердить входт по ТОТР ")
    public void click2faSms() {
        $(byText("Подтвердить кодом из SMS")).click();
    }

    @Step("Войти по коду из электронной почты")
    public void emailTwoFa() {
        $(byText("Подтвердить кодом из электронной почты")).click();
    }

    @Step("Заменить URL")
    public void replaceUrl() {
        String currentURL = WebDriverRunner.url();
        String expectedURL = currentURL.replace("http://oati-app.fors.ru/", "https://212.46.14.26:9929/");
        open(expectedURL);
    }

    @Step("Проверить авторизации Балансодержатель")
    public void checkBalanceAuth() {
        $(".footer").should(appear, Duration.ofSeconds(10));
    }

    @Step("Поставить флажок 'Чужой компьютер'")
    public void clickNotRemember() {
        $("[for='notRememberMe']").click();
    }

    @Step("Нажать кнопку 'Продолжить'")
    public void clickBind() {
        $("#bind").click();
    }

    @Step("Текущая страница - авторизация")
    public void checkLoginPageIsCurrent() {
        $(".page-title").shouldHave(text("Личный кабинет"));
    }
    //endregion

}