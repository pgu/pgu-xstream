package pgu.xstream;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String       name;
    private int          age;
    private List<Person> children = new ArrayList<Person>();

    public Person name(final String name) {
        setName(name);
        return this;
    }

    public Person age(final int age) {
        setAge(age);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(final List<Person> children) {
        this.children = children;
    }

}
