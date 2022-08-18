package ua.en.kosse.oksana.tommy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cat {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Animal animal = new Animal();
        interactDirectly(animal, "кіт", 1, "Персик");
        printInfo(animal);
        interactWithReflection(animal, "кішка", 2, "Відьма");
        printInfo(animal);

    }

    private static void printInfo(Animal animal) {
        System.out.printf("Животное %s по кличке %s возраст %s год : %s %n",
                animal.getGender(),
                animal.getNickname(),
                animal.getAge(),
                animal.getMeow());
    }

    private static void interactDirectly(Animal animal, String gender, Integer age, String nickname ) {
        animal.setAnimal(nickname, age, gender);
    }

    private static void interactWithReflection(Animal animal, String gender, Integer age, String nickname)
            throws IllegalAccessException, InvocationTargetException {
        Class<? extends Animal> rClass = animal.getClass();
        for (Field field : rClass.getDeclaredFields()) {
            if ("gender".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(animal);
                field.set(animal, gender);
                System.out.printf("Замінили старе значення %s на нове %s %n", oldValue, gender);
            }
            if ("nickname".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(animal);
                field.set(animal, nickname);
                System.out.printf("Замінили старе значення %s на нове %s %n", oldValue, nickname);
            }

            if ("age".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(animal);
                field.set(animal, age);
                System.out.printf("Замінили старе значення %s на нове %s %n", oldValue, age);
            }
        }
        for (Method method : rClass.getDeclaredMethods()) {
            if ("getMeow".equals(method.getName())) {
                Object vox = method.invoke(animal);
                System.out.println("метод: " + vox);
            }
        }
    }
}



