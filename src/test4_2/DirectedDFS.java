package test4_2;

/**
 * Created by albert on 2017/7/5.
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s])
                dfs(G,s);
        }
    }

    private void dfs(Digraph G, int s){
        marked[s] = true;
        for (int v : G.adj(s)) {
            if (!marked[v])
                dfs(G,v);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }
}
