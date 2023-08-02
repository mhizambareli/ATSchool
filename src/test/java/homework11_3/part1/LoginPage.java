package homework11_3.part1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String pageUrl = "https://www.saucedemo.com";
    private final SelenideElement logoElement = $("div.login_logo");

    public String getPageUrl() {
        return pageUrl;
    }

    public SelenideElement getLogoElement() {
        return logoElement;
    }
}