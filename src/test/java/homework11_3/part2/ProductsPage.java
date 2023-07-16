package homework11_3.part2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final String productsPageUrl = "https://www.saucedemo.com/inventory.html";
    private final SelenideElement productsTitle = $("span.title");
    private final SelenideElement burgerButton = $("button#react-burger-menu-btn");
    private final SelenideElement logoutButton = $("a#logout_sidebar_link");

    public String getProductsPageUrl() {
        return productsPageUrl;
    }

    public SelenideElement getProductsTitle() {
        return productsTitle;
    }

    public SelenideElement getBurgerButton() {
        return burgerButton;
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }
}
