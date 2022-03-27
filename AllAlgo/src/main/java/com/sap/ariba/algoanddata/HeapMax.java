package com.sap.ariba.algoanddata;

public class HeapMax
{
    int currentIndex;
    int size;
    HeapNode[] heapNodes;
    int maxSize = 0;

    public HeapMax (int size)
    {
        this.currentIndex = 0;
        this.size = size;
        this.heapNodes = new HeapNode[size];
        this.maxSize = size;
    }

    private boolean insertNode (int key)
    {
        if (currentIndex == maxSize) {
            return false;
        }

        HeapNode node = new HeapNode(key);
        heapNodes[currentIndex] = node;

        moveUp(currentIndex);
        currentIndex++;

        return true;
    }

    private void moveUp (int idx)
    {
        int parentIndex = (idx - 1) / 2;
        HeapNode nodeToInsert = heapNodes[idx];


        //loop until the parent is > child nodes
        while (idx > 0 && heapNodes[parentIndex].getKey() < nodeToInsert.getKey()) {
            heapNodes[idx] = heapNodes[parentIndex];
            idx = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapNodes[idx] = nodeToInsert;
    }

    public static void main (String[] args)
    {
        HeapMax heapMax = new HeapMax(5);

        heapMax.insertNode(10);
        heapMax.insertNode(20);
        heapMax.insertNode(30);
        heapMax.insertNode(5);
        heapMax.insertNode(15);
    }
}
