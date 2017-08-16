package test2_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/7.
 * 从标准输入中读取一列字符串，并按照字符串出现频率由高到低的顺序打印出每个字符串以及其出现的次数
 */
public class Frequency {
    private String[] value;
    private int N;
    private PriorityQueue<Record> maxHeap;



    public Frequency(String[] value){
        this.value = value;
        N = value.length;
        Comparator<Record> revCmp = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.compareTo(o1);
            }
        };
        maxHeap = new PriorityQueue<>(revCmp);
    }

    public void getresult(){
        Arrays.sort(value);
        Record record = new Record(value[0]);
        for (int i = 1; i < N; i++) {
            if (value[i].equals(value[i-1])){
                record.addsu();
            }else {
                maxHeap.offer(record);
                record = new Record(value[i]);
            }
        }
        maxHeap.offer(record);
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        in.close();
        String[] value = test.split("\\s+");
        Frequency frequency = new Frequency(value);
        frequency.getresult();
    }
}












