Feature: Вода
  Scenario: Создание воды
    Given Название элемента "Water"
    When Создаём новый элемент по названию
    Then Создан новый объект класса Water

  Scenario: Соединение воды с водой
    Given первый элемент с названием "Water"
    And второй элемент с названием "Water"
    When Соединяем элементы
    Then Получаем новый элемент класса Sea

  Scenario: Соединение воды с землёй
    Given первый элемент с названием "Water"
    And второй элемент с названием "Earth"
    When Соединяем элементы
    Then Получаем новый элемент класса Mud

  Scenario: Соединение воды с огнём
    Given первый элемент с названием "Water"
    And второй элемент с названием "Fire"
    When Соединяем элементы
    Then Получаем новый элемент класса Steam

  Scenario: Соединение воды с воздухом
    Given первый элемент с названием "Water"
    And второй элемент с названием "Air"
    When Соединяем элементы
    Then Получаем новый элемент класса Rain