package test4_4;

import edu.princeton.cs.algs4.In;

/**
 * Created by albert on 2017/7/14.
 */
public class DiaOfEWD {
    private double dia;

    public DiaOfEWD(EdgeWeightedDigraph G) {
        DijkstraAllPairsSP DG = new DijkstraAllPairsSP(G);
        for (int i = 0; i < G.V(); i++) {
            for (int j = 0; j < G.V(); j++) {
                if (DG.dist(i,j) > dia && DG.dist(i,j) != Double.POSITIVE_INFINITY)
                    dia = DG.dist(i,j);
            }
        }
    }

    public double getDia(){
        return dia;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_4/tinyEWD.txt";
        In in = new In(filename);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        DiaOfEWD diaOfEWD = new DiaOfEWD(G);
        System.out.println(diaOfEWD.getDia());
    }
}
