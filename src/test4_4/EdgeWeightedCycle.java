package test4_4;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by albert on 2017/7/13.
 */
public class EdgeWeightedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;

    public EdgeWeightedCycle(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                dfs(G,i);
        }
    }

    private void dfs(EdgeWeightedDigraph G, int s){
        onStack[s] = true;
        marked[s] = true;
        for (DirectedEdge e : G.adj(s)) {
            int v = e.to();
            if (hasCycle()) return;
            if (!marked[v]){
                edgeTo[v] = e;
                dfs(G,v);
            }
            else if (onStack[v]){
                cycle = new Stack<>();
                DirectedEdge edge = null;
                for (edge = e; edge.from()!=v; edge = edgeTo[edge.from()]){
                    cycle.push(e);
                }
                cycle.push(e);
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle(){
        return cycle;
    }
}
