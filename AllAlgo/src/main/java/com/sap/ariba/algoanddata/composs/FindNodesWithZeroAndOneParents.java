package com.ariba.sap.composs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.
 * <p>
 * For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
 * <p>
 * 1   2    4   15
 * \ /   / | \ /
 * 3   5  8  9
 * \ / \     \
 * 6   7    11
 * <p>
 * <p>
 * Sample input/output (pseudodata):
 * <p>
 * parentChildPairs = [
 * (1, 3), (2, 3), (3, 6), (5, 6), (15, 9),
 * (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
 * ]
 * <p>
 * <p>
 * Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.
 * <p>
 * <p>
 * Output may be in any order:
 * <p>
 * findNodesWithZeroAndOneParents(parentChildPairs) => [
 * [1, 2, 4, 15],       // Individuals with zero parents
 * [5, 7, 8, 11]        // Individuals with exactly one parent
 * ]
 * <p>
 * n: number of pairs in the input
 **/

public class FindNodesWithZeroAndOneParents {
    public static void main(String[] argv) {
        int[][] parentChildPairs = new int[][]{
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {15, 9},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {9, 11}};
        findNodesWithZeroAndOneParents(parentChildPairs);
    }

    public static void findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        Map<Integer, List<Integer>> childAncestor = new HashMap<>();
        for (int[] parentChildPair : parentChildPairs) {
            int parent = parentChildPair[0];
            int child = parentChildPair[1];
            if (!childAncestor.containsKey(child)) {
                childAncestor.put(child, new ArrayList<>());
            }
            List<Integer> parentValue = childAncestor.get(child);
            parentValue.add(parent);
            childAncestor.put(child, parentValue);
        }
        System.out.println(childAncestor.toString());

        dfs(childAncestor);
    }

    private static void dfs(Map<Integer, List<Integer>> childAncestor) {
        Set<Integer> childerOneParent = new HashSet<>();
        Set<Integer> parentWithOutParent = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> parent : childAncestor.entrySet()) {
            if (parent.getValue().size() == 1) {
                childerOneParent.add(parent.getKey());
            }
            List<Integer> part = parent.getValue();
            for (Integer p : part) {
                if (!childAncestor.containsKey(p)) {
                    parentWithOutParent.add(p);
                }
            }
        }
        System.out.println(childerOneParent.toString() + " / " + parentWithOutParent.toString());
    }

    private static void dfs(Map<Integer, List<Integer>> childAncestor, List<Integer> anc) {
       /* Stack<Integer> stack = new Stack<>();
        List<Integer> keys = new ArrayList<>(childAncestor.keySet());
        stack.push(keys.get(0));
        boolean[] vistied = new boolean[keys.size()];
        vistied[keys.get(0)] = true;
        while (!stack.isEmpty()) {
            int parent = stack.pop();
            List<Integer> children = childAncestor.get(parent);
            if (children != null) {
                for (Integer child : children) {
                    if (!vistied[child]) {
                        stack.push(child);
                    }
                }
            }
        }*/


        List<Integer> childerOneParent = new ArrayList<>();
        Set<Integer> parentWithOutParent = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> parent : childAncestor.entrySet()) {
            if (parent.getValue().size() == 1) {
                childerOneParent.add(parent.getKey());
            }
            List<Integer> part = parent.getValue();
            for (Integer p : part) {
                if (!childAncestor.containsKey(p)) {
                    parentWithOutParent.add(p);
                }
            }
        }
        System.out.println(childerOneParent.toString() + parentWithOutParent.toString());
    }
}
