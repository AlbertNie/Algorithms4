package test5_3;

import java.util.Scanner;

/**
 * Created by albert on 2017/7/26.
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int i = 1, X = 0; i < M; i++) {
            for (int j = 0; j < R; j++) {
                dfa[j][i] = dfa[j][X];
            }
            dfa[pat.charAt(i)][i] = i+1;
            X = dfa[pat.charAt(i)][X];
        }
    }

    public int search(String txt){
        int i,j,N = txt.length(),M = pat.length();
        for (i = 0,j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;
        else return N;
    }
}
