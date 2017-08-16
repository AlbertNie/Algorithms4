package test4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by albert on 2017/6/30.
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    private Graph GG;

    public CC(Graph G) {
        GG = G;
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                bfs(G,i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        id[s] = count;
        for (int v : g.adj(s)) {
            if (!marked[v]){
                marked[v] = true;
                dfs(g,v);
            }
        }
    }

    private void bfs(Graph g, int s){
        marked[s] = true;
        id[s] = count;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]){
                    marked[w] = true;
                    id[w] = count;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public int[] getGraphWithID(int Gid){
        ArrayList<Integer> point = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            if (Gid == id[i]){
                point.add(i);
            }
        }
        int[] graph = new int[point.size()];
        for (int i = 0; i < point.size(); i++) {
            graph[i] = point.get(i);
        }
        return graph;
    }

    @Override
    public String toString() {
        String result = "connected component:\n";
        for (int i = 0; i < count; i++) {
            result += "id " + i + ": ";
            for (int j = 0; j < id.length; j++) {
                if (id[j] == i)
                    result += (j + " ");
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_1/tinyGex2.txt";
        In in = new In(filename);
        Graph graph = new Graph(in);
        CC cc = new CC(graph);
        System.out.println(cc);
    }
}
