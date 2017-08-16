package test2_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/8.
 */
public class Domain implements Comparable<Domain>{
    private String domainName;
    private String[] name;

    public Domain(String domainName){
        this.domainName = domainName;
        name = domainName.split("\\.");
        String a = null;
        for (int i = 0; i < name.length/2; i++) {
            a = name[i];
            name[i] = name[name.length-1-i];
            name[name.length-1-i] = a;
        }
    }

    @Override
    public int compareTo(Domain o) {
        if (this == o)
            return 0;
        int n = Math.min(this.name.length,o.name.length);
        for (int i = 0; i < n; i++) {
            if (this.name[i].compareTo(o.name[i])!=0)
                return this.name[i].compareTo(o.name[i]);
        }
        return this.name.length - o.name.length;
    }

    @Override
    public String toString() {
        String names = "";
        for (int i = 0; i < name.length - 1; i++) {
            names += name[i] + ".";
        }
        names = names + name[name.length-1];
        return names;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Domain> domains = new ArrayList<>();
        String next;
        while (!(next = in.nextLine()).equals("")){
            domains.add(new Domain(next));
        }
        in.close();
        Collections.sort(domains);
        for (Domain d : domains) {
            System.out.println(d);
        }
    }
}
