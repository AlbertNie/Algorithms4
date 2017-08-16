package test3_2;

/**
 * Created by albert on 2017/6/16.
 */
public class test3_2_13 {
    public static void main(String[] args) {
        RewriteBST<Integer,String> rewriteBST = new RewriteBST<>();
        rewriteBST.put(1,"a");
        rewriteBST.put(2,"b");
        rewriteBST.put(4,"c");
        rewriteBST.put(5,"d");
        rewriteBST.put(6,"e");
//        System.out.print(rewriteBST.get(1));
//        System.out.print(rewriteBST.get(2));
//        System.out.print(rewriteBST.get(4));
//        System.out.print(rewriteBST.get(5));
//        System.out.println(rewriteBST.get(6));
//        System.out.println(rewriteBST.min());
//        System.out.println(rewriteBST.max());
//        System.out.println(rewriteBST.floor(3));
//        System.out.println(rewriteBST.ceiling(3));
//        System.out.println(rewriteBST.rank(3));
        System.out.println(rewriteBST.select(4));
        for (int i = 0; i < 200; i++) {
            System.out.print(rewriteBST.randomKey() + " ");
        }


    }
}
