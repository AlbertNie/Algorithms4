package test2_5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/8.
 */
public class LPT {
    private static PriorityQueue<Record> minHeap;

    public static void main(String[] args) {
        int M = 0;
        int N = 0;
        int i = 0;
        String[] ta;
        Record taskb;
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        Record[] tasks = new Record[N];
        minHeap = new PriorityQueue<>(M);
        String task = null;
        in = new Scanner(System.in);
        while (!(task = in.nextLine()).equals("")){
            ta = task.split("\\s+");
            tasks[i] = new Record(ta[0]);
            tasks[i].setFreq(Integer.parseInt(ta[1]));
            i++;
        }
        in.close();
        Arrays.sort(tasks);

        for (int j = N-1; j >= 0; j--) {
            System.out.println(tasks[j]);
        }

        i = N-1;
        for (int j = 0; j < M; j++) {
            minHeap.offer(tasks[i--]);
        }
        for (int j = i; j >=0 ; j--) {
            taskb = minHeap.poll();
            tasks[j].addFreq(taskb.getFreq());
            minHeap.offer(tasks[j]);
        }
    }
}
