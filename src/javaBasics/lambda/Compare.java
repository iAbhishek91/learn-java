package javaBasics.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        Employee a = new Employee("A", 21);
        Employee b = new Employee("B", 29);
        Employee c = new Employee("C", 24);
        Employee d = new Employee("D", 26);
        Employee e = new Employee("E", 31);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);

        printList(employees);

//       Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getAge() == o2.getAge()
//                        ? 0
//                        : o1.getAge() > o2.getAge() ? -1 : 1;
//            }
//        });

//        Collections.sort(
//            employees,
//            (Employee o1, Employee o2)-> o1.getAge() == o2.getAge() ? 0 : o1.getAge() > o2.getAge() ? -1 : 1
//        );

        Collections.sort(
            employees,
            (e1, e2)-> Integer.compare(e2.getAge(), e1.getAge())
        );

        printList(employees);
    }

    public static void printList(List<Employee> employees) {
        for(Employee employee :  employees) {
            System.out.println(employee.getName() + " is " + employee.getAge() + " year old.");
        }
        System.out.println("==--==--==--==--==--==");
    }
}

