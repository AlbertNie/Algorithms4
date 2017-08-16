package test4_2;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by albert on 2017/7/5.
 */
public class Degrees {
    private int[] indegrees;
    private int[] outdegrees;
    private Bag<Integer> sources;
    private Bag<Integer> sinks;

    public Degrees(Digraph G){
        indegrees = new int[G.V()];
        outdegrees = new int[G.V()];
        sources = new Bag<>();
        sinks = new Bag<>();
        for (int i = 0; i < G.V(); i++) {
            for (int v : G.adj(i)) {
                outdegrees[i]++;
                indegrees[v]++;
            }
            if (outdegrees[i] == 0)
                sinks.add(i);
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0)
                sources.add(i);
        }
    }

    public int indegree(int v){
        return indegrees[v];
    }

    public int outdegree(int v){
        return outdegrees[v];
    }

    public Iterable<Integer> sources(){
        return sources;
    }

    public Iterable<Integer> sinks(){
        return sinks;
    }

    public boolean isMap(){
        for (int i = 0; i < outdegrees.length; i++) {
            if (outdegrees[i] != 1)
                return false;
        }
        return true;
    }
}
