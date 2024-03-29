Feature: Воздух
  Scenario: Создание воздуха
    Given Название элемента "Air"
    When Создаём новый элемент по названию
    Then Создан новый объект класса Air

  Scenario: Соединение воздуха с водой
    Given первый элемент с названием "Air"
    And второй элемент с названием "Water"
    When Соединяем элементы
    Then Получаем новый элемент класса Rain

  Scenario: Соединение воздуха с землёй
    Given первый элемент с названием "Air"
    And второй элемент с названием "Earth"
    When Соединяем элементы
    Then Получаем новый элемент класса Dust

  Scenario: Соединение воздуха с огнём
    Given первый элемент с названием "Air"
    And второй элемент с названием "Fire"
    When Соединяем элементы
    Then Получаем новый элемент класса Energy

  Scenario: Соединение воздуха с воздухом
    Given первый элемент с названием "Air"
    And второй элемент с названием "Air"
    When Соединяем элементы
    Then Получаем новый элемент класса Pressure