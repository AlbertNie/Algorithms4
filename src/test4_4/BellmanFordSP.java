package test4_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by albert on 2017/7/13.
 */
public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()){
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G,v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]){
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0){
                findNegativeCycle();
            }
        }
    }

    private void findNegativeCycle() {
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(edgeTo.length);
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null){
                edgeWeightedDigraph.addEdge(edgeTo[i]);
            }
        }
        EdgeWeightedCycle edgeWeightedCycle = new EdgeWeightedCycle(edgeWeightedDigraph);
        cycle = edgeWeightedCycle.cycle();
    }

    private boolean hasNegativeCycle() {
        return cycle!=null;
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e!=null; e = edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    public Iterable<DirectedEdge> negativeCycle(){
        return cycle;
    }
}
