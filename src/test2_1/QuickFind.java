package test2_1;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/2.
 * 1.5.1
 */
public class QuickFind {
    private int[] id;
    private int count;

    private int amount=0;     //访问数组的次数

    public QuickFind(int N ) {
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
        amount++;
        return id[p];
    }
    public void union(int p, int q){
        int pId=find(p);
        int qId=find(q);
        if(pId == qId)
            return;
        for (int i = 0; i < id.length; i++) {
            amount++;
            if(id[i] == pId){
                id[i] = qId;
            }
        }
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
        QuickFind quickFind = new QuickFind(10);
        Scanner in = new Scanner(System.in);
        String number=null;
        while (!"q".equals(number=in.nextLine())){
            String[] xu = number.split("-");
            int p = Integer.parseInt(xu[0]);
            int q = Integer.parseInt(xu[1]);
            quickFind.union(p,q);
            System.out.println(quickFind.Amount());
            quickFind.getId();
        }
        in.close();
    }
}

//输出结果
//        9-0
//        12
//        0 1 2 3 4 5 6 7 8 0
//        ------------------------
//        3-4
//        12
//        0 1 2 4 4 5 6 7 8 0
//        ------------------------
//        5-8
//        12
//        0 1 2 4 4 8 6 7 8 0
//        ------------------------
//        7-2
//        12
//        0 1 2 4 4 8 6 2 8 0
//        ------------------------
//        2-1
//        12
//        0 1 1 4 4 8 6 1 8 0
//        ------------------------
//        5-7
//        12
//        0 1 1 4 4 1 6 1 1 0
//        ------------------------
//        0-3
//        12
//        4 1 1 4 4 1 6 1 1 4
//        ------------------------
//        4-2
//        12
//        1 1 1 1 1 1 6 1 1 1
//        ------------------------
