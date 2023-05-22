package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import helpers.DriverSettings;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase extends TestData {

    public pages.authorization.LoginPage loginPage = new pages.authorization.LoginPage();

    @BeforeAll
    public static void beforeAll() {
        DriverSettings.configureSelenide();
    }
}


