package test4_2;

import edu.princeton.cs.algs4.Stack;
import test4_4.EdgeWeightedDigraph;

/**
 * Created by albert on 2017/7/5.
 */
public class DirectedCycle {
    private boolean[] marked;
    private boolean[] onstack;
    private Stack<Integer> cycle;
    private int[] edgeTo;

    public DirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        onstack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                dfs(G,i);
        }
    }

    private void dfs(Digraph G, int s) {
        onstack[s] = true;
        marked[s] = true;
        for (int v : G.adj(s)) {
            if (hasCycle()) return;
            if (!marked[v]){
                edgeTo[v] = s;
                dfs(G,v);
            }
            else if (onstack[v]){
                cycle = new Stack<>();
                for (int w = s; w != v; w = edgeTo[w]) {
                    cycle.push(w);
                }
                cycle.push(v);
                cycle.push(s);
            }
        }
        onstack[s] = false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
