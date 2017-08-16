package test3_5;

import edu.princeton.cs.algs4.In;
import test3_3.RedBlackBST;

import java.util.Scanner;

/**
 * Created by albert on 2017/6/26.
 */
public class SelectSection {
    private RedBlackBST<Integer,Integer> redBlackBST;

    public SelectSection() {
        this.redBlackBST = new RedBlackBST<>();
    }

    public void getSection(int lo, int hi){
        redBlackBST.put(lo,hi);
    }

    public String selectSec(int cmp){
        if (redBlackBST.floor(cmp) == null) return "null-section";
        int lo = redBlackBST.floor(cmp);
        //int lo = redBlackBST.select(floor);
        //System.out.println(lo);
        int hi = redBlackBST.get(lo);
        if (cmp >= lo && cmp <=hi)
            return lo + "-" + hi;
        else return "null-section";
    }

    public static void main(String[] args) {
        SelectSection selectSection = new SelectSection();
        Scanner in = new Scanner(System.in);
        String next;
        String[] txt;
        while (!(next=in.nextLine()).equals("ok")){
            txt = next.split("\\s");
            selectSection.getSection(Integer.parseInt(txt[0]),Integer.parseInt(txt[1]));
        }

        while (!(next=in.nextLine()).equals("esc")){
            int n = Integer.parseInt(next);
            System.out.println(selectSection.selectSec(n));
        }
        in.close();
    }
}
