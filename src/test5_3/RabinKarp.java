package test5_3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by albert on 2017/7/25.
 */
public class RabinKarp {
   private String pat;
   private long patHash;
   private int M;
   private long Q;
   private int R = 256;
   private long RM;
   private int count;
   private List<Integer> all;

    public RabinKarp(String pat) {
        this.pat = pat;
        M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 0; i < M; i++) {
            RM = (RM * R)%Q;
        }
        patHash = hash(pat,M);
        all = new ArrayList<>();
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int i = 0; i < m; i++) {
            h = (h*R + key.charAt(i))%Q;
        }
        return h;
    }

    public int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt,M);
        if (txtHash == patHash && check(0)){
            count++;
            all.add(0);
        }
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M)%Q)%Q;
            txtHash = (txtHash*R + txt.charAt(i))%Q;
            if (txtHash == patHash && check(i-M+1)){
                count++;
                all.add(i-M+1);
            }
        }
        if (all.size() == 0) return N;
        else return all.get(0);
    }

    private boolean check(int i) {
        return true;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31,new Random());
        return prime.longValue();
    }
}
