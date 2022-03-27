package com.sap.ariba.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

public class HashSetExample
{
    public static void main(String[] args) throws IOException {
        Set<Customer> set = new HashSet<>();
        set.add(new Customer(1,"Raj"));
        set.add(new Customer(1,"Raj"));
        set.add(new Customer(1,"Raj"));
        set.add(new Customer(1,"Raj"));
        set.add(new Customer(2,"Raj"));
        System.out.println("Size :"+set.size());

        String s1 = new String("");
        String s2 = new String("");
        String s3 ="";
        String s4 ="";
        String s5 ="Manojkumar";
        String s6 ="Manojkumar";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("String s3 and s4");
        System.out.println(s3 == s4);
        System.out.println("String s5 and s6");
        System.out.println(s5 == s6);
        System.out.println("Manojkumar  : " + s5.equals(s6));
        System.out.println(s3.equals(s4));
        /*Map<Integer, String> studentsMap = students.stream().collect(Collectors.toMap(Customer :: getId, Customer :: getName
                        , (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/

    }
}
