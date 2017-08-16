package test4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import test4_4.DirectedEdge;
import test4_4.EdgeWeightedDigraph;

/**
 * Created by albert on 2017/7/5.
 */
public class DepthFirstOrder {
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    private boolean[] marked;

    public DepthFirstOrder(Digraph G){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                dfs(G,i);
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                dfs(G,i);
        }
    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;
        pre.enqueue(s);
        for (int v : G.adj(s)) {
            if (!marked[v])
                dfs(G,v);
        }
        post.enqueue(s);
        reversePost.push(s);
    }

    private void dfs(EdgeWeightedDigraph G, int s){
        marked[s] = true;
        pre.enqueue(s);
        for (DirectedEdge e : G.adj(s)) {
            int to = e.to();
            if (!marked[to])
                dfs(G,to);
        }
        post.enqueue(s);
        reversePost.push(s);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }


    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_2/tinyGD.txt";
        In in = new In(filename);
        Digraph G = new Digraph(in);
        DepthFirstOrder test1 = new DepthFirstOrder(G.reverse());
        DepthFirstOrder test2 = new DepthFirstOrder(G);
        for (int w : test1.reversePost()) {
            System.out.print(" " + w);
        }
        System.out.println();
        for (int w : test2.post) {
            System.out.print(" " + w);
        }
        System.out.println();
    }
}
