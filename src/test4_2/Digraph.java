package test4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by albert on 2017/7/5.
 */
public class Digraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int v){
        this.V = v;
        E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Digraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    //练习4。3。2接受一个有向图，并创建副本
    public Digraph(Digraph G){
        V = G.V();
        E = G.E();
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
            for (int w : G.adj(i)) {
                addEdge(i,w);
            }
        }

    }

    /**
     * 练习4。2。4添加一个方法hasEdge接受两个参数v w 如果有边v->w则返回true
     * @return
     */
    public boolean hasEdge(int v, int w){
        for (int s : adj[v]) {
            if (s == w) return true;
        }
        return false;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    /**
     * 练习4。2。5 不允许存在平行边和自环
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        if (v == w) return;
        if (!hasEdge(v,w)) {
            adj[v].add(w);
            E++;
        }
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph r = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (int w : adj(i)) {
                r.addEdge(w,i);
            }
        }
        return r;
    }

    @Override
    public String toString() {
        String result = "Digraph:\n";
        for (int i = 0; i < V; i++) {
            result += i + ":";
            for (int w: adj(i)) {
                result += " " + w;
            }
            result += "\n";
        }
        return result;
    }

    /**
     * 练习4。2。6编写测试用咧
     */

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_2/tinyGD.txt";
        Digraph digraph = new Digraph(new In(filename));
        System.out.println(digraph);
    }
}
















