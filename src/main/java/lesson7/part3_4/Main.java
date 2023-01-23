package lesson7.part3_4;

/**
 * 3.Создать класс животное, сделать его родителем класса Cat. Создать статический метод “testStaticMethod” который выводит «Это статическое животное».
 * Вывести в методе main этот метод тремя способами.
 *
 * 4.Создать в классе Животное статическое поле планета = Земля;
 * Вывести на экран данное поле.
 * Заменить это поле на Луна
 * У созданной кошки вывести данное поле.
 */
public class Main {
    public static void main(String[] args) {
        Animal.testStaticMethod(); //1. вызов статического метода у класса Animal
        Cat.testStaticMethod(); //2. вызов статического метода у класса Cat
        Cat myCat = new Cat();
        myCat.testStaticMethod(); //3. вызов статического метода у конкретного экземпляра класса Cat

        System.out.println(Animal.planet);
        Animal.planet = "Луна";
        System.out.println(myCat.planet);
    }
}
