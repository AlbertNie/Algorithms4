package test4_2;

/**
 * Created by albert on 2017/7/5.
 */
public class SCC {
    private int[] id;
    private int count;
    private boolean[] marked;
    public SCC(Digraph G){
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G.reverse());
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s : depthFirstOrder.reversePost()) {
            if (!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;
        id[s] = count;
        for (int v : G.adj(s)) {
            if (!marked[v])
                dfs(G,v);
        }
    }

    public int count(){
        return count;
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }
}
