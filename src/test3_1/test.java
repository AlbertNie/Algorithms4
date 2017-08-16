package test3_1;

/**
 * Created by albert on 2017/6/14.
 */
public class test {
    public static void add(int n){
        n=n+1;
    }

    public static void change(int n, int m){
        int i=n;
        n=m;
        m=i;
    }

    public test(int n ){

    }

    public test(int n, int m){
        this(n);
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        change(n,m);
        add(n);
        System.out.println(n);
    }
}
