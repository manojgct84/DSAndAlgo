package com.sap.ariba.algoanddata;

public class HeapNode
{
    int key;

    public HeapNode (int key)
    {
        this.key = key;
    }

    public int getKey ()
    {
        return key;
    }

    @Override
    public String toString ()
    {
        return "HeapNode{" + "key=" + key + '}';
    }


}
