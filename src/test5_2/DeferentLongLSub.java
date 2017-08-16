package test5_2;

import java.util.Scanner;

/**
 * Created by albert on 2017/7/22.
 */
public class DeferentLongLSub {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        in.close();
        TST<Integer> tst = new TST<>();
        for (int i = 0; i < test.length()-3; i++) {
            tst.put(test.substring(i,i+3),i);
        }
        for (String e : tst.keys()) {
            System.out.println(e);
        }
    }
}
