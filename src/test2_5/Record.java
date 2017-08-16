package test2_5;

/**
 * Created by albert on 2017/6/8.
 */
public class Record implements Comparable<Record>{
    public String value;
    private int freq = 1;

    public Record(String value) {
        this.value = value;
    }

    public void addsu(){
        freq++;
    }

    public void setFreq(int N){
        this.freq=N;
    }

    public void addFreq(int N){
        this.freq = freq + N;
    }

    public int getFreq(){
        return freq;
    }

    @Override
    public String toString() {
        return value + " : " + freq;
    }

    @Override
    public int compareTo(Record o) {
        if (this.freq>o.freq)
            return 1;
        else if (this.freq<o.freq)
            return -1;
        else
            return 0;
    }
}
