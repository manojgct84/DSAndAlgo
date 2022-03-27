package com.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class EdgeList {
    int u;
    int v;
    int w;

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public EdgeList(final int u, final int v, final int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "EdgeList{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}

public class MST {
    static int v;
    static int[] parent;

    private static void init(final int vertex) {
        v = vertex;
        parent = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            parent[i] = -1;
        }
    }

    private static int find(final int u) {
        if (parent[u] == -1) {
            return u;
        }
        return find(parent[u]);
    }

    static ArrayList<EdgeList> mst = new ArrayList<>();
    static int weight = 0;
    static int previousW = 0;

    private static void merge(EdgeList edgeList) {
        int u = find(edgeList.u);
        int v = find(edgeList.v);

        if (v == u) {
            return;
        }
        if (previousW != edgeList.w) {
            mst.add(edgeList);
            weight += edgeList.w;
        }
        previousW = edgeList.w;
        union(u, v);
    }

    private static void union(final int u, final int v) {
        parent[u] = v;
    }

    public static void main(String[] args) {
        List<EdgeList> edgeList = new ArrayList<>();
        edgeList.add(new EdgeList(0, 1, 4));
        edgeList.add(new EdgeList(0, 2, 3));
        edgeList.add(new EdgeList(1, 2, 1));
        edgeList.add(new EdgeList(1, 3, 2));
        edgeList.add(new EdgeList(2, 3, 4));
        edgeList.add(new EdgeList(3, 4, 2));
        edgeList.add(new EdgeList(4, 5, 6));
        Comparator<EdgeList> edgeListComparator = Comparator.comparing(EdgeList::getW);
        edgeList.sort(edgeListComparator);
        init(6);

        for (EdgeList edge : edgeList) {
            merge(edge);

        }
        System.out.println(weight);
        System.out.println(mst);
    }
}

