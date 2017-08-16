package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class Test2_1_24 {
    public static void main(String[] args) {
        double st;
        double in;
        st = SortCompare.timeRandomInput("test2_1.StInsertion",10000,10);
        in = SortCompare.timeRandomInput("test2_1.Insertion",10000,10);
        System.out.println(in/st);
    }
}
