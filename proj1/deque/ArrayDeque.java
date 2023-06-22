package deque;
/**       0 1 2 3 4 5 6 7
 items = {0 0 0 0 0 0 0 0} */

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    private int last_element_from_right;
    private int last_added_last;
    private int nextFirst;
    private int nextLast;
    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 4;
        size = 0;
        nextLast = 5;
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

        if (size == items.length){
            System.out.println("RESIZE");
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
    public Item removeFirst(){
        if (this.isEmpty()){
            return null;
        }
        if (items[0]!=null){
            Item x = items[0];
            items[0]=null;
            nextFirst=0;
            size-=1;
            return x;
        }
        Item x = items[nextFirst+1];
        items[nextFirst+1]=null;
        nextFirst+=1;
        size-=1;
        return x;
    }
    public void addLast(Item x) {
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
        System.out.println("size "+size);
        return size;
    }
    public void printDeque(){
        int i = 0;
        while (i<items.length){
            if (items[i]==null){
                i++;
                continue;
                }
            System.out.print(items[i]+" ");
            i++;

        }

        while (i<items.length){
            System.out.print(items[i]+" ");
            i++;
        }
        System.out.println();
    }

    public Item removeLast(){
        if (this.isEmpty()){
            return null;
        }
        if (nextLast==items.length){
            nextLast-=1;
        }
        if(nextLast-1<0){
            nextLast=items.length-1;
            Item x = items[nextLast];
            items[nextLast]=null;
            size-=1;
            return x;
        }
            Item x = items[nextLast-1];
            items[nextLast-1]=null;
            nextLast-=1;
            size-=1;
            return x;
    }

    public Item get(int index){
        if (nextFirst>2){
            return items[index];
        }
    return items[nextFirst+index+1];
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> a =new ArrayDeque<Integer>();
        a.addLast(2);
        a.printDeque();
        a.addLast(3);
        a.printDeque();
        a.addLast(37);
        a.printDeque();
        a.addLast(57);
        a.printDeque();
       int b=a.removeLast();
        a.printDeque();
        a.addLast(17);
        a.addLast(17);
        a.addLast(17);
        a.addLast(12);
        a.addLast(11);
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.addLast(11);
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.addLast(11);
        a.printDeque();

        a.get(0);
        a.get(3);

        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.size();
        a.addLast(11);
        a.printDeque();


//        a.addFirst(47);
//        int h=a.removeFirst();
//        int c=a.removeFirst();
//        int d=a.removeFirst();
//        a.removeFirst();
//        a.addFirst(h);
//        int q=a.removeFirst();

    }
}
