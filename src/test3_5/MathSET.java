package test3_5;

import java.util.ArrayList;

/**
 * Created by albert on 2017/6/23.
 */
public class MathSET<Key> {
    private HashSET<Key> hashSET;
    private Key[] universe;

    public MathSET(Key[] universe){
        hashSET = new HashSET<Key>();
        for (int i = 0; i < universe.length; i++) {
            hashSET.put(universe[i]);
        }
        this.universe = universe;
    }
    public MathSET(){
        hashSET = new HashSET<Key>();
        this.universe = null;
    }

    public void add(Key key){
        hashSET.put(key);
    }

    public MathSET<Key> complement(){
        ArrayList<Key> keys = new ArrayList<Key>();
        for (int i = 0; i < universe.length; i++) {
            if (!hashSET.cotains(universe[i]))
                keys.add(universe[i]);
        }
        return new MathSET<Key>((Key[]) keys.toArray());
    }

    public Iterable<Key> keys(){
        return hashSET.keys();
    }

    public boolean contains(Key key){
        return hashSET.cotains(key);
    }

    public void union(MathSET<Key> a){
        for (Key key : a.keys()) {
            if (!hashSET.cotains(key))
                hashSET.put(key);
        }
    }

    public void intersection(MathSET<Key> a){
        for (Key key : hashSET.keys()) {
            if (!a.contains(key))
                hashSET.delete(key);
        }
    }

    public void delete(Key key){
        hashSET.delete(key);
    }

    public boolean isEmpty(){
        return hashSET.isEmpty();
    }

    public int size(){
        return hashSET.size();
    }


}



















