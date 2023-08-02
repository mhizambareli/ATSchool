package homework11_3.part2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String loginPageUrl = "https://www.saucedemo.com/";
    private final SelenideElement logoElement = $("div.login_logo");
    private final SelenideElement username = $("input#user-name");
    private final SelenideElement password = $("input#password");
    private final SelenideElement loginButton = $("input#login-button");

    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    public SelenideElement getLogoElement() {
        return logoElement;
    }

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

}