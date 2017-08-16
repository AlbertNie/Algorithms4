package test3_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


/**
 * Created by albert on 2017/6/21.
 */
public class FindSameHash {
    public static void main(String[] args) {
        int N=0;
        String[] zimu = new String[26];
        for (char a='a'; a<='z'; a++){
            zimu[N++] = a+"";
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode()-o2.hashCode();
            }
        } ;
        Random r = new Random();

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            StringBuffer s = new StringBuffer();
            s.append(zimu[r.nextInt(26)]);
            s.append(zimu[r.nextInt(26)]);

            list.add(s.toString());
            s.delete(0,5);
        }
        Collections.sort(list,comparator);
        int j = 0;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).hashCode() == list.get(i+1).hashCode() &&
                !list.get(i).equals(list.get(i+1))) {
                System.out.println(list.get(i) +"     " +list.get(i + 1));
                j++;
            }
        }
        System.out.println(j);
    }
}
