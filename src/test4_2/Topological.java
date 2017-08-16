package test4_2;

import test4_4.DirectedEdge;
import test4_4.EdgeWeightedCycle;
import test4_4.EdgeWeightedDigraph;

/**
 * Created by albert on 2017/7/5.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G){
        EdgeWeightedCycle directedCycle = new EdgeWeightedCycle(G);
        if (!directedCycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order!=null;
    }
}
