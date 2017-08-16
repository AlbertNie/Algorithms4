package test3_5;

import test3_3.RedBlackBST;

/**
 * Created by albert on 2017/6/22.
 */
public class RedBlackSET<Key extends Comparable<Key>> {
    private RedBlackBST<Key,Integer> set;
    private Integer value = 0;

    public RedBlackSET(){
        set = new RedBlackBST<Key, Integer>();
    }

    public void add(Key key){
        set.put(key,value);
    }

    public void delete(Key key){
        set.delete(key);
    }

    public boolean contains(Key key){
        return set.contains(key);
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public int size(){
        return set.size();
    }

}
