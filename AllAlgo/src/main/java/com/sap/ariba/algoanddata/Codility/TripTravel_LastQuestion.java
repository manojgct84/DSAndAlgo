package com.sap.ariba.algoanddata.Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripTravel_LastQuestion
{

    private static int maxLen = 0;
    private static List<List<Integer>> res = new ArrayList<>();

    public static int longestRouteWithRestrictions(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        visited.add(startNode);
        List<Integer> path = new ArrayList<>();
        path.add(startNode);

        dfs(graph, startNode, visited, startNode % 2 == 1 ? 1 : 0, path);
        return maxLen;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited, int oddNumNodeCnt, List<Integer> path) {
        if(path.size() > maxLen) {
            maxLen = path.size();
            res.clear();
            res.add(new ArrayList<>(path));
        }
        else if(path.size() == maxLen) {
            res.add(new ArrayList<>(path));
        }
        for(int neighbor : graph.get(currentNode)) {
            if(visited.contains(neighbor) || oddNumNodeCnt == 1 && neighbor % 2 != 0) {
                continue;
            }
            path.add(neighbor);
            visited.add(neighbor);
            dfs(graph, neighbor, visited, oddNumNodeCnt + (neighbor % 2 != 0 ? 1 : 0), path);
            path.remove(path.size() - 1);
            visited.remove(neighbor);
        }
    }
    public static void main(String[] args) {
        //Init a test graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Integer[] neighbors_0 = {2,6,9};
        List<Integer> list0 = Arrays.asList(neighbors_0);
        graph.put(0, list0);

        Integer[] neighbors_1 = {9};
        List<Integer> list1 = Arrays.asList(neighbors_1);
        graph.put(1, list1);

        Integer[] neighbors_2 = {0,3};
        List<Integer> list2 = Arrays.asList(neighbors_2);
        graph.put(2, list2);

        Integer[] neighbors_3 = {2,8};
        List<Integer> list3 = Arrays.asList(neighbors_3);
        graph.put(3, list3);

        Integer[] neighbors_4 = {6};
        List<Integer> list4 = Arrays.asList(neighbors_4);
        graph.put(4, list4);

        Integer[] neighbors_5 = {8};
        List<Integer> list5 = Arrays.asList(neighbors_5);
        graph.put(5, list5);

        Integer[] neighbors_6 = {0,4};
        List<Integer> list6 = Arrays.asList(neighbors_6);
        graph.put(6, list6);

        Integer[] neighbors_7 = {8};
        List<Integer> list7 = Arrays.asList(neighbors_7);
        graph.put(7, list7);

        Integer[] neighbors_8 = {5,7};
        List<Integer> list8 = Arrays.asList(neighbors_8);
        graph.put(8, list8);

        Integer[] neighbors_9 = {0,1};
        List<Integer> list9 = Arrays.asList(neighbors_9);
        graph.put(9, list9);

        System.out.println(longestRouteWithRestrictions(graph, 0));
        for(List<Integer> route : res) {
            System.out.println(route.toString());
        }
    }
}
