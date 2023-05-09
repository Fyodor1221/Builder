package org.example;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String lastname;
    protected int age;
    protected boolean hasAge;
    protected String address;
    protected boolean hasAddress;

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setLastname(this.lastname).setAddress(this.address);
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasAge() {
        return hasAge;
    }

    public String getAddress() {
        return address;
    }

    public boolean isHasAddress() {
        return hasAddress;
    }

    public void happyBirthday() {
        if (this.hasAge) {
            this.age++;
        }
    }

    public void setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && lastname.equals(person.lastname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, age, address);
    }
}
