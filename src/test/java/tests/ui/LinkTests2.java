package tests.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;


@Epic("Внешний SUDIR")
@Feature("Внешние и внутренние ссылки")
@Tag("link")
class LinkTests2 extends TestBase {

    @Test
    @AllureId("380")
    @Story("Проверка ссылок - страница логина")
    @Description("Проверка работоспособности ссылки 'Для физических лиц' на странице авторизации")
    @DisplayName("Проверка ссылки 'Для физических лиц'")
    void checkLoginPageIndividualPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("382")
    @Story("Проверка ссылок - страница логина")
    @Description("Проверка работоспособности ссылки \"Для юридических лиц и ИП\" на странице авторизации.")
    @DisplayName("Проверка ссылки \"Для юридических лиц и ИП\" на странице логина")
    void checkLoginPageEntityPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("383")
    @Story("Проверка ссылок - страница логина")
    @Description("Проверка работоспособности ссылки \"Для доверенных лиц и организаций\" на странице авторизации.")
    @DisplayName("Проверка ссылки \"Для доверенных лиц и организаций\" на странице логина")
    void checkLoginPageTrustedPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("1783")
    @Story("Проверка ссылок - страница регистрации")
    @Description("Проверка работоспособности ссылки \"Для физических лиц\" на странице регистрации")
    @DisplayName("Cсылка \"Для физических\" на странице регистрации")
    void checkRegistrationPageIndividualPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("1784")
    @Story("Проверка ссылок - страница регистрации")
    @Description("Проверка работоспособности ссылки \"Для доверенных лиц и организаций\" на странице регистрации")
    @DisplayName("Cсылка \"Для доверенных лиц и организаций\" на странице регистрации")
    void checkRegistrationPageTrustedPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("1786")
    @Story("Проверка ссылок - страница регистрации")
    @Description("Проверка работоспособности ссылки \"Для юридических лиц и ИП\" на странице регистрации")
    @DisplayName("Cсылка \"Для юридических лиц и ИП\" на странице регистрации")
    void checkRegistrationPageEntityPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("389")
    @Story("Проверка ссылок - восстановление пароля")
    @Description("Проверка работоспособности ссылки 'Для физических лиц' на странице ввода атрибута УЗ.")
    @DisplayName("Проверка ссылки 'Для физических лиц' на странице ввода атрибута УЗ")
    void checkRecoveryPageOpenStageIndividualPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("398")
    @Story("Проверка ссылок - восстановление пароля")
    @Description("Проверка работоспособности ссылки 'Для физических лиц' на странице ввода проверочного кода")
    @DisplayName("Проверка ссылки 'Для физических' на странице ввода проверочного кода")
    void checkRecoveryPageCodeStageIndividualPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("390")
    @Story("Проверка ссылок - восстановление пароля")
    @Description("Проверка работоспособности ссылки \"Для юридических лиц и ИП\" на странице ввода атрибута УЗ")
    @DisplayName("Проверка ссылки \"Для юридических лиц и ИП\" на странице ввода атрибута УЗ")
    void checkRecoveryPageOpenStageEntityPersonLink() {
        loginPage.openLoginPage();
    }

    @Test
    @AllureId("391")
    @Story("Проверка ссылок - восстановление пароля")
    @Description("Проверка работоспособности ссылки \"Для доверенных лиц организаций\" на странице ввода атрибута УЗ")
    @DisplayName("Проверка ссылки \"Для доверенных лиц организаций\" на странице ввода атрибута УЗ")
    void checkRecoveryPageOpenStageTrustedPersonLink() {
        loginPage.openLoginPage();
    }
}
