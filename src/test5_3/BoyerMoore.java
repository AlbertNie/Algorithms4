package test5_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by albert on 2017/7/25.
 */
public class BoyerMoore {
    private int[] right;
    private String pat;
    private int count;
    private List<Integer> all;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int R = 256;
        int M = pat.length();
        right = new int[R];
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            right[pat.charAt(i)] = i;
        }
        all = new ArrayList<>();
    }

    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N-M; i = i+skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if (txt.charAt(i+j) != pat.charAt(j)){
                    skip = j - right[txt.charAt(i+j)];
                    if (skip < 0) skip = 0;
                    break;
                }
            }
            if (skip == 0){
                count++;
                all.add(i);
                skip = 1;
            }
        }
        if (all.size() == 0) return N;
        else return all.get(0);
    }

    public int count(){
        return count;
    }

    public Iterable<Integer> searchAll(){
        return all;
    }

    public static void main(String[] args) {
        BoyerMoore boyerMoore = new BoyerMoore("   ");
        System.out.println(boyerMoore.search("asfdsdf   afdsfaf   afasdf  dsfasfas     dafsgasdgadrgrgs"));
        System.out.println(boyerMoore.count());
        for (int d : boyerMoore.searchAll()) {
            System.out.println(d);
        }
    }
}
