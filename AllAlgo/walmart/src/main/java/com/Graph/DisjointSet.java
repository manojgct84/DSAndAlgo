package com.Graph;


import java.util.ArrayList;
import java.util.List;

class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class DisjointSet {

    static int v = 4;
    static int[] parent = new int[v];

    public static void parent() {
        for (int i = 0; i < v; i++) {
            parent[i] = -1;
        }
    }

    public static int find(int u) {
        if (parent[u] == -1) {
            return u;
        }
        return find(parent[u]);
    }

    public static boolean union(Edge edge) {
        int u = find(edge.u - 1);
        int v = find(edge.v - 1);

        if (v == u) {
            return false;
        }
        return set(u, v);
    }

    private static boolean set(int u, int v) {
        parent[u] = v;
        return true;
    }

    public static void main(String[] args) {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(1, 2));
        edgeList.add(new Edge(1, 3));
        edgeList.add(new Edge(3, 4));
        edgeList.add(new Edge(4, 2));
        parent();
        for (Edge edge : edgeList) {
            System.out.println(union(edge));
        }
    }
}
