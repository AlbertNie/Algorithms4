package test4_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import test4_3.EdgeWeightedGraph;

import java.util.Arrays;

/**
 * Created by albert on 2017/7/13.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        V = v;
        E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();
            adj[from].add(new DirectedEdge(from,to,weight));
        }
    }

    public void addEdge(DirectedEdge edge){
        adj[edge.from()].add(edge);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag = new Bag<>();
        for (int i = 0; i < V; i++) {
            for (DirectedEdge e : adj[i]) {
                bag.add(e);
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        String result = "EdgeWeightedDigraph:\n";
        for (DirectedEdge e : edges()) {
            result += e + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_4/tinyEWD.txt";
        In in = new In(filename);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        System.out.println(G);
    }
}
