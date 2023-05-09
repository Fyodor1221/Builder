package org.example;

public class PersonBuilder {
    protected String name;
    protected String lastname;
    protected int age;
    protected boolean hasAge;
    protected String address;
    protected boolean hasAddress;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0 || age > 199) {
            throw new IllegalArgumentException("Age must be > 0 and < 200");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name == null || this.lastname == null) {
            throw new IllegalStateException("Field name and lastname must be filled");
        }
        Person person;
        if (this.hasAge) {
            person = new Person(this.name, this.lastname, this.age);
        } else {
            person = new Person(this.name, this.lastname);
        }
        if (this.hasAddress) {
            person.setAddress(this.address);
        }
        return person;
    }
}
