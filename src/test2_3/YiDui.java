package test2_3;

/**
 * Created by albert on 2017/5/24.
 */
public class YiDui {
    private Ls ls;
    private Lm lm;

    public YiDui(Comparable ls, Comparable lm) {
        if (ls.getClass() == Ls.class){
            this.ls = (Ls)ls;
            this.lm = (Lm)lm;
        }else {
            this.ls = (Ls)lm;
            this.lm = (Lm)ls;
        }
    }

    @Override
    public String toString() {
        return "ls=" + ls.cc +
                ", lm=" + lm.ccu;
    }
}
