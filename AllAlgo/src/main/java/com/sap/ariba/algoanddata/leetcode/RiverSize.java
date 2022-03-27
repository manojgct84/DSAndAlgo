package com.sap.ariba.algoanddata.leetcode;

import java.util.*;

public class RiverSize {
    /**
     * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
     * <p>
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * Output: 1
     * Example 2:
     * <p>
     * Input: grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * Output: 3
     */

    public int[] numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> sizeOfRiver = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    sizeOfRiver = traversNodes(i, j, grid, visited, sizeOfRiver);
                }
            }
        }
        return sizeOfRiver.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> traversNodes(int i, int j, char[][] grid, boolean[][] visited, List<Integer> sizeOfRiver) {
        int currentRiverSize = 0;
        //Queue<String> queue = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        //queue.add(i + ":" + j);
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            //String index = queue.poll();
            //String[] str = index.split(":");
            int[] pollvalue = queue.poll();
            i = pollvalue[0];
            j = pollvalue[1];
            if (!visited[i][j] && grid[i][j] == 1) {
                currentRiverSize += 1;
                queue = traversNextNodes(i, j, grid, visited);
            }
        }
        if (currentRiverSize > 0) {
            sizeOfRiver.add(currentRiverSize);
        }
        System.out.println(Arrays.toString(sizeOfRiver.toArray()));
        return sizeOfRiver;
    }

    private Queue<int[]> traversNextNodes(int i, int j, char[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        if (i > 0 && !visited[i - 1][j]) {
            //queue.add(i - 1 + ":" + j);
            queue.add(new int[]{i - 1, j});
        }
        if (i < grid.length && !visited[i + 1][j]) {
            // queue.add(i + 1 + ":" + j);
            queue.add(new int[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            // queue.add(i + ":" + (j - 1));
            queue.add(new int[]{i, j - 1});
        }
        if (j < grid[0].length && !visited[i][j + 1]) {
            //queue.add(i + ":" + (j + 1));
            queue.add(new int[]{i, j + 1});
        }
        return queue;
    }
}
