package com.sap.ariba.algoanddata.Saleforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class PersonRelation {
    public static boolean checkAreTheyRelated(String child1, String child2) {
        if ((child1 == null && child2 != null) || (child1 != null && child2 == null)) {
            return false;
        }
        List<Person> parent1 = Person.getParent(child1);
        List<Person> parent2 = Person.getParent(child2);

        Set<String> child1Parent = bfsGraph(parent1);
        Set<String> child2Parent = bfsGraph(parent2);

        if (!child1Parent.isEmpty() && !child2Parent.isEmpty()) {
            return child1Parent.equals(child2Parent);
        }
        return false;
    }

    private static Set<String> bfsGraph(List<Person> personList) {
        Set<String> child1Parent = new HashSet<>();
        Map<Person, Boolean> visited;
        Queue<Person> bfsQ;
        if (!personList.isEmpty()) {
            bfsQ = new LinkedList<>();
            bfsQ.add(personList.get(0));
            visited = new HashMap<>();
            visited.put(personList.get(0), true);
            while (!bfsQ.isEmpty()) {
                Person p = bfsQ.poll();
                if (p != null) {
                    child1Parent.add(p.parentID);
                    List<Person> grandParent = Person.getParent(p.parentID);
                    if (grandParent != null) {
                        for (Person gp : grandParent) {
                            if (!visited.containsKey(gp)) {
                                bfsQ.add(gp);
                            }
                        }
                    }
                }
            }
        }
        return child1Parent;
    }

    public static void main(String[] args) {
        System.out.println(checkAreTheyRelated("p3", "p2"));
    }
}


class Person {
    String id;
    String parentID;
    String relation;

    static Map<String, List<Person>> db = new LinkedHashMap<>();


    public Person(String id, String parentID, String relation) {
        this.id = id;
        this.parentID = parentID;
        this.relation = relation;
    }

    static {
        List<Person> l1 = new ArrayList<>();
        l1.add(new Person("1", "a", "parent"));
        db.put("p1", l1);

        List<Person> l2 = new ArrayList<>();
        l2.add(new Person("2", "c", "parent"));
        db.put("p2", l2);

        List<Person> l3 = new ArrayList<>();
        l3.add(new Person("3", "a1", "grandParent"));
        db.put("a", l3);

        List<Person> l4 = new ArrayList<>();
        l4.add(new Person("4", "a1", "grandParent"));
        db.put("c", l4);
    }

    static List<Person> getParent(String key) {
        if (key != null)
            return db.get(key);
        return null;
    }
}

