package edu.cloud.stream;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1337L;

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
