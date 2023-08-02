package homework11_3.part1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Задание 11.3.1
 * Проверка открытия страницы www.saucedemo.com.
 * Добавьте класс LoginPage, представляющий проверяемую страницу.
 * У класса есть следующие параметры:
 * -  адрес страницы
 * -  веб-элемент лого страницы с текстом "Swag Labs"
 * <p>
 * Напишите тест, в котором:
 * -  открывается страница
 * -  проверяется, что перешли на страницу LoginPage
 * (отображается элемент с заголовком и содержит верный текст "Swag Labs")
 */

public class FirstTest {
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    @Tag("abc")
    public void testLoginPage() {
        open(loginPage.getPageUrl());
        getWebDriver().manage().window().maximize();
        loginPage.getLogoElement().shouldHave(exactTextCaseSensitive("Swag Labs"));
    }
}