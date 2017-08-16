package test4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;


/**
 * 证明一副图中存在一个顶点，删除它及它的边不影响图的连通性
 * Created by albert on 2017/6/29.
 */
public class DFSFindSympleP {
    private boolean[] marked;
    private int[] edgTo;
    private final int s;
    private SET<Integer> bag;
    private int[] count;

    public DFSFindSympleP(Graph G, int s) {
        marked = new boolean[G.V()];
        edgTo = new int[G.V()];
        count = new int[G.V()];
        this.s = s;
        bag = new SET<>();
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]){
                edgTo[w] = v;
                dfs(G,w);
            } else
                count[v] += 1;
            if (count[v] == ((Bag<Integer>)G.adj(v)).size() || ((Bag<Integer>)G.adj(v)).size() == 1)
                bag.add(v);
        }
    }

    public Iterable<Integer> getSymPoint(){
        return bag;
    }

    public boolean hasSymPoint(){
        return bag.size() != 0;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Desktop/testSym.txt";
        In in = new In(filename);
        Graph graph = new Graph(in);
        DFSFindSympleP dfsFindSympleP = new DFSFindSympleP(graph,0);
        System.out.println(dfsFindSympleP.hasSymPoint());
        for (int w : dfsFindSympleP.getSymPoint()) {
            System.out.println(w);
        }
        in.close();
    }
}

















