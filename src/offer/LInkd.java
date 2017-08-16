package offer;

import java.util.*;

/**
 * Created by albert on 2017/8/2.
 */
public class LInkd {
        public ArrayList<String> Permutation(String str) {
            Comparator<Integer> max = new Comparator<Integer>() {
                @Override
                public int compare(Integer n, Integer m) {
                    if (n > m) return -1;
                    else if (n < m) return 1;
                    else return 0;
                }
            };
            PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(max);

            ArrayList<String> list = new ArrayList();
            if(str == null || str.length() == 0) return list;
            char[] strch = str.toCharArray();
            Arrays.sort(strch);
            LinkedHashSet<String> set = new LinkedHashSet();
            collect(set,0,strch.length,strch);
            list.addAll(set);
            return list;
        }

        private void collect(LinkedHashSet<String> set, int j, int m, char[] strch){
            if(j == m){
                set.add(new String(strch));
                return;
            }
            for(int i = j; i<m; i++){
                swap(strch,i,j);
                collect(set,j+1,m,strch);
                swap(strch,i,j);
            }
        }
        private void swap(char[] strch, int i, int j){
            if(i!=j){
                char x = strch[i];
                strch[i] = strch[j];
                strch[j] = x;
            }
        }
    }

