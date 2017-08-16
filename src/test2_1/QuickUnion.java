package test2_1;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/2.
 */
public class QuickUnion {
    private int[] id;
    private int count;
    private int amount=0;

    public QuickUnion(int N ) {
        this.count=N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    public int Count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int find(int p){
        while (p != id[p]) {
            amount++;
            p = id[p];
        }
        amount++;
        return p;
    }

    public void union(int p, int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        amount++;
        count--;
    }
    //获得访问数组的次数
    public int Amount(){
        int n = amount;
        amount = 0;
        return n;
    }
    //获得ID数组
    public void getId(){
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]+" ");
        }
        System.out.println();
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        Scanner in = new Scanner(System.in);
        String number=null;
        while (!"q".equals(number=in.nextLine())){
            String[] xu = number.split("-");
            int p = Integer.parseInt(xu[0]);
            int q = Integer.parseInt(xu[1]);
            quickUnion.union(p,q);
            System.out.println(quickUnion.Amount());
            quickUnion.getId();
        }
        in.close();
    }
}

//输出结果
//        9-0
//        3
//        0 1 2 3 4 5 6 7 8 0
//        ------------------------
//        3-4
//        3
//        0 1 2 4 4 5 6 7 8 0
//        ------------------------
//        5-8
//        3
//        0 1 2 4 4 8 6 7 8 0
//        ------------------------
//        7-2
//        3
//        0 1 2 4 4 8 6 2 8 0
//        ------------------------
//        2-1
//        3
//        0 1 1 4 4 8 6 2 8 0
//        ------------------------
//        5-7
//        6
//        0 1 1 4 4 8 6 2 1 0
//        ------------------------
//        0-3
//        4
//        4 1 1 4 4 8 6 2 1 0
//        ------------------------
//        4-2
//        4
//        4 1 1 4 1 8 6 2 1 0
//        ------------------------
