package test4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import test3_5.MathSET;

import java.util.HashMap;

/**
 * Created by albert on 2017/7/6.
 */
public class DigraphLCA {
    private Digraph GR;
    private int V;
    private int[] high;
    private MathSET<Integer> VFather;
    private MathSET<Integer> WFather;

    public DigraphLCA(Digraph G, int v){
        this.V = v;
        this.GR = G.reverse();
        VFather = new MathSET<>();
        WFather = new MathSET<>();
        high = new int[G.V()];
        BFS(GR,v);
        getFather(GR,v,VFather);
    }

    private void BFS(Digraph G, int s){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        high[s] = 0;
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                queue.enqueue(w);
                high[w] = high[v]+1;
            }
        }
    }

    private void getFather(Digraph G, int s, MathSET<Integer> father){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                queue.enqueue(w);
            }
            father.add(v);
        }
    }

    public int getLCA(int w){
        getFather(GR,w,WFather);
        VFather.intersection(WFather);
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int s : VFather.keys()) {
            if (high[s] < min){
                min = high[s];
                result = s;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_2/euler.txt";
        Digraph G = new Digraph(new In(filename));
        DigraphLCA digraphLCA = new DigraphLCA(G,3);
        System.out.println(digraphLCA.getLCA(4));
    }
}
