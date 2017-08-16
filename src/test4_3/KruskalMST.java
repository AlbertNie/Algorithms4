package test4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Created by albert on 2017/7/10.
 */
public class KruskalMST {
    private Queue<Edge> mst;
    private Queue<Edge> VIE; // 练习4。3。26关键边

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        VIE = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        UF uf = new UF(G.V());
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        while (!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v,w)) continue;
            uf.union(v,w);
            mst.enqueue(e);
            //练习4.3.26
            if (pq.min().weight() != e.weight())
                VIE.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double sum = 0;
        for (Edge e : mst) {
            sum += e.weight();
        }
        return sum;
    }

    public Iterable<Edge> VIE(){
        return VIE;
    }

    public boolean check(EdgeWeightedGraph G){
        for (Edge e : mst) {
            UF uf = new UF(G.V());
            for (Edge v : mst) {
                if (v != e)
                    uf.union(v.either(),v.other(v.either()));
            }
            for (Edge w : G.edges()) {
                int a = w.either();
                int b = w.other(a);
                if (!uf.connected(a,b))
                    if (w.weight() < e.weight())
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a==b);
        String c = new String(a);
        System.out.println(a==c);
    }

}
