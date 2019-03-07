package graph;

import java.util.LinkedList;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/4 15:33
 */
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;

    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

}
