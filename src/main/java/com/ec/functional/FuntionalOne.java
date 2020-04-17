package com.ec.functional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ec.functional.FuntionalOne.Gender.*;

public class FuntionalOne {
    private static List<Person> people=List.of(
            new Person("john", MALE),
            new Person("mary",FEMALE),
            new Person("Bill",MALE),
            new Person("Anna",FEMALE)
    );

    private List<Person> getByGender(List<Person> people, Gender gender){
        return people.stream().filter(person->person.gender.equals(MALE)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        FuntionalOne one=new FuntionalOne();
        List<Person> males=one.getByGender(people,MALE);
        males.stream().forEach(System.out::println);
    }

    static class Person{
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    static enum Gender{
        MALE, FEMALE
    }
}
