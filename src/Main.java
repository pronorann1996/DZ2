import animals.Animal;
import animals.birds.IFlying;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.CommandValidator;
import validators.NumberValidator;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animalsList = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        CommandValidator commandValidator = new CommandValidator();
        NumberValidator numberValidator = new NumberValidator();


        while (true) {
            System.out.println("Введите команду add/list/exit");
            String commandStr = scanner.next().toUpperCase().trim();

            if (!commandValidator.isValidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели не верную комманду");
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD:
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного: cat, dog, duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                            System.out.println("Вы ввели не верный тип животного");
                    }

                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));
                    System.out.println("Введите имя животного");
                    animal.setName(scanner.next());

                    int animalAge = -1;
                    while (true) {
                        System.out.println("Введите возраст животного");
                        String animalAgeStr = scanner.next();
                        if (numberValidator.isNumber(animalAgeStr)) {
                            animalAge = Integer.parseInt(animalAgeStr);
                            if(animalAge >50 || animalAge <=0) {
                                System.out.println("Вы ввели неверный возраст животного");
                                continue;
                            }
                            break;
                        }
                        System.out.println("Вы ввели неверный возраст животного");
                    }

                    animal.setAge(animalAge);

                    int animalWeight = -1;
                    while (true) {
                        System.out.println("Введите вес животного");
                        String animalWeightStr = scanner.next();
                        if (numberValidator.isNumber(animalWeightStr)) {
                            animalWeight = Integer.parseInt(animalWeightStr);
                            if(animalWeight <=0) {
                                System.out.println("Вы ввели неверный вес животного");
                                continue;
                            }
                            break;
                        }
                        System.out.println("Вы ввели неверный вес животного");
                    }

                    animal.setWeight(animalWeight);

                    System.out.println("Введите цвет животного");
                    animal.setColor(scanner.next());

                    animalsList.add(animal);

                    animal.say();
                    if(animal instanceof IFlying) {
                        ((IFlying) animal).fly();
                    }
                    break;

                case LIST:
                    for(Animal animalObject : animalsList) {
                        System.out.println(animalObject.toString());
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}