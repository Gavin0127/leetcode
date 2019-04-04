package TopologicalSort;

import java.util.LinkedList;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/15 10:36
 */
public class DirectedGraph {

    private int v;
    private LinkedList<Integer>[] adj;

    public DirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
