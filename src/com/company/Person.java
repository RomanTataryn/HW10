package com.company;

public class Person {
    String name;
    int age;
    Gender gender;
    Country country;

    public Person(String name, int age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Person: " +
                name + " " +
                ", age " + age + ", " +
                gender + " (" + country + ") //" + country.getContinent();
    }


}
