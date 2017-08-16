package test2_3;

/**
 * Created by albert on 2017/5/24.
 */
public class Lm implements Comparable{
    public int ccu;

    public Lm(int ccu) {
        this.ccu = ccu;
    }

    @Override
    public int compareTo(Object ls) {
        Ls o = (Ls)ls;
        if (ccu>o.cc)
            return 1;
        else if (ccu<o.cc)
            return -1;
        else
            return 0;
    }
}
