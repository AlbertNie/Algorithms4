package test2_3;
import java.util.*;

/**
 * Created by albert on 2017/5/24.
 */
public class test2_3_15 {

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void exch(List<Comparable> a, int i, int j){
        Comparable v = a.get(i);
        a.set(i,a.get(j));
        a.set(j,v);
    }

    private static int partition(Comparable v, List<Comparable> a, int lo, int hi){
        int lt = lo,gt = hi-1,i = lo;
        int j=0;
        while (i <= gt){
            int cmp = a.get(i).compareTo(v);
            if (cmp<0)
                i++;
            else if (cmp>0)
                exch(a,i,gt--);
            else {
                j = i;
                i++;
            }
        }
        return j;
    }

    public static void peiDui(List<Comparable> lms, List<Comparable> lss, YiDui[] yiDuis){
        if (lms.size() == 0)
            return;
        int i = partition(lms.get(0),lss,0,lss.size());
        yiDuis[lms.size()-1] = new YiDui(lms.get(0),lss.get(i));
        lms.remove(0);
        partition(lss.get(i),lms,0,lms.size());
        lss.remove(i);
        peiDui(lms, lss, yiDuis);
    }

    public static void main(String[] args) {
        int N = 1000;
        List<Comparable> lms = new ArrayList<>(N);
        List<Comparable> lss = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            lms.add(new Lm(i));
        }
        for (int i = 0; i < N; i++) {
            lss.add(new Ls(i));
        }
        Collections.shuffle(lms);
        Collections.shuffle(lss);
        YiDui[] yiDuis = new YiDui[N];
        peiDui(lms,lss,yiDuis);
        for (YiDui yi : yiDuis) {
            System.out.println(yi);
        }
    }
}
