package test4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.io.*;

/**
 * Created by albert on 2017/6/29.
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

//    public Graph(In in){
//        this(in.readInt());
//        int E = in.readInt();
//        for (int i = 0; i < E; i++) {
//            int v = in.readInt();
//            int w = in.readInt();
//            addEdj(v,w);
//        }
//    }

    //练习4。1。15修改输入流构造函数，读入邻接表
    public Graph(In in){
        this(in.readInt());
        this.E = in.readInt();
        String next;
        String[] point;
        while (in.hasNextLine()){
            next = in.readLine();
            point = next.split("\\s");
            for (int i = 1; i < point.length; i++) {
                addEdj(Integer.parseInt(point[0]),Integer.parseInt(point[i]));
            }
        }
    }

    /**
     * 练习4.1.3添加一个复制构造函数创建副本
     * @param graph
     */
    public Graph(Graph graph){
        this(graph.V());
        for (int i = 0; i < V; i++) {
            for (int w : graph.adj(i)) {
                addEdj(i,w);
            }
        }
    }

    /**
     * 练习4。1。5不允许存在平行边和自环
     * @param v
     * @param w
     */

    public void addEdj(int v, int w) {
        if (hasEdge(v,w)) return;
        if (v == w) return;
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public void addEdjWithOutSc(int v, int w){
        if (v > w){
            int n = v;
            v = w;
            w = n;
        }
        if (v+1 == w || (w+1)%V == v) return;
        addEdj(v,w);
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 练习4.1.4添加一个hasEdge方法，判断是否含有边v-m
     */

    public boolean hasEdge(int v, int w){
        for (int n : adj[v]) {
            if (n == w) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String gra = "Graph-> \n";
        for (int i = 0; i < V; i++) {
            gra += i + ":";
            for (int w : adj[i]) {
                gra += " " + w;
            }
            gra += "\n";
        }
        return gra;
    }

    public static void main(String[] args){
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_1/tinyGadj.txt";
        //BufferedReader in = new BufferedReader(new FileReader(filename));
        In in = new In(filename);
        Graph graph = new Graph(in);
        System.out.println(graph);
        in.close();
//        UnionFindSearch unionFindSearch = new UnionFindSearch(graph,0);
//        System.out.println(unionFindSearch.marked(222));//true
//        System.out.println(unionFindSearch.count());//21
    }
}



















