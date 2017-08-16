package test2_5;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/8.
 * 2.5.12 调度任务使得任务 完成平均时间最小
 */
public class SPT {
    public static PriorityQueue<Record> minHeap;
    public static void main(String[] args) {
        minHeap = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        Record tsk = null;
        String value = null;
        String[] task;
        while (!(value = in.nextLine()).equals("")){
            task = value.split("\\s+");
            tsk = new Record(task[0]);
            tsk.setFreq(Integer.parseInt(task[1]));
            minHeap.offer(tsk);
        }
        in.close();
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
