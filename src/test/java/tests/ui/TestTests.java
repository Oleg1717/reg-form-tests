package tests.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.qameta.allure.Allure.step;

class TestTests {

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
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 6")
    void test6() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 7")
    void test7() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 8")
    void test8() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }

    @Test
    @DisplayName("Test 9")
    void test9() {
        step("Проверка", () -> {
            sleep(5000);
            Assertions.assertThat(new Random().nextBoolean()).isFalse();
        });
    }
}