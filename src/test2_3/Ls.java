package test2_3;

/**
 * Created by albert on 2017/5/24.
 */
public class Ls implements Comparable{
    public int cc;

    public Ls(int cc) {
        this.cc = cc;
    }

    @Override
    public int compareTo(Object lm) {
        Lm o= (Lm)lm;
        if (cc>o.ccu)
            return 1;
        else if (cc<o.ccu)
            return -1;
        else
            return 0;
    }
}
