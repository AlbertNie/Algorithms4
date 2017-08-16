package test2_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by albert on 2017/5/4.
 */
public class Text2_1_12 {
    public void test(int N){
        int size = 10;
        Double[] doubles;
        for (int i = 0; i < N; i++) {
            doubles = new Double[size];
            for (int j = 0; j < size; j++) {
                doubles[j] = StdRandom.uniform();
            }
            Shell.sort(doubles);
            size *= 10;
        }
    }

    public static void main(String[] args) {
        Text2_1_12 te = new Text2_1_12();
        te.test(7);
    }
}

//输出结果  可以明显看出结果是常数
//        0 ; 1 ; --------------
//        0 ; 1 ; 2 ; 2 ; --------------
//        0 ; 1 ; 2 ; 2 ; 3 ; 2 ; --------------
//        0 ; 0 ; 1 ; 2 ; 2 ; 3 ; 4 ; 3 ; 2 ; --------------
//        0 ; 0 ; 1 ; 2 ; 2 ; 3 ; 4 ; 5 ; 7 ; 4 ; 2 ; --------------
//        0 ; 1 ; 1 ; 2 ; 3 ; 3 ; 5 ; 6 ; 9 ; 11 ; 10 ; 4 ; 2 ; --------------
//        0 ; 1 ; 1 ; 2 ; 3 ; 3 ; 5 ; 6 ; 9 ; 12 ; 19 ; 23 ; 12 ; 4 ; 2 ; --------------
