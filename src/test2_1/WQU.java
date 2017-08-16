package test2_1;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/3.
 */
public class WQU {
    private int[] id;
    private int[] sz;
    private int count;

    public WQU(int N){
        this.count=N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        int q = p;
        while (p != id[p]) {
            p = id[p];
        }
        while (q != id[q]){
            q = id[q];
            id[q] = p;
        }
        return p;
    }

    public void union(int p, int q){
        int i;
        int j;
        i = find(p);
        j = find(q);
        if (j == i)
            return;
        if (sz[i] < sz[j]){
            sz[j] += sz[i];
            id[i] = j;
        }else {
            sz[i] += sz[j];
            id[j] = i;
        }
        count--;
    }
    public void getSj(){
        for (int i = 0; i < sz.length; i++) {
            System.out.print(sz[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < sz.length; i++) {
            System.out.print(id[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WQU wqu = new WQU(10);
        String text;
        while (!"q".equals((text=in.nextLine()))){
            String[] number;
            number = text.split("-");
            wqu.union(Integer.parseInt(number[0]),Integer.parseInt(number[1]));
        }
        in.close();
        wqu.getSj();
    }
}
