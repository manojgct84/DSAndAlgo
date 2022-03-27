package com.sap.ariba.algoanddata.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgorithm {
    static GraphNode graphNode;

    DepthFirstSearchAlgorithm(int v) {
        graphNode = new GraphNode(v);
    }

    private static void dfs(int startNode) {
        boolean[] visited = new boolean[graphNode.getV()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.println(String.format("edge :%s", v));
            visited[v] = true;
            List<Integer>[] adjNodes = graphNode.getAdjNodes();
            for (Integer integer : adjNodes[v]) {
                if (!visited[integer]) {
                    stack.push(integer);
                }
            }
        }
        System.out.println(String.format("visited :%s", Arrays.toString(visited)));
    }

    public static void main(String[] args) {
        new DepthFirstSearchAlgorithm(4);
        graphNode.addEdge(0, 1);
        graphNode.addEdge(0, 2);
        graphNode.addEdge(1, 2);
        graphNode.addEdge(2, 0);
        graphNode.addEdge(2, 3);
        graphNode.addEdge(3, 3);


        dfs(0);
    }
}
