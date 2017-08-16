package test4_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by albert on 2017/6/29.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgTo;
    private int[] distTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph g, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        distTo[v] = 0;
        queue.enqueue(v);
        while (!queue.isEmpty()){
            int n = queue.dequeue();
            for (int w : g.adj(n)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgTo[w] = n;
                    distTo[w] += 1;
                    queue.enqueue(w);
                }
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

    public int distTo(int v){
        return distTo[v];
    }
}
