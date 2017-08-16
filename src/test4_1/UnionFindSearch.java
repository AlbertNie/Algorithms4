package test4_1;

/**
 * 用union-find实现4.1.2.3的API
 * Created by albert on 2017/6/29.
 */
public class UnionFindSearch {
    private int[] union;
    private int s;
    private int count=0;

    public UnionFindSearch(Graph graph, int s) {
        this.s = s;
        union = new int[graph.V()];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        for (int v : graph.adj(s)) {
            union(s,v);
            count++;
        }
    }

    private void union(int v, int w){
        int vroot = root(v);
        int wroot = root(w);
        if (vroot != wroot)
            union[wroot] = vroot;
    }

    private int root(int v){
        while (union[v] != v){
            v = union[v];
        }
        return v;
    }

    public boolean marked(int v){
        return union[v] == union[s];
    }

    public int count(){
        return count;
    }
}
