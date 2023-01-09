package lesson4.animals;

import static lesson4.animals.HealthState.*;

public class Vet {
    private String name; //имя ветеринара

    public Vet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод лечит животное, переданное в параметре, если оно нездорово.
     * @param animal - любой объект классов Cat, Horse или Dog (унаследованных от Animal)
     */
    void treatAnimal(Animal animal) {
        if (animal.health == HEALTHY) {
            System.out.println("Ветеринар " + getName() + " провёл приём. " + animal.name + " и так в здравии, профилактика.\n");
        }
        else {
            animal.health = HEALTHY;
            System.out.println("Ветеринар " + getName() + " провёл приём. Вылечен " + animal.name + ", живём-живём.\n");
        }
    }
}
