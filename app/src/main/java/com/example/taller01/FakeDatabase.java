package com.example.taller01;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeDatabase {

    private static ArrayList<Person> employeeList = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Camila", "Lozano", 21, "Enfermera", 2000000.0, "Libre"),
                    new Person(2,"Edwin", "Vasquez", 40, "Farmaceuta",2500000.0 , "Libre"),
                    new Person(3, "Pepe", "Mejia", 31, "Medico", 4578901.0, "Libre")
            )
    );

    public static void AddEmployee(int id, String name, String lastName, int age, String position, double salary, String email){
        employeeList.add(new Person(id, name, lastName, age, position, salary, email));
    }

    public static ArrayList<Person> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(ArrayList<Person> employeeList) {
        FakeDatabase.employeeList = employeeList;
    }
}
