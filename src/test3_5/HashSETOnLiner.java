package test3_5;

import test3_4.LinearProbingHashST;

/**
 * Created by albert on 2017/6/22.
 */
public class HashSETOnLiner<Key> {
    private LinearProbingHashST<Key,Integer> set;
    private final Integer value = 0;

    public HashSETOnLiner(){
        set = new LinearProbingHashST<Key, Integer>();
    }

    public void add(Key key){
        set.put(key,value);
    }

    public void delete(Key key){
        set.delete(key);
    }

    public boolean contains(Key key){
        return set.cotains(key);
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public int size(){
        return set.size();
    }
}
