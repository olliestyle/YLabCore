package ru.baib.model.taskone;

import ru.baib.model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonGrouping {

    public static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.getId() + " - " + person.getName());
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Map<String, Long> result = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator
                        .comparing(Person::getName)
                        .thenComparing(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, LinkedHashMap::new, Collectors.counting()));

        result.forEach((name, count) -> System.out.println("Key: " + name + "\n" + "Value: " + count));
    }
}
