package offer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Created by albert on 2017/8/2.
 */
public class ByteBuffertest {
    public static int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> result = new ArrayList();
        result.add(1);
        int n = 2;
        while(result.size() < index){
            int m = n;
            while(n >= 2 && n % 2 == 0)
                n = n/2;
            while(n >= 3 && n % 3 == 0)
                n = n/3;
            while(n >= 5 && n % 5 == 0)
                n = n/5;
            if(n == 1)
                result.add(m);
            n = m;
            n++;
        }
        return result.get(index-1);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(100000));
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : set) {
            ;
        }
    }


}
