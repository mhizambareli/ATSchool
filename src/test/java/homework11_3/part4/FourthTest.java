package homework11_3.part4;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FourthTest {

    /**
     * Задание 11.3.4
     * По аналогии с предыдущими заданиями, напишите тест для страницы
     * the-internet.herokuapp.com/dynamic_loading/1,
     * в котором:
     * - отрывается страница
     * - проверяется, что отсутствует элемент с текстом "Hello World"
     * - нажимается кнопка
     * - через некоторое время  появляется элемент с текстом
     */

    @Test
    void hiddenGreetings() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
        getWebDriver().manage().window().maximize();
        SelenideElement helloWorldBlock = $("div#finish");
        SelenideElement startButton = $("div#start button");
        SelenideElement helloWorldText = $("div#finish h4");
        helloWorldBlock.shouldHave(attribute("style", "display: none;"));
        helloWorldText.shouldHave(exactTextCaseSensitive(""));
        startButton.click();
        sleep(10000);
        helloWorldBlock.shouldHave(attribute("style", ""));
        helloWorldText.shouldHave(exactTextCaseSensitive("Hello World!"));
    }
}
