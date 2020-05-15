package com.sap.ariba.javaChecks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class BiMap<K, V>
{
    ArrayList lst = new ArrayList();


    private Map<K, V> keyToValue = new HashMap<>();
    private Map<V, K> valueToKey = new HashMap<>();
    public void put (K key,
                     V value)
    {
        lst.add("1");
        lst.add("2");
        lst.add("3");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(lst);
        //copyOnWriteArrayList.addAll(lst);

        keyToValue.put(key,value);
        valueToKey.put(value,key);
    }

    public K getKey (V value)
    {
        return valueToKey.get(value);
    }

    public V getValue (K key)
    {
        return keyToValue.get(key);
    }
}

public class TwoWayMap
{

    public static void main(String args[]){
        BiMap biMap = new BiMap();

        biMap.put(1,0);
        biMap.put(2,9);
        biMap.put(3,8);
        biMap.put(4,7);

        System.out.println(biMap.getKey(0));
        System.out.println(biMap.getValue(2));

    }

}
