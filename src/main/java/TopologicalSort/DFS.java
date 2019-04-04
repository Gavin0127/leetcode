package TopologicalSort;

import java.util.LinkedList;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/15 10:54
 */
public class DFS {

    public static void topoSortByDFS(DirectedGraph graph) {
        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i = 0; i < inverseAdj.length; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private static void dfs(int vertex, LinkedList<Integer>[] inverseAdj,
                     boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        topoSortByDFS(graph);
        System.out.println();
    }

}
