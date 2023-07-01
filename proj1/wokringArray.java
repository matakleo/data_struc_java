//package deque;
//
//import jh61b.junit.In;
//
//public class wokringArray<Item> {
//
//    private Item[] items;
//    private int size;
//
//    private int last_element_from_right;
//    private int last_added_last;
//    private int nextFirst;
//    private int nextLast;
//    /** Creates an empty list. */
//    public wokringArray() {
//        items = (Item[]) new Object[8];
//        nextFirst = 0;
//        size = 0;
//        nextLast = 0;
//    }
//
//    public void resizeArray(){
//        Item[] additional_items = (Item[]) new Object[size*2];
//        System.arraycopy(items,0,additional_items,2,size);
//        items=additional_items;
//        nextFirst=1;
//        nextLast=2+size;
//    }
//    public void addFirst(Item x){
//        /** set the next first to go into circle*/
//
//        if (size == items.length){
//            System.out.println("RESIZE");
//            this.resizeArray();
//        }
//        /** to transfer next first on the end of the list*/
//        items[nextFirst]=x;
//        size+=1;
//        nextFirst-=1;
//        if (nextFirst<0){
//            nextFirst= items.length-1;
//        }
//    }
//    public Item removeFirst(){
//        if (this.isEmpty()){
//            return null;
//        }
//        if (items[0]!=null){
//            Item x = items[0];
//            items[0]=null;
//            nextFirst=0;
//            size-=1;
//            return x;
//        }
//        Item x = items[nextFirst+1];
//        items[nextFirst+1]=null;
//        nextFirst+=1;
//        size-=1;
//        return x;
//    }
//    public void addLast(Item x) {
//        if (size == items.length){
//            this.resizeArray();
//        }
//        if (nextLast==items.length){
//            nextLast= 0;
//        }
//        items[nextLast]=x;
//        size+=1;
//        nextLast+=1;
//    }
//    public boolean isEmpty(){
//        if (size >0){
//            return false;
//        }
//        return true;
//    }
//    public int size(){
//        System.out.println("size "+size);
//        return size;
//    }
//    public void printDeque(){
//        int i = 0;
//        while (i<items.length){
//            if (items[i]==null){
//                i++;
//                continue;
//            }
//            System.out.print(items[i]+" ");
//            i++;
//
//        }
//
//        while (i<items.length){
//            System.out.print(items[i]+" ");
//            i++;
//        }
//        System.out.println();
//    }
//
//    public Item removeLast(){
//        if (this.isEmpty()){
//            return null;
//        }
//        if (nextLast==items.length){
//            nextLast-=1;
//        }
//        if(nextLast-1<0){
//            nextLast=items.length-1;
//            Item x = items[nextLast];
//            items[nextLast]=null;
//            size-=1;
//            return x;
//        }
//        Item x = items[nextLast-1];
//        items[nextLast-1]=null;
//        nextLast-=1;
//        size-=1;
//        return x;
//    }
//
//    public Item get(int index){
//        if (nextFirst>2){
//            return items[index];
//        }
//        return items[nextFirst+index+1];
//    }
//
//    public static void main(String[] args) {
//        wokringArray<Integer> L = new wokringArray<Integer>();
//        L.addLast(2);
//        L.addLast(4);
//        L.addLast(6);
//        L.addLast(8);
//        L.addLast(10);
//        L.addLast(12);
//        L.addLast(14);
//        L.addLast(16);
//
//        L.printDeque();
//    }
//}
