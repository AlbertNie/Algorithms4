package test2_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/8.
 */
public class California implements Comparable<California>{
    private static final String standard = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
    private String value;

    public California(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        California that = (California) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public int compareTo(California that) {
        if (this.equals(that))
            return 0;
        int n = Math.min(this.value.length(),that.value.length());
        String thi,tha;
        for (int i = 0; i < n; i++) {
            thi = this.value.charAt(i)+"";
            tha = that.value.charAt(i)+"";
            if (standard.indexOf(thi)>standard.indexOf(tha))
                return 1;
            if (standard.indexOf(thi)<standard.indexOf(tha))
                return -1;
        }
        return this.value.length() - that.value.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<California> californias = new ArrayList<>();
        String next;
        while (!(next = in.nextLine()).equals("")){
            californias.add(new California(next));
        }
        in.close();
        Collections.sort(californias);
        for (California name : californias) {
            System.out.println(name);
        }
    }
}
