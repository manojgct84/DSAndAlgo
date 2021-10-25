package com.sap.ariba.algoanddata;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BFSearch {
    private int vertex;
    private LinkedList<Integer>[] adjNode;

    BFSearch(int v) {
        this.vertex = v;
        adjNode = new LinkedList[v];
        //You need to store the next edge so you create this linked list
        for (int i = 0; i < v; i++) {
            adjNode[i] = new LinkedList<>();
        }
    }

    //add edge to the vertex.
    void addEdge(int e, int w) {
        adjNode[e].add(w);
    }

    //Search for the adj vertex and travesal the tree.
    void search(int startVertex) {
        boolean[] visited = new boolean[vertex];
        visited[startVertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int edge = queue.poll();

            for (Integer integer : adjNode[edge]) {
                //check for the give vertex is present.
                int edgeNode = integer;
                if (!visited[edgeNode]) {
                    visited[edgeNode] = true;
                    queue.add(edgeNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSearch g = new BFSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        g.search(2);

        Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        for (int i = 0; i < test; i++) {
            String number = s.nextLine();
            StringTokenizer st1 = new StringTokenizer(number, " ");
            while (st1.hasMoreTokens())
                System.out.println(Integer.parseInt(st1.nextToken()));
        }
    }
}
