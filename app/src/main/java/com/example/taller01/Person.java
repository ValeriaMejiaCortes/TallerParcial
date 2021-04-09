package com.example.taller01;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private double salary;
    private String position;


    public Person() {
    }


    public Person(int id, String name, String lastName, int age, String position, double salary, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.email = email;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return lastName;
    }

    public void setApellido(String lastName) {
        this.lastName = lastName;
    }

    public int getEdad() {
        return age;
    }

    public void setEdad(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalario() {
        return salary;
    }

    public void setSalario(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
