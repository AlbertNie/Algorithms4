package test2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by albert on 2017/5/9.
 */
public class test2_6 {
    public Double[] test;
    public Double[] makeTest(int N){
        test = new Double[N];
        for (int i = 0; i < N; i++) {
            test[i] = StdRandom.uniform();
        }
        return test;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        test2_6 t = new test2_6();
        int N = in.nextInt();
        in.close();
        Double[] test;
        int j;
        int k;
        StdDraw.setXscale(0,512);
        StdDraw.setYscale(0,280000);
        StdDraw.setPenRadius(0.001);


        for (int i = 0; i < N; i++) {
            test = t.makeTest(i+1);
            Merge.sort(test);
            j=Merge.getCount();
            StdDraw.setPenColor(Color.red);
            StdDraw.point(i,j);

            MergeBU.sort(test);
            k=MergeBU.getCount();
            StdDraw.setPenColor(Color.black);
            StdDraw.point(i,k);
            System.out.println(j+" : " + k + "  " + j/(6*(i+1)*Math.log(i+1)) + " : " + k/(6*(i+1)*Math.log(i+1)));
        }
    }
}
