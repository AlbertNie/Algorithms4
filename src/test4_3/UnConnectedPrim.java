package test4_3;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/7/10.
 */
public class UnConnectedPrim {
    private Edge[] edgeTo;
    private boolean[] marked;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public UnConnectedPrim(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])
                prim(G,i);
        }
    }

    private void prim(EdgeWeightedGraph G, int v) {
        distTo[v] = 0.0;
        pq.insert(v,0.0);
        if (!pq.isEmpty()){
            scan(G,pq.delMin());
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]){
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Queue<Edge> msts = new Queue<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null)
                msts.enqueue(edgeTo[i]);
        }
        return msts;
    }

    public double weight(){
        double sum = 0;
        for (int i = 0; i < distTo.length; i++) {
            sum += distTo[i];
        }
        return sum;
    }
}
