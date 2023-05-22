package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

class TestTests2 extends TestBase {

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 6")
    void test6() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 7")
    void test7() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 8")
    void test8() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }

    @Test
    @DisplayName("Test 9")
    void test9() {
        step("Проверка", () -> {
            sleep(3000);
            open("http://localhost/");
            $("body").shouldHave(text("localhost"));
        });
    }
}
