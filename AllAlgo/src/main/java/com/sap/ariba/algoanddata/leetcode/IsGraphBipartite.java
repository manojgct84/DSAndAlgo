package com.sap.ariba.algoanddata.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    /**
     * Given an undirected graph, return true if and only if it is bipartite.
     * <p>
     * Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B, such that every edge in the graph has one node in A and another node in B.
     * <p>
     * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists. Each node is an integer between 0 and graph.length - 1. There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
     * Output: true
     * Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
     * <p>
     * Example 2:
     * <p>
     * <p>
     * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
     * Output: false
     * Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= graph.length <= 100
     * 0 <= graph[i].length < 100
     * 0 <= graph[i][j] <= graph.length - 1
     * graph[i][j] != i
     * All the values of graph[i] are unique.
     * The graph is guaranteed to be undirected.
     */

    public static void main(String[] ars) {
        System.out.println(isBipartite(new int[][] {{1, 3},
                                                    {0, 2},
                                                    {1, 3},
                                                    {0, 2}}));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    for (int adjacent : graph[node])
                        if (colors[adjacent] == colors[node])
                            return false;
                        else if (colors[adjacent] == 0) {
                            q.add(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        return true;
    }
}
