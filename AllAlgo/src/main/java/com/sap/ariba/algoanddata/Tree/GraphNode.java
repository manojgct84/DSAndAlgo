package com.sap.ariba.algoanddata.Tree;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    int V;
    LinkedList[] adjNodes;

    public GraphNode(int v) {
        V = v;
        adjNodes = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjNodes[i] = new LinkedList<>();

        }
    }

    public int getV() {
        return V;
    }

    public List<Integer>[] getAdjNodes() {
        return adjNodes;
    }

    public void addEdge(int e, int w) {
        adjNodes[e].add(w);
    }
}
