package test3_5;

import edu.princeton.cs.algs4.Queue;
import test3_3.RedBlackBST;

import java.util.Scanner;


/**
 * Created by albert on 2017/6/26.
 */
public class InvertedConcordance {
    public static boolean isSame(SET<Integer> set1, SET<Integer> set2){
        Queue<Integer> keys1 = (Queue<Integer>) set1.keys();
        Queue<Integer> keys2 = (Queue<Integer>) set2.keys();
        if (keys1.size() != keys2.size()) return false;
        for (int i = 0; i < keys1.size(); i++) {
            if (!keys1.dequeue().equals(keys2.dequeue()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //构造对照索引
        RedBlackBST<Integer,SET<String>> redBlackBST = new RedBlackBST<>();
        Scanner in = new Scanner(System.in);
        String next;
        String[] text;
        while (!(next = in.nextLine()).equals("")){
            text = next.split("\\s");
            if (!redBlackBST.contains(Integer.parseInt(text[1]))){
                redBlackBST.put(Integer.parseInt(text[1]),new SET<>());
            }
            redBlackBST.get(Integer.parseInt(text[1])).put(text[0]);
        }

        System.out.println("对照索引构造成功.............");
        System.out.println("请输入查询.............");

        while (!(next=in.nextLine()).equals("esc")){
            text = next.split("\\s");
            MathSET<String> mathSET = new MathSET<>();
            SET<String> a = redBlackBST.get(Integer.parseInt(text[0]));
            for (String x : a.keys()) {
                mathSET.add(x);
            }
            for (int i = 1; i < text.length; i++) {
                MathSET<String> mathSET1 = new MathSET<>();
                SET<String> b = redBlackBST.get(Integer.parseInt(text[i]));
                for (String x : b.keys()) {
                    mathSET1.add(x);
                }
                mathSET.intersection(mathSET1);
            }
            Queue<String> queue = (Queue<String>) mathSET.keys();
            if (queue.size() == 0) {
                System.out.println("未找到相应单词 ........");
                continue;
            }
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        }
        in.close();
    }
}
/**
 * 测试用例
 a 121
 a 123
 a 134
 a 143
 b 121
 b 123
 b 134
 c 123
 c 34234
 c 12
 c 23132
 */
