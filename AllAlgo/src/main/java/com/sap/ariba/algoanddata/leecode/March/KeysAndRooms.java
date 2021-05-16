package com.ariba.sap.test.leecode.March;

import java.util.List;
import java.util.Stack;

/**
 * There are N rooms and you start in room 0.
 * Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 * where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 */


public class KeysAndRooms {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seenRooms = new boolean[rooms.size()];
        stack.push(0);
        seenRooms[0] = true;

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (int keys : rooms.get(node)) {
                if (!seenRooms[keys]) {
                    seenRooms[keys] = true;
                    stack.push(keys);
                }
            }
        }

        for (boolean v : seenRooms) {
            if (!v)
                return false;
        }
        return true;
    }
}
