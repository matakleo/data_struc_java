package deque;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDeque<T> implements Iterable<T>,Deque<T>{

    public StuffNode sentinel;
    private int size;
    private class StuffNode{
        public T item;
        public StuffNode prev;
        public StuffNode next;



        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    @Override
    public int size(){
        return size;
    }

//    public T removeFirst(): Removes and returns the item at the front of the deque. If no such item exists, returns null.
@Override
    public T removeFirst(){
        if (sentinel.next==sentinel){
            return null;
        }
        size-=1;
        T f = sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        return f;

    }
//    public T removeLast(): Removes and returns the item at the back of the deque. If no such item exists, returns null.
@Override
    public T removeLast(){

        if (sentinel.prev == sentinel){
            return null;
        }
        size-=1;
        T l = sentinel.prev.item;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.prev.next=sentinel;
        return l;

    }
//    public T get(int index): Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
@Override
    public T get(int index){
//        size-=1;
        LinkedListDeque l = this;
        if (l.isEmpty()){
            return null;
        }
        StuffNode to_return;
        StuffNode save_the_first;
        save_the_first=l.sentinel.next;
        int counter = 0;
        while (counter != index){
            counter+=1;
            l.sentinel.next=l.sentinel.next.next;
        }
        to_return=l.sentinel.next;
        l.sentinel.next=save_the_first;
//        to_return.prev.next=to_return.next;
//        to_return.next.prev=to_return.prev;
        return to_return.item;
    }

//    public T getRecursive(int index){
//        int new_size=size;
//    }
    /**  for adding a number in one node list */
    public LinkedListDeque(T x){
        size+=1;



        sentinel = new StuffNode(null,x,null);
        sentinel.next=new StuffNode(sentinel,x,sentinel);
        sentinel.prev=sentinel.next;

    }

    /**  for empty list */
    public LinkedListDeque(){
        size=0;
        sentinel = new StuffNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;

    }
//    @Override
//    public boolean isEmpty() {
//        if (sentinel.prev != sentinel) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public void addFirst(T x){
//        sum_size+=1;
        size+=1;
//        if (size > 1) {
//            sentinel.next=new StuffNode(sentinel,x,sentinel.next);
//        }
//        sentinel.next.prev=
        sentinel.next=new StuffNode(sentinel,x,sentinel.next);
        sentinel.next.next.prev=sentinel.next;
    }
    @Override
    public void addLast(T x){
        size+=1;

        sentinel.prev=new StuffNode(sentinel.prev,x,sentinel);
        sentinel.prev.prev.next=sentinel.prev;

        if (sentinel.prev.prev == sentinel) {
            sentinel.next=sentinel.prev;
        }


    }
    @Override
    public void printDeque(){
        LinkedListDeque l = this;
        StuffNode save_first_node = l.sentinel.next;


        while (l.sentinel.next != l.sentinel){
            System.out.print(l.sentinel.next.item+" ");
            l.sentinel.next=l.sentinel.next.next;
        }
        l.sentinel.next=save_first_node;
        System.out.println();

    }


    /** returns an iterator (a.k.a. seer) into ME */

    public Iterator<T> iterator() {
        return new LinkedListDequeueIterator();
    }

    private class LinkedListDequeueIterator implements Iterator<T> {
        private int wizPos;
        public LinkedListDequeueIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            for (T a : this) {
                if (a.equals(x)){
                    return true;
                }
            }

        }
        return false;
    }

    public boolean equals(Object other) {

        if (other instanceof LinkedListDeque o){
            if (o.size()!=this.size()){
                return false;
            }
            for (T item : this){
                if (!o.contains(item)){
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedListDeque<Integer> three_item_list = new LinkedListDeque<Integer>();
        three_item_list.addFirst(12);
        three_item_list.addFirst(99);
        three_item_list.addLast(3);
        three_item_list.printDeque();
        for (int i : three_item_list) {
            System.out.println(i);
        }
//        three_item_list.printDeque();
    }
}
