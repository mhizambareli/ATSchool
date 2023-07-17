package homework11_3.part4;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FourthTest {

    /**
     * Задание 11.3.4
     * По аналогии с предыдущими заданиями, напишите тест для страницы
     * the-internet.herokuapp.com/dynamic_loading/1,
     * в котором:
     * - отрывается страница
     * - проверяется, что отсутсвует элемент с текстом "Hello World"
     * - нажимается кнопка
     * - через некоторое время  появляется элемент с текстом
     */
    @Test
    void hiddenGreetings(){
        open("the-internet.herokuapp.com/dynamic_loading/1");
        getWebDriver().manage().window().maximize();
        //assertFalse($("div#finish").isDisplayed()); todo перепиши почекай

    }

}
