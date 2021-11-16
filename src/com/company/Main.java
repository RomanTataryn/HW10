package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) {
        System.out.println("Adult people, not retired: ");
        List<Person> Persons = Stream.of(
                        new Person("Petro", 25, Gender.MALE, Country.UKRAINE),
                        new Person("Oksana", 18, Gender.FEMALE, Country.UKRAINE),
                        new Person("Mitsue", 33, Gender.FEMALE, Country.JAPAN),
                        new Person("Viktoria", 9, Gender.FEMALE, Country.USA),
                        new Person("Jan", 47, Gender.MALE, Country.POLAND),
                        new Person("Mary", 25, Gender.FEMALE, Country.AUSTRALIA),
                        new Person("John", 33, Gender.MALE, Country.AUSTRALIA),
                        new Person("George", 58, Gender.FEMALE, Country.ZAIR),
                        new Person("Frida", 47, Gender.FEMALE, Country.BOLIVIA),
                        new Person("Janina", 49, Gender.FEMALE, Country.POLAND),
                        new Person("Pedro", 75, Gender.MALE, Country.SPAIN))
                .collect(Collectors.toList());

        List<Person> AdultPerson = Persons.stream().filter(p -> p.getAge() < 60 && p.getAge() >= 18)
                .peek(x -> System.out.format("%s\n ", x))
                .collect(Collectors.toList());
        System.out.println("__________________________");
        System.out.println("Person by continent and countries: ");
        List<String> Chain_by_country_continent = AdultPerson.stream()
                .collect(Collectors.groupingBy(person -> person.getCountry().continent))
                .entrySet()
                .stream()
                .map(element -> String.format("*%s\n%s", element.getKey(), element.getValue()
                        .stream().collect(Collectors.groupingBy(person -> person.getCountry()))
                        .entrySet().stream()
                        .map(element2 -> String.format("\t● %s\n%s", element2.getKey(), element2.getValue()
                                .stream().collect(Collectors.groupingBy(person -> person.getGender()))
                                .entrySet()
                                .stream()
                                .map(element3 -> String.format("\t\t- %s\n%s", element3.getKey(), element3.getValue()
                                        .stream()
                                        .collect(Collectors.groupingBy(Person::getName))
                                        .entrySet()
                                        .stream()
                                        .map(element4 -> String.format(" \t\t\t-%s (%s)\n", element4.getKey(), element4.getValue()
                                                .stream()
                                                .collect(Collectors.groupingBy(person -> person.getAge()))
                                                .keySet()
                                                .stream()
                                                // .peek(System.out::println)
                                                .map(element5 -> String.format("%s", element5.toString()))

                                                .collect(Collectors.joining("\n"))))
                                        .collect(Collectors.joining("\n"))))
                                .collect(Collectors.joining("\n"))))
                        .collect(Collectors.joining("\n"))))
                .collect(Collectors.toList());

        Chain_by_country_continent.forEach((s) -> System.out.format("%s", s));


    }
}



