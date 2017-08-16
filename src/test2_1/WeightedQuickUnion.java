package test2_1;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/2.
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;
    private int amount=0;

    public WeightedQuickUnion(int N){
        this.count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int Count(){
        return count;
    }
    public boolean connect(int p, int q){
        return find(p) == find(q);
    }
    public int find(int p){
        while(p != id[p]){
            p=id[p];
            amount++;
        }
        amount++;
        return p;
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += qRoot;
        }
        amount++;
        count--;
    }
    public int Amount(){
        int n = amount;
        amount=0;
        return n;
    }
    public void getId(){
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]+" ");
        }
        System.out.println();
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion= new WeightedQuickUnion(10);
        Scanner in = new Scanner(System.in);
        String number=null;
        while (!"q".equals(number=in.nextLine())){
            String[] xu = number.split("-");
            int p = Integer.parseInt(xu[0]);
            int q = Integer.parseInt(xu[1]);
            weightedQuickUnion.union(p,q);
            System.out.println(weightedQuickUnion.Amount());
            weightedQuickUnion.getId();
        }
        in.close();
    }

}

//输出结果：
//        9-0
//        3
//        9 1 2 3 4 5 6 7 8 9
//        ------------------------
//        3-4
//        3
//        9 1 2 3 3 5 6 7 8 9
//        ------------------------
//        5-8
//        3
//        9 1 2 3 3 5 6 7 5 9
//        ------------------------
//        7-2
//        3
//        9 1 7 3 3 5 6 7 5 9
//        ------------------------
//        2-1
//        4
//        9 7 7 3 3 5 6 7 5 9
//        ------------------------
//        5-7
//        3
//        9 7 7 3 3 5 6 5 5 9
//        ------------------------
//        0-3
//        4
//        9 7 7 3 3 5 6 5 5 3
//        ------------------------
//        4-2
//        6
//        9 7 7 5 3 5 6 5 5 3
//        ------------------------
