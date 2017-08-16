package test5_3;

import java.util.*;

/**
 * Created by albert on 2017/7/25.
 */
public class Brute {
    private String pat;
    private int count;
    private List<Integer> all;

    public Brute(String pat) {
        this.pat = pat;
        count = 0;
        all = new ArrayList<>();
    }

    public int search(String txt){
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i < N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if (j == M){
                count++;
                all.add(i);
            }
        }
        if (all.size() == 0) return N;
        else return all.get(0);
    }

    public int count(){
        return count;
    }

    public Iterable<Integer> searchAll(){
        return (Iterable<Integer>) all;
    }

    public static void main(String[] args) {
        Brute b = new Brute("abc");
        System.out.println(b.search("dadfasgasgeagsgagaaabcasdfaagaabcagadfgfdaabc"));
        System.out.println(b.count());
        for (int d : b.searchAll()) {
            System.out.println(d);
        }
    }
}
