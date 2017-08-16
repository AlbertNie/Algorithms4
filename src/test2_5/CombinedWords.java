package test2_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by albert on 2017/6/7.
 */
public class CombinedWords {
    private String[] words;
    private int N;

    public CombinedWords(String[] words){
        this.words = words;
        N = words.length;
    }

    private int isInclude(String word, int i){
        for (int k = i; k < N; k++) {
            if (words[i].indexOf(word)>=0)
                return i;
        }
        return -1;
    }

    private int includeIn(String word){
        for (int i = 0; i < N; i++) {
            if (word.equals(words[i]))
                return i;
        }
        return -1;
    }

    public ArrayList<String> getCombinedWords(){
        ArrayList<String> combinedWords = new ArrayList<>();
        Arrays.sort(words);
        int j = -1;
        int k = -1;
        for (int i = 0; i < N; i++) {
            if ((j=isInclude(words[i],i+1))>=0){
                String next = new String(words[j]);
                next=next.replaceAll(words[i],"");
                if ((k=includeIn(next))>=0){
                    combinedWords.add(words[i]);
                    combinedWords.add(words[k]);
                    combinedWords.add(words[j]);
                }
                j=-1;
                k=-1;
            }
        }
        return combinedWords;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();
        in.close();
        String[] words = src.split("\\s+");
        CombinedWords combinedWords = new CombinedWords(words);
        ArrayList<String> combinedword = combinedWords.getCombinedWords();
        for (String word: combinedword) {
            System.out.println(word);
        }
//        String test = "abcd";
//        String a = "ab";
//        System.out.println(test.replaceAll(a,""));
    }
}
