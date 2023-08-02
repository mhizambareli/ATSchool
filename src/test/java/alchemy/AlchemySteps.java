package alchemy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson14.part1.NatureElement;
import lesson14.part1.basicElements.Air;
import lesson14.part1.basicElements.Earth;
import lesson14.part1.basicElements.Fire;
import lesson14.part1.basicElements.Water;
import lesson14.part1.derivedElements.*;

import static org.junit.jupiter.api.Assertions.*;

public class AlchemySteps {
    private String elementName;
    private NatureElement createdElement;
    private NatureElement firstElement;
    private NatureElement secondElement;
    @Given("Название элемента {string}")
    public void setElementName(String name) {
        elementName = name;
    }

    @When("Создаём новый элемент по названию")
    public void createElement() {
        createdElement = NatureElement.create(elementName);
    }

    @Then("Создан новый объект класса Fire")
    public void checkFireInstance() {
        assertInstanceOf(Fire.class, createdElement);
    }

    @Then("Создан новый объект класса Water")
    public void checkWaterInstance() {
        assertInstanceOf(Water.class, createdElement);
    }

    @Then("Создан новый объект класса Air")
    public void checkAirInstance() {
        assertInstanceOf(Air.class, createdElement);
    }

    @Then("Создан новый объект класса Earth")
    public void checkEarthInstance() {
        assertInstanceOf(Earth.class, createdElement);
    }

    @Then("Проверяем, что элемент не был создан")
    public void checkAbsentElement() {
        assertNull(createdElement);
    }


    @Given("первый элемент с названием {string}")
    public void createFirstElement(String name) {
        firstElement = NatureElement.create(name);
    }

    @And("второй элемент с названием {string}")
    public void createSecondElement(String name) {
        secondElement = NatureElement.create(name);
    }

    @When("Соединяем элементы")
    public void connectElements() {
        createdElement = firstElement.connect(secondElement);
    }

    @Then("Получаем новый элемент класса Sea")
    public void checkSeaInstance() {
        assertInstanceOf(Sea.class, createdElement);
    }

    @Then("Получаем новый элемент класса Mud")
    public void checkMudInstance() {
    }

    @Then("Получаем новый элемент класса Steam")
    public void checkSteamInstance() {
        assertInstanceOf(Steam.class, createdElement);
    }

    @Then("Получаем новый элемент класса Rain")
    public void checkRainInstance() {
        assertInstanceOf(Rain.class, createdElement);
    }

    @Then("Получаем новый элемент класса Lava")
    public void checkLavaInstance() {
        assertInstanceOf(Lava.class, createdElement);
    }

    @Then("Получаем новый элемент класса Energy")
    public void checkEnergyInstance() {
        assertInstanceOf(Energy.class, createdElement);
    }

    @Then("Получаем новый элемент класса Pressure")
    public void checkPressureInstance() {
        assertInstanceOf(Pressure.class, createdElement);

    }

    @Then("Получаем новый элемент класса Dust")
    public void checkDustInstance() {
        assertInstanceOf(Dust.class, createdElement);

    }
}
