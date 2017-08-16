package test4_1;

import java.util.Stack;

/**
 * Created by albert on 2017/6/29.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }


    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]){
                edgTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }
}
