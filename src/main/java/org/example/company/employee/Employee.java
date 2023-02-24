package org.example.company.employee;

import org.example.company.ITCompany;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee<T> implements Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private T role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private ITCompany company;

    public Employee() {
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(T role) {
        this.role = role;
    }

    public void setCompany(ITCompany company) {
        this.company = company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public T getRole() {
        return this.role;
    }

    public ITCompany getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public Employee(String name, int age, T role){
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
        Employee<?> employee = (Employee<?>) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, role);
    }
}
