package test4_4;

/**
 * Created by albert on 2017/7/13.
 */
public class DijkstraAllPairsSP {
    private DijkstraSP[] dijkstraSPS;

    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        dijkstraSPS = new DijkstraSP[G.V()];
        for (int i = 0; i < G.V(); i++) {
            dijkstraSPS[i] = new DijkstraSP(G,i);
        }
    }

    public Iterable<DirectedEdge> pathTo(int s, int v){
        return dijkstraSPS[s].pathTo(v);
    }

    public double dist(int s, int v){
        return dijkstraSPS[s].distTo(v);
    }
}
