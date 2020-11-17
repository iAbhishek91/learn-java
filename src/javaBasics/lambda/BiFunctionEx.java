package javaBasics.lambda;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class BiFunctionEx {
    public static void main(String[] args) {
        Employee a = new Employee("A",26);
        Employee b = new Employee("B",22);
        Employee c = new Employee("C",44);
        Employee d = new Employee("D",30);
        Employee e = new Employee("E",42);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);

        BiFunction<Integer, ArrayList<Employee>, ArrayList<Employee>> filter = (age, emps) -> {
            ArrayList<Employee> filetered = new ArrayList<>();
            for(Employee emp : emps) {
                if (emp.getAge() > age) {
                    filetered.add(emp);
                }
            }
            return filetered;
        };

        ArrayList<Employee> greaterThan30 = filter.apply(30,employees);
        ArrayList<Employee> greaterThan25 = filter.apply(25,employees);
        ArrayList<Employee> greaterThan20 = filter.apply(20,employees);

        greaterThan30.forEach(emp -> System.out.println(emp.getName()));
        System.out.println("--------------------");
        greaterThan25.forEach(emp -> System.out.println(emp.getName()));
        System.out.println("--------------------");
        greaterThan20.forEach(emp -> System.out.println(emp.getName()));
    }
}
