package test4_4;

/**
 * Created by albert on 2017/7/13.
 */
public class DirectedEdge {
    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from(){
        return from;
    }

    public int to(){
        return to;
    }

    public double weight(){
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d(%.2f)",from,to,weight);
    }
}
