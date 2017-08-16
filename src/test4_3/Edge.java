package test4_3;

/**
 * Created by albert on 2017/7/10.
 */
public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if (v == vertex) return w;
        if (w == vertex) return v;
        else throw new RuntimeException("Error Edge");
    }

    public double weight(){
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        double result = this.weight - o.weight();
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return v + "->" + w + ":weight:" + weight;
    }
}
