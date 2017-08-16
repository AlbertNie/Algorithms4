package test2_4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Scanner;

/**
 * Created by albert on 2017/6/6.
 */
public class TopM implements Comparable<TopM>{
    private int x,y,z;
    private double distance;

    public TopM(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        distance = Math.sqrt(x*x+y*y+z*z);
    }

    @Override
    public int compareTo(TopM o) {
        if (this.distance>o.distance) return 1;
        else if (this.distance<o.distance) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "(" +
                x +
                "," + y +
                "," + z +
                ", distance=" + distance +
                ')';
    }

    public static void main(String[] args) {
//        int M = Integer.parseInt(args[0]);
        int M = 4;
        MinPQ<TopM> ms = new MinPQ<>(M);
        String[] xyz;
        Scanner in = new Scanner(System.in);
        String next;
        while (!(next=in.nextLine()).equals("esc")) {
            xyz = next.split(",");
            if (ms.size() == M)
                ms.delMin();
            ms.insert(new TopM(Integer.parseInt(xyz[0]), Integer.parseInt(xyz[1]), Integer.parseInt(xyz[2])));
        }
        in.close();
        for (int i = 0; i < M; i++) {
            System.out.println(ms.delMin());
        }
    }
}
