package test2_1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by albert on 2017/5/4.
 */
public class SortCompare {
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("test2_1.Insertion"))
            Insertion.sort(a);
        if (alg.equals("test2_1.Selection"))
            Selection.sort(a);
        if (alg.equals("test2_1.Shell"))
            Shell.sort(a);
        if (alg.equals("test2_1.StInsertion"))
            StInsertion.sort(a);
        return timer.elapsedTime();
    }

    //alg方法，N 数据大小，T 实验次数
    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a =new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }
}
