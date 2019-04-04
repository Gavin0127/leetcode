package TopologicalSort;

import graph.Graph;

import java.util.LinkedList;

/**
 * 基于贪心算法
 * @author : Ge Xiantao
 * @date : 2019/3/15 10:53
 */
public class Kahn {

    public static void topoSortByKahn(DirectedGraph graph) {
        int v = graph.getV();
        int[] inDegree = new int[v];
        LinkedList<Integer>[] adj = graph.getAdj();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.println("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        topoSortByKahn(graph);
    }


}
