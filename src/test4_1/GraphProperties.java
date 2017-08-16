package test4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by albert on 2017/6/30.
 */
public class GraphProperties {
    private boolean[] marked;
    private int[] edjTo;
    private int[] Vecce;
//    private int[] sircle;
    private int D = Integer.MIN_VALUE;
    private int R = Integer.MAX_VALUE;
//    private int sircles = Integer.MAX_VALUE;
    private int centre;

    public GraphProperties(Graph G){
        marked = new boolean[G.V()];
        edjTo = new int[G.V()];
        Vecce = new int[G.V()];
//        sircle = new int[G.V()];
//        for (int i = 0; i < G.V(); i++) {
//            sircle[i] = Integer.MAX_VALUE;
//        }
        initEdjTo();
        for (int i = 0; i < G.V(); i++) {
            bfs(G,i);
//            for (int j = 0; j < marked.length; j++) {
//                if (marked[j] == false)
//                    throw new IllegalArgumentException("It's not a connected map");
//            }
            initMarke();
//            initEdjTo();
        }
        for (int i = 0; i < G.V(); i++) {
            if (Vecce[i]>D)
                D = Vecce[i];
            if (Vecce[i]!=0 && Vecce[i]<R) {
                R = Vecce[i];
                centre = i;
            }
//            if (sircle[i] < sircles)
//                sircles = sircle[i];
        }
    }

    public GraphProperties(Graph G, int[] IDgraph){
        marked = new boolean[G.V()];
        edjTo = new int[G.V()];
        Vecce = new int[G.V()];
        initEdjTo();
        for (int i = 0; i < IDgraph.length; i++) {
            bfs(G,IDgraph[i]);
            initMarke();
        }
        for (int i = 0; i < IDgraph.length; i++) {
            if (Vecce[IDgraph[i]]>D)
                D = Vecce[IDgraph[i]];
            if (Vecce[IDgraph[i]]<R) {
                R = Vecce[IDgraph[i]];
                centre = IDgraph[i];
            }
        }
    }

    private void initMarke(){
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
    }
    private void initEdjTo(){
        for (int i = 0; i < edjTo.length; i++) {
            edjTo[i] = i;
        }
    }

    private void bfs(Graph G, int s){
        marked[s] = true;
        int Vlong = 0;
        int sum;
        boolean flage = false;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]){
                    marked[w] = true;
                    edjTo[w] = v;
                    Vlong = w;
                    queue.enqueue(w);
                    flage = true;
//                }else if (edjTo[v]!=w){
//                    int u = getsameP(v,w,s);
//                    sum = getDistanc(v,u) + getDistanc(w,u) + 1;
//                    if (sum < sircle[s])
//                        sircle[s] = sum;
                }
            }
        }
        if (flage)
            Vecce[s] = getVecce(G,Vlong,s);
    }

    private int getsameP(int v, int w, int s){
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> w1 = new ArrayList<>();
        int n = edjTo[v];
        while (n != s){
            v1.add(n);
            n = edjTo[n];
        }
        v1.add(s);
        n = edjTo[w];
        while (n != s){
            w1.add(n);
            n = edjTo[n];
        }
        w1.add(s);
        for (int i = 0; i < v1.size(); i++) {
            int local = v1.get(i);
            for (int j = 0; j < w1.size(); j++) {
                if (local == w1.get(j))
                    return local;
            }
        }
        return s;
    }

    private int getDistanc(int v, int u){
        int count = 0;
        while (v != u){
            count++;
            v = edjTo[v];
        }
        return count;
    }

    private int getVecce(Graph g, int vlong, int s) {
        int count =  0;
        for (int i = vlong; i != s; i = edjTo[i]) {
            count++;
        }
        return count;
    }

    public int eccentricity(int v){
        return Vecce[v];
    }

    public int diameter(){
        return D;
    }

    public int radius(){
        return R;
    }

    public int center(){
        return centre;
    }

//    public int girth(){
//        return sircles;
//    }

    public static void main(String[] args) {
        String filename = "/Users/albert/Downloads/Algorithms/src/test4_1/tinyGadj.txt";
        In in = new In(filename);
        Graph graph = new Graph(in);
        System.out.println(graph);
        in.close();
        GraphProperties graphProperties = new GraphProperties(graph);
        System.out.println(graphProperties.eccentricity(0));
        System.out.println(graphProperties.center());
        System.out.println(graphProperties.diameter());
        System.out.println(graphProperties.radius());
//        System.out.println(graphProperties.girth());
    }
}
