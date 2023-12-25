package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.mammals.Cat;
import animals.mammals.Dog;
import data.AnimalData;

public class AnimalFactory {
    public Animal create(AnimalData animalData) {
        switch (animalData) {
            case CAT:
              return new Cat();
            case DOG:
              return new Dog();
            case DUCK:
                return new Duck();
        }
        return null;
    }
}
