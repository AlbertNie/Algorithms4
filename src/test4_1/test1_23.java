package test4_1;

import java.util.ArrayList;

/**
 * 由movies得到图的联通分量的数量和包含的定点数小于10的连通分量的数量，
 * 计算最大的连通分量的离心率，直径，半径和中点，
 * kevin bacon在最大的连通分量中吗。
 * Created by albert on 2017/7/1.
 */
public class test1_23 {
    public static void main(String[] args) {
        String stream = "/Users/albert/Downloads/Algorithms/src/test4_1/movies.txt";
        String sp = "/";
        SymbolGraph symbolGraph = new SymbolGraph(stream,sp);
        CC cc = new CC(symbolGraph.G());
        System.out.println("连通分量的数量为： "+ cc.count());
        int[] id = new int[cc.count()];
        for (int i = 0; i < symbolGraph.G().V(); i++) {
            id[cc.id(i)]++;
        }
        int count = 0;
        int max = 0;
        int maxID = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] < 10)
                count++;
            if (id[i]>max) {
                max = id[i];
                maxID = i;
            }
        }
        System.out.println("小于10个的连通分量有：" + count + "个");
        int[] graph = cc.getGraphWithID(maxID);
        GraphProperties graphProperties = new GraphProperties(symbolGraph.G(),graph);
        System.out.println("最大连通分量的各个属性如下：");
        System.out.println("离心率：0点 " + graphProperties.eccentricity(0));
        System.out.println("直径： " + graphProperties.diameter());
        System.out.println("半径： " + graphProperties.radius());
        System.out.println("中点： " + graphProperties.center());
    }
}
