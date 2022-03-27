package com.sap.ariba.algoanddata.Tree;

//Bellman Ford's Algorithm

public class SingleSourceShortestPath {


    public static void main(String[] args) {
        BellmanFordGraph bellmanFordGraph = new BellmanFordGraph(5, 8);
        bellmanFordGraph.edgeCreation(0, 0, 1, 5);
        bellmanFordGraph.edgeCreation(1, 0, 2, 4);
        bellmanFordGraph.edgeCreation(2, 1, 3, 3);
        bellmanFordGraph.edgeCreation(3, 2, 1, 6);
        bellmanFordGraph.edgeCreation(4, 3, 2, 2);

        SingleSourceShortestPath.bfGraph(bellmanFordGraph, 0);
    }

    private static void bfGraph(BellmanFordGraph bellmanFordGraph, int startEdge) {
        int[] distance = new int[bellmanFordGraph.V];

        for (int i = 0; i < bellmanFordGraph.V; ++i)
            distance[i] = Integer.MAX_VALUE;

        distance[startEdge] = 0;

        for (int i = 1; i < bellmanFordGraph.V; i++) {
            for (int j = 0; j < bellmanFordGraph.E; j++) {
                int u = bellmanFordGraph.adjList[j].s;
                int v = bellmanFordGraph.adjList[j].d;
                int w = bellmanFordGraph.adjList[j].w;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (int j = 0; j < bellmanFordGraph.E; j++) {
            int u = bellmanFordGraph.adjList[j].s;
            int v = bellmanFordGraph.adjList[j].d;
            int w = bellmanFordGraph.adjList[j].w;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("CreateGraph contains negative w cycle");
                return;
            }
        }
        printSolution(distance, bellmanFordGraph.V);
    }

    private static void printSolution(int[] distance, int v) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < v; ++i)
            System.out.println(i + "\t\t" + distance[i]);
    }

}

class BellmanFordGraph {
    int V;
    int E;
    int s, d, w = 0;
    BellmanFordGraph[] adjList;

    public BellmanFordGraph() {

    }

    public BellmanFordGraph(int v, int e) {
        V = v;
        E = e;
        this.adjList = new BellmanFordGraph[E];
        for (int i = 0; i < E; i++) {
            adjList[i] = new BellmanFordGraph();
        }
    }

    protected void edgeCreation(int e, int s, int d, int w) {
        adjList[e].s = s;
        adjList[e].d = d;
        adjList[e].w = w;
    }
}

