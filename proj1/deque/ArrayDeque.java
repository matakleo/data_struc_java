package deque;
/**       0 1 2 3 4 5 6 7
 items = {0 0 0 0 0 0 0 0} */

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private StuffNode sentinel;
    private class StuffNode{
        public int first;
        public int last;
        public StuffNode(int p,  int n) {
            first = p;
            last = n;
        }
    }
    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        size = 0;
        nextLast = 5;
        sentinel = new StuffNode(nextLast,nextLast);
    }
    public void resizeArray(){
        T[] additional_items = (T[]) new Object[size*2];
        System.arraycopy(items,0,additional_items,2,size);
        items=additional_items;
        nextFirst=1;
        nextLast=2+size;
    }
    public void addFirst(T x){
        /** set the next first to go into circle*/
        if (size == items.length){
            this.resizeArray();
        }
        /** to transfer next first on the end of the list*/
        items[nextFirst]=x;
        size+=1;
        nextFirst-=1;
        if (nextFirst<0){
            nextFirst= items.length-1;
        }
    }
    public T removeFirst(){
        if (this.isEmpty()){
            return null;
        }
        if (items[0]!=null){
            T x = items[sentinel.first];
            items[sentinel.first]=null;
            nextFirst=sentinel.first;
            size-=1;
            sentinel.first+=1;
            if (nextFirst==items.length-1){
                sentinel.first=0;
            }
            return x;
        }
        T x = items[nextFirst+1];
        items[nextFirst+1]=null;
        nextFirst+=1;
        size-=1;
        return x;
    }
    public void addLast(T x) {
        if (size == items.length){
            this.resizeArray();
        }
        if (nextLast==items.length){
            nextLast= 0;
        }

        items[nextLast]=x;
        sentinel.last=nextLast;
        size+=1;
        nextLast+=1;
    }
    public boolean isEmpty(){
        if (size >0){
            return false;
        }
        return true;
    }
    public int size(){
        System.out.println("size "+size);
        return size;
    }
    public void printDeque(){
        int i =0;
        System.out.print("backend -> ");
        while (i<items.length){
            System.out.print(items[i]+" ");
            i++;
        }
        System.out.println();
        i = sentinel.first;
        System.out.print("frontend -> ");
        while (i<items.length){
            if (items[i]==null){
                i++;
                continue;
                }
            System.out.print(items[i]+" ");
            i++;
        }
        i= 0;
        while(i< sentinel.first){
            if (items[i]==null){
                i++;
                continue;
            }
            System.out.print(items[i]+" ");
            i++;

        }
        System.out.println();
    }

    public T removeLast(){
        if (this.isEmpty()){
            return null;
        }
        if (nextLast==items.length){
            nextLast-=1;
            T x = items[nextLast];
            items[nextLast]=null;
            sentinel.last=nextLast;
            size-=1;
            return x;
        }
        if(nextLast==0){
            nextLast=items.length-1;
            T x = items[nextLast];
            items[nextLast]=null;
            sentinel.last=nextLast;
            size-=1;
            return x;
        }
            T x = items[nextLast-1];
            items[nextLast-1]=null;
            nextLast-=1;
            sentinel.last=nextLast;
            size-=1;
            return x;
    }

    public T get(int index){
        T[] p = (T[]) new Object[items.length];

        int i= 0;
        while(i< items.length && i+sentinel.first<items.length){
            p[i]=items[i+ sentinel.first];
            i++;
            }
        i=0;
        while(i< sentinel.first){
            p[i+items.length- sentinel.first]=items[i];
            i++;
        }
        return p[index];
    }
    public static void main(String[] args) {

    }
}
