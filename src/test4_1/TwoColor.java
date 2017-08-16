package test4_1;

/**
 * Created by albert on 2017/7/1.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                dfs(G,i);
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked[v]){
                marked[v] = true;
                color[v] = !color[s];
                dfs(g,v);
            }else if (color[v] == color[s]) isTwoColor = false;
        }
    }

    public boolean isBipartite(){
        return isTwoColor;
    }
}
