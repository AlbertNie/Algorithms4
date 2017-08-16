package test3_4;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/21.
 */
public class SeparateChainingHashST<Key,Value> {
   private int N;
   private int M;
   private SequentialSearchST<Key,Value>[] st;

   public SeparateChainingHashST(){
       this(997);
   }

   class SequentialSearchST<Key,Value>{
       private Node first;
       class Node{
           int N;
           Key key;
           Value value;
           Node next;

           public Node(Key key, Value value, Node next, int N) {
               this.key = key;
               this.value = value;
               this.next = next;
               this.N = N;
           }
       }

       public void put(Key key, Value value, int N){
           for(Node x = first; x!=null; x = x.next){
               if (key.equals(x.key)) {
                   x.value = value;
                   x.N = N;
                   return;
               }
           }
           new Node(key,value,first,N);
       }

       public Value get(Key key){
           for (Node x= first; x!=null; x = x.next){
               if (key.equals(x.key))
                   return x.value;
           }
           return null;
       }

       public void delete(Key key){
           first = delete(first,key);
       }

       private Node delete(Node x, Key key) {
           if (x == null) return null;
           if (key.equals(x.key)) {
               N--;
               return x.next;
           }
           x.next = delete(x.next,key);
           return x;
       }

       private boolean cotains(Key key){
           for (Node x = first; x!=null; x=x.next)
               if (key.equals(x.key))
                   return true;
           return false;
       }

       public void deleteUpN(int n){
           while (first!=null && first.N > n){
               first = first.next;
           }
           if (first == null) return;
           Node x = first;
           Node y = first.next;
           while (y!=null){
               if (y.N > n){
                   x.next = y.next;
                   y = y.next;
                   N--;
                   continue;
               }
               x = x.next;
               y = y.next;
           }
       }

       public void getKeys(Queue<Key> que){
           Node x = first;
           while (x != null)
               que.enqueue(x.key);
       }
   }


    public SeparateChainingHashST(int M) {
       this.M = M;
       st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key){
       return (key.hashCode() & 0x7fffffff)%M;
    }

    public Value get(Key key){
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value){
        st[hash(key)].put(key,value,N);
        N++;
    }

    public void deleteUpK(int k){
        for (int i = 0; i < M; i++) {
            st[i].deleteUpN(k);
        }
    }

    public void delete(Key key){
        st[hash(key)].delete(key);
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            st[i].getKeys(queue);
        }
        return queue;
    }
}
