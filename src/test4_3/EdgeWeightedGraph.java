package test4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by albert on 2017/7/10.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            Edge edge = new Edge(in.readInt(),in.readInt(),in.readDouble());
            addEdge(edge);
        }
    }

    public void addEdge(Edge edge){
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> bag = new Bag<>();
        for (int i = 0; i < V; i++) {
            for (Edge edge : adj(i)) {
                if (edge.other(i) > i)
                    bag.add(edge);
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        String result = "EWG with " + V + "point and "+ E + "Edge:\n";
        for (Edge e : edges()) {
            result = result + e.toString() + "\n";
        }
        return result;
    }
}
