package javaBasics.interfaceEx;

import java.util.ArrayList;
import java.util.List;

public interface IGeneric {
    // too generic, can choose any list of any obj type
    // THIS IS NOT RECOMMENDED
    // Using type is important.
    List add();
    // in between, can choose any list of String type only
    List<String> add1();
    // too strict, specific Arraylist of type string
    ArrayList<String> add2();
}
