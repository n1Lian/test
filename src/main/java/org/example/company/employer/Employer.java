package org.example.company.employer;

import javax.persistence.*;
import java.util.Objects;
@MappedSuperclass
public abstract class Employer<T> implements Worker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private T role;

    public Employer() {
    }

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
