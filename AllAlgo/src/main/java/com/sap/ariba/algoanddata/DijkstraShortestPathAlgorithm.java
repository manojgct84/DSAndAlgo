package com.sap.ariba.algoanddata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DijkstraShortestPathAlgorithm
{
    private static LinkedList<String> path = new LinkedList<>();
    public static void main (String[] args)
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addAdjNodes(nodeD, 1);
        nodeA.addAdjNodes(nodeB, 6);
        nodeB.addAdjNodes(nodeC, 5);
        nodeD.addAdjNodes(nodeB, 2);
        nodeD.addAdjNodes(nodeE, 1);
        nodeE.addAdjNodes(nodeC, 5);
        nodeE.addAdjNodes(nodeB, 2);

        //This is not need
        Graph graph = new Graph();
        graph.nodes.add(nodeA);
        graph.nodes.add(nodeB);
        graph.nodes.add(nodeC);
        graph.nodes.add(nodeD);
        graph.nodes.add(nodeE);

        DSPA(nodeA);
        System.out.println(path);

    }

    private static void DSPA (Node startNode)
    {
        List<Node> visited = new ArrayList<>();
        startNode.setWeight(0);

        Queue<Node> currentNode = new LinkedList<>();
        currentNode.add(startNode);

        while (!currentNode.isEmpty()) {
            Node nextNode = getShortestPath(currentNode);
            System.out.println("nextNode " + nextNode.name);
            currentNode.remove(nextNode); // This node gets removed from the queue as we going to
            // visit.
            for (Map.Entry<Node, Integer> adjPair : nextNode.adjMap.entrySet()) {
                if (!visited.contains(adjPair.getKey())) {
                    calculatePath(adjPair,
                                  nextNode);
                    currentNode.add(adjPair.getKey());
                }
            }
            //The shortest path weight
            if(!path.contains(nextNode.name + " -> " + nextNode.getWeight())){
                path.add(nextNode.name + " -> " + nextNode.getWeight());
            }
            visited.add(nextNode);
        }

    }

    //Current Node weight + adjNode.weight.
    private static void calculatePath (Map.Entry<Node, Integer> adjPair,
                                       Node nextNode)
    {
        //System.out.println(nextNode.name + " " + nextNode.getWeight());
        int edgeWeight = adjPair.getValue() + nextNode.getWeight();
        if (edgeWeight < adjPair.getKey().getWeight()) {
            adjPair.getKey().setWeight(edgeWeight);
            adjPair.getKey().shortPathDetails.add(adjPair.getKey());
           // path.add(nextNode.name + "->" + nextNode.getWeight());
           // path.add(adjPair.getKey().name + "->" + adjPair.getValue());

        }
    }

    //Get the shortest path between two Nodes - A -B  A-D = D we pick it up.
    private static Node getShortestPath (Queue<Node> currentNode)
    {
        Node nextNodeToVisit = null;
        int minDest = Integer.MAX_VALUE;
        for (Node node : currentNode) {
            int nodeDestination = node.getWeight();
            if (nodeDestination < minDest) {
                minDest = nodeDestination;
                nextNodeToVisit = node;
            }
        }
        return nextNodeToVisit;
    }
}

class Node
{
    public String name;

    private int weight = Integer.MAX_VALUE;
    List<Node> shortPathDetails = new LinkedList<>();
    Map<Node, Integer> adjMap = new HashMap<>();

    public Node (String name)
    {
        this.name = name;
    }

    protected void addAdjNodes (Node node, int weigh)
    {
        adjMap.put(node, weigh);
    }

    public int getWeight ()
    {
        return weight;
    }

    public void setWeight (int weight)
    {
        this.weight = weight;
    }

}

class Graph
{
    Set<Node> nodes = new HashSet<>();

}
