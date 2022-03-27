package com.sap.ariba.algoanddata.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BestFirstSearchAlgo {
    // come after the book study
    // https://stackabuse.com/graphs-in-java-a-star-algorithm

    public static void main(String[] args) {
        GraphANode head = new GraphANode(3);
        head.g = 0;

        GraphANode n1 = new GraphANode(2);
        GraphANode n2 = new GraphANode(2);
        GraphANode n3 = new GraphANode(2);

        head.addBranch(1, n1);
        head.addBranch(5, n2);
        head.addBranch(2, n3);
        n3.addBranch(1, n2);

        GraphANode n4 = new GraphANode(1);
        GraphANode n5 = new GraphANode(1);
        GraphANode target = new GraphANode(0);

        n1.addBranch(7, n4);
        n2.addBranch(4, n5);
        n3.addBranch(6, n4);

        n4.addBranch(3, target);
        n5.addBranch(1, n4);
        n5.addBranch(3, target);

        GraphANode res = bestSearchANode(head, target);
        printPath(res);
    }

    private static void printPath(GraphANode res) {

        GraphANode n = res;
        if (n == null) {
            System.out.println("The value is null");
            System.exit(0);
        }

        List<Integer> ids = new ArrayList<>();

        while (n.parent != null) {
            ids.add(n.id);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println("");
    }

    public static GraphANode bestSearchANode(GraphANode start, GraphANode target) {

        PriorityQueue<GraphANode> open = new PriorityQueue<>();
        PriorityQueue<GraphANode> close = new PriorityQueue<>();

        start.f = start.g + start.calculateHeuristic(target);
        open.add(start);

        while (!open.isEmpty()) {
            GraphANode node = open.peek();
            if (node == target) {
                return node;
            }

            for (GraphANode.Edge edge : node.neighbors) {
                GraphANode n = edge.graphANode;
                double totalWeight = node.g + edge.weight;
                if (!open.contains(node) && !close.contains(node)) {
                    n.parent = node;
                    n.g = totalWeight;
                    n.f = n.g + n.calculateHeuristic(target);
                    open.add(n);

                } else {
                    n.parent = node;
                    n.g = totalWeight;
                    n.f = n.g + n.calculateHeuristic(target);
                    if (close.contains(n)) {
                        close.remove(n);
                        open.add(n);
                    }
                }
            }
            open.remove(node);
            close.add(node);
        }
        return close.poll();
    }
}

class GraphANode implements Comparable<GraphANode> {

    public GraphANode parent = null;
    private static int idCounter = 0;
    public int id;
    List<Edge> neighbors;

    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;

    public double h;

    GraphANode(double h) {
        this.h = h;
        this.id = idCounter++;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public int compareTo(GraphANode o) {
        return Double.compare(this.f, o.f);
    }

    public static class Edge {
        Edge(int weight, GraphANode node) {
            this.weight = weight;
            this.graphANode = node;
        }

        public int weight;
        public GraphANode graphANode;
    }

    public void addBranch(int weight, GraphANode node) {
        Edge newEdge = new Edge(weight, node);
        neighbors.add(newEdge);
    }

    public double calculateHeuristic(GraphANode target) {
        return this.h;
    }
}