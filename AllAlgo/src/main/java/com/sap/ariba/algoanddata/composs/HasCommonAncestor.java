package com.ariba.sap.composs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class HasCommonAncestor {
    private void findParents(int[][] relations) {
        //this set would contain Integers which have Single Parent.
        List<Integer> resultSingleParent = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        //1, 3
        for (int[] relation : relations) {
            List<Integer> l = map.getOrDefault(relation[1], new ArrayList<>());
            l.add(relation[0]);
            map.put(relation[1], l);
        }
        // this set would contains integers which have No parent
        Set<Integer> resultNoParent = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                resultSingleParent.add(entry.getKey());
            }
            for (Integer l : entry.getValue()) {
                if (!map.containsKey(l)) {
                    resultNoParent.add(l);
                }
            }
        }
        System.out.println("NO parent");
        for (Integer i : resultNoParent) {
            System.out.println(i);
        }
        System.out.println("Result single Parent");
        for (Integer i : resultSingleParent) {
            System.out.println(i);
        }

        System.out.println("These 2 have common ancestors:" + findCommonParent(6, 7, map));

    }

    /**
     * this would compare if the 2 integers have common ancestors
     *
     * @param a
     * @param b
     * @param map
     * @return true or false
     */
    private boolean findCommonParent(int a, int b, Map<Integer, List<Integer>> map) {
        Set<Integer> ancA = createAncestorList(a, map);
        Set<Integer> ancB = createAncestorList(b, map);
        for (Integer p : ancA) {
            if (ancB.contains(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this would create a list of Ancestors including itself
     *
     * @param a
     * @param map
     * @return
     */
    private Set<Integer> createAncestorList(int a, Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> ancestors = new HashSet<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int parent = queue.remove();
                ancestors.add(parent);
                if (map.containsKey(parent))
                    queue.addAll(map.get(parent));
            }
        }
        return ancestors;
    }

    public static void main(String[] args) {
        HasCommonAncestor pc = new HasCommonAncestor();
        int[][] relations = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {9, 11},
                {14, 4},
                {13, 12},
                {12, 9}
        };
        pc.findParents(relations);
    }
}
