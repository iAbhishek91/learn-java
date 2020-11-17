package javaBasics.lambda;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionEx {
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

        Function<ArrayList<Employee>, ArrayList<Employee>> filter = emps -> {
            ArrayList<Employee> filetered = new ArrayList<>();
            for(Employee emp : emps) {
                if (emp.getAge() > 30) {
                    filetered.add(emp);
                }
            }
            return filetered;
        };

        ArrayList<Employee> greaterThan30 = filter.apply(employees);

        greaterThan30.forEach(emp -> System.out.println(emp.getName()));
    }
}
