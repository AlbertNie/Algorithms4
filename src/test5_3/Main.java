package test5_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by albert on 2017/7/25.
 */
public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            if (n == 1){
                System.out.println(1);
                return;
            }
            if (n == 2){
                System.out.println(2);
                return;
            }
            long[] count = new long[n+1];
            count[2] = 2;
            boolean flage = true;
            int m = 0;
            for (int i = 3; i <= n; i++) {
                for (int j=2; j<i; j++) {
                    if (i % j == 0) {
                        flage = false;
                        m++;
                    }
                }
                if (flage) {
                    count[i] = 2*count[i-1]%1000000007;
                }
                else {
                    count[i] = (count[i-1]*2 - (long)Math.pow(2,m-1))%1000000007;
                }
                flage = true;
                m = 0;
            }
            System.out.println(count[n]);
        }
    }
