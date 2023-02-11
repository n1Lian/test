package org.example.company.employer;

import java.util.Objects;

public abstract class Employer<T> implements Worker {
    private String name;
    private int age;
    private T role;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return this.name;
    }

    public T getRole() {
        return this.role;
    }

    public Employer(String name, int age, T role){
        this.name = name;
        this.age = age;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employer{name = \'" + name +
                "\', age = " + age +
                ", role = " + role + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer<?> employer = (Employer<?>) o;
        return age == employer.age && Objects.equals(name, employer.name) && Objects.equals(role, employer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, role);
    }
}
