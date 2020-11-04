package leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> leaves = new LinkedList<>();
        if (n == 0) {
            return leaves;
        }
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }

        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        if (leaves.size() == 0) {
            return leaves;
        }

        while (n > 2) {
            n = n - leaves.size();

            LinkedList<Integer> newLeaves = new LinkedList<>();

            for (int l : leaves) {
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
