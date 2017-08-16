package test4_2;

/**
 * 练习4。2。9 检测给定的排序是否是拓扑排序
 * Created by albert on 2017/7/5.
 */
public class CheckTopo {

    public static boolean isTopologic(Digraph G, int[] topo){
        boolean[] inStack =  new boolean[topo.length];
        boolean[] marked = new boolean[topo.length];
        boolean flage;
        for (int i = 0; i < topo.length; i++) {
            inStack[topo[i]] = true;
            flage = digrapDFS(G,topo[i],inStack,marked);
            if (!flage) return false;
        }
        return true;
    }

    private static boolean digrapDFS(Digraph G, int s, boolean[] inStack, boolean[] marked){
        marked[s] = true;
        for (int v : G.adj(s)) {
            if (inStack[v]) return false;
            if (!marked[v]) return digrapDFS(G,v,inStack,marked);
        }
        return true;
    }
}
