package test4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;


/**
 * Created by albert on 2017/7/6.
 */
public class Euler {
    private Stack<Integer> cycle;

    public Euler(Digraph G){
        if (G.E() <= 1) return;
        Degrees degrees = new Degrees(G);
        for (int i = 0; i < G.V(); i++) {
            if (degrees.indegree(i) != degrees.outdegree(i))
                return;
        }
        cycle = new Stack<>();
        int i;
        for (i = 0; i < G.V(); i++) {
            if (degrees.outdegree(i) > 0)
                break;
        }
        dfs(G,i);
        if (cycle.size() != G.E() + 1){
            cycle = null;
        }
    }

    private void dfs(Digraph G, int s){
        Iterator<Integer>[] adj = new Iterator[G.V()];
        for (int i = 0; i < G.V(); i++) {
            adj[i] = G.adj(i).iterator();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()){
            int v = stack.pop();
            while (adj[v].hasNext()){
                stack.push(v);
                v = adj[v].next();
            }
            cycle.push(v);
        }
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_2/euler.txt";
        Digraph G = new Digraph(new In(filename));
        Euler euler = new Euler(G);
        if (euler.hasCycle()) {
            for (int v : euler.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("Not has Eular cycle");
        }
    }
}
