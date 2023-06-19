package deque;
/**       0 1 2 3 4 5 6 7
 items = {0 0 0 0 0 0 0 0} */

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Item[]) new Object[3];
        nextFirst = 1;
        size = 0;
        nextLast = 2;
    }

    public void resizeArray(){
        Item[] additional_items = (Item[]) new Object[size*2];
        System.arraycopy(items,0,additional_items,2,size);
        items=additional_items;
        nextFirst=1;
        nextLast=2+size;
    }
    public void addFirst(Item x){
        /** set the next first to go into circle*/
        System.out.println("next First "+nextFirst+" size "+size);
        if (size == items.length){
            this.resizeArray();
        }

        if (nextFirst<0){
            nextFirst= items.length-1;
        }

        items[nextFirst]=x;
        nextFirst-=1;

        size+=1;


    }
    public void addLast(Item x) {
        System.out.println("item added "+x+ " to "+nextLast+" size "+size);
        if (size == items.length){
            this.resizeArray();
        }

        if (nextLast==items.length){
            nextLast= 0;
        }

        items[nextLast]=x;
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
        return size;
    }
    public void printDeque(){
        int i = 0;
        while (i<items.length){
            System.out.print(items[i]+" ");
            i++;

        }
        System.out.println();
    }
    public Item removeFirst(){
        Item x = items[0];
        items[0]=null;
        return x;
    }
    public Item removeLast(){
        Item x = items[size];
        items[size]=null;
        return x;
    }

    public Item get(int index){
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a =new ArrayDeque<Integer>();
        a.addLast(2);
        a.addLast(5);
        a.addLast(51);
        a.addLast(12);
        a.addLast(126);
        a.addLast(1216);
        a.printDeque();
        a.addLast(12116);
        a.addFirst(1);
        a.addFirst(12);
        a.addFirst(19);
        a.printDeque();
        a.addFirst(111);
        a.addFirst(113);


        a.addLast(91);
        a.printDeque();
        a.addFirst(12116);
        a.addLast(2);
        a.addLast(5);
        a.addLast(51);
        a.addLast(12);
        a.addLast(126);
        a.addLast(1216);
        a.printDeque();
        a.addLast(12116);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);

        a.printDeque();
    }
}
