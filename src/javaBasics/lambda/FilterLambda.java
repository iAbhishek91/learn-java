package javaBasics.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterLambda {
    public static void main(String[] args) {
        Employee a = new Employee("A",26);
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


        // example of predicate
        printByObj(employees,"Employee age more than 30", emp -> emp.getAge() > 30);
        printByInt(employees,"Employee age more than 30", age -> age > 30);

        // to create a filter as js
        List<Employee> moreThan25 = filter(employees,emp-> emp.getAge() >25);
        moreThan25.forEach(emp -> System.out.println(emp.getName() + " is of age " + emp.getAge()));

        // BEST WAY TO IMPLEMENT FILTER USING LAMBDA IS USING FUNCTION
    }

    private static void printByObj(
        List<Employee> employees,
        String testDescription,
        Predicate<Employee> testCondition
    ) {
        System.out.println(testDescription);
        System.out.println("=======-------=======-------=======");

        for(Employee e : employees) {
            if(testCondition.test(e)) {
                System.out.println(e.getName() + " is of age " + e.getAge());
            }
        }
    }

    private static void printByInt(
            List<Employee> employees,
            String testDescription,
            Predicate<Integer> testCondition
    ) {
        System.out.println(testDescription);
        System.out.println("=======-------=======-------=======");

        for(Employee e : employees) {
            if(testCondition.test(e.getAge())) {
                System.out.println(e.getName() + " is of age " + e.getAge());
            }
        }
    }

    private static List<Employee> filter(List<Employee> employees, Predicate<Employee> test) {
        System.out.println("=======-------=======-------=======");
        List<Employee> filteredResult = new ArrayList<>();
        for (Employee e : employees) { if (test.test(e)) { filteredResult.add(e); } }
        return filteredResult;
    }
}
