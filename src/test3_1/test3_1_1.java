package test3_1;

import edu.princeton.cs.algs4.ST;

import java.util.Scanner;

/**
 * Created by albert on 2017/6/13.
 */
public class test3_1_1 {
    public static void main(String[] args) {
        ST<String, Double> st = new ST<>();
        st.put("A+",4.33);
        st.put("A",4.00);
        st.put("A-",3.67);
        st.put("B+",3.33);
        st.put("B",3.00);
        st.put("B-",2.67);
        st.put("C+",2.33);
        st.put("C",2.00);
        st.put("C-",1.67);
        st.put("D",1.00);
        st.put("F",0.00);
        Scanner in = new Scanner(System.in);

        double GPA = 0;
        int n = 0;
        String s = null;
        while (!(s=in.nextLine()).equals("")){
            GPA += st.get(s);
            n++;
        }

        in.close();
        System.out.println(GPA/n);
    }
}
