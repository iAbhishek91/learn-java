package javaBasics.lambda;

import java.util.ArrayList;

public class ForEachLambda {
    public static void main(String[] args) {
        // forEach was introduced in java 8
        Employee a = new Employee("A",20);
        Employee b = new Employee("B",22);
        Employee c = new Employee("C",44);
        Employee d = new Employee("D",34);
        Employee e = new Employee("E",42);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);

        // very very similar to Javascript functional programming syntax and concept
        // forEach do not return anything
        employees.forEach(emp -> System.out.println(emp.getName() + " is of age " + emp.getAge()));
    }
}

