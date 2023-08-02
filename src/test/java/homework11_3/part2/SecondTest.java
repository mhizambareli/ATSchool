package homework11_3.part2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Задание 11.3.2
 * Проверка логина и выхода.
 * В ранее созданном классе LoginPage добавьте следующие параметры:
 * -  веб-элемент поля username
 * -  веб-элемент поля password
 * -  веб-элемент кнопки Login
 * Также добавьте класс для страницы с продуктами, ProductsPage,
 * которая открывается после успешного логина.
 * У класса есть следующие параметры:
 * -  веб-элемент плашки с текстом "Products"
 * -  веб-элемент "бургер" (три горизонтальные черты) в левом верхнем углу страницы, который используется для открытия бокового меню
 * -  веб-элемент кнопки "Logout" в боковом меню
 * <p>
 * Напишите тест, в котором:
 * -  открывается страница LoginPage
 * -  вводится логин/пароль (standard_user) и нажимается кнопка Login
 * -  проверяется, что перешли на страницу ProductPage
 * (перешли на страницу с нужным адресом
 * и есть плашка с текстом Products)
 * -  проверяется, что отображается "бургер"
 * -  нажимаете на "бургер"
 * -  проверяется, что отображается кнопка "Logout"
 * -  нажимаете на кнопку "Logout"
 * -  проверяется, что перешли на страницу LoginPage
 * (перешли на страницу с нужным адресом
 * и есть лого с текстом "Swag Labs")
 */

public class SecondTest {
    private static LoginPage loginPage;
    private static ProductsPage productsPage;

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
    }

    @Test
    public void testLoginAndLogout() {
        open(loginPage.getLoginPageUrl());
        getWebDriver().manage().window().maximize();
        loginPage.getUsername().sendKeys("standard_user");
        loginPage.getPassword().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        assertEquals(url(), productsPage.getProductsPageUrl());
        productsPage.getProductsTitle().shouldHave(exactTextCaseSensitive("Products"));
        productsPage.getBurgerButton().click();
        productsPage.getLogoutButton().shouldHave(exactTextCaseSensitive("Logout"));
        productsPage.getLogoutButton().click();
        assertEquals(url(), loginPage.getLoginPageUrl());
        loginPage.getLogoElement().shouldHave(exactTextCaseSensitive("Swag Labs"));
    }
}