package test5_3;

/**
 * Created by albert on 2017/7/25.
 */
public class BruteForceRL {
    private String pat;

    public BruteForceRL(String pat) {
        this.pat = pat;
    }

    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        int j;
        for (int i = 0; i <= N-M; i++) {
            for (j = M-1; j >= 0; j--) {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if (j == -1) return i;
        }
        return N;
    }
}
