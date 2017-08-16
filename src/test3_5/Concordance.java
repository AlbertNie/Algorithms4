package test3_5;


import test3_3.RedBlackBST;

import java.util.Scanner;

/**
 * Created by albert on 2017/6/26.
 */
public class Concordance {
        public static void main(String[] args) {
        RedBlackBST<String,SET<Integer>> redBlackBST = new RedBlackBST<>();
        Scanner in = new Scanner(System.in);
        String next;
        String[] text;
        while (!(next = in.nextLine()).equals("")){
            text = next.split("\\s");
            if (!redBlackBST.contains(text[0])){
                redBlackBST.put(text[0],new SET<>());
            }
            redBlackBST.get(text[0]).put(Integer.parseInt(text[1]));
        }
        in.close();
            for (String key : redBlackBST.keys()) {
                System.out.println(key);
                for (int x : redBlackBST.get(key).keys()) {
                    System.out.print(x + ";");
                }
                System.out.println();
            }
    }
}
