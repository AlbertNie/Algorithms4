package test4_1;

import edu.princeton.cs.algs4.In;

/**
 * Created by albert on 2017/6/30.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                dfs(G,i,i);
        }
    }

    private void dfs(Graph g, int s, int u) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked[v]){
                marked[v] = true;
                dfs(g,v,s);
            }else if (v != u)
                hasCycle = true;
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_1/tinyGex2.txt";
        In in = new In(filename);
        Graph graph = new Graph(in);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());
    }
}
