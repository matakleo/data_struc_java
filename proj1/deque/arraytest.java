package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class arraytest {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {


        List<Integer> BAL1 = new ArrayList<Integer>();

        ArrayDeque<Integer> AL1 = new ArrayDeque<Integer>();
        AL1.addLast(10);
        AL1.addLast(20);
        AL1.addLast(30);
        AL1.addLast(40);
        AL1.addLast(50);
        AL1.addLast(60);
        AL1.addLast(70);
        AL1.addLast(80);


        BAL1.add(10);
        BAL1.add(20);
        BAL1.add(30);
        BAL1.add(40);
        BAL1.add(50);
        BAL1.add(60);
        BAL1.add(70);
        BAL1.add(80);



        assertEquals(AL1.size(),BAL1.size());

        assertEquals(AL1.removeLast(),BAL1.remove(7));
        assertEquals(AL1.removeLast(),BAL1.remove(6));
        assertEquals(AL1.removeLast(),BAL1.remove(5));
        assertEquals(AL1.removeLast(),BAL1.remove(4));
        assertEquals(AL1.removeLast(),BAL1.remove(3));
        assertEquals(AL1.removeLast(),BAL1.remove(2));
        assertEquals(AL1.removeLast(),BAL1.remove(1));
        assertEquals(AL1.removeLast(),BAL1.remove(0));
    }

    @Test
    public void testFirst() {


        List<Integer> BAL1 = new ArrayList<Integer>();

        ArrayDeque<Integer> AL1 = new ArrayDeque<Integer>();
        AL1.addFirst(10);
        AL1.addFirst(20);
        AL1.addFirst(30);
        AL1.addFirst(40);
        AL1.addFirst(50);
        AL1.addFirst(60);
        AL1.addFirst(70);
        AL1.addFirst(80);


        BAL1.add(0,10);
        BAL1.add(0,20);
        BAL1.add(0,30);
        BAL1.add(0,40);
        BAL1.add(0,50);
        BAL1.add(0,60);
        BAL1.add(0,70);
        BAL1.add(0,80);



        assertEquals(AL1.size(),BAL1.size());

        assertEquals(AL1.removeLast(),BAL1.remove(7));
        assertEquals(AL1.removeLast(),BAL1.remove(6));
        assertEquals(AL1.removeLast(),BAL1.remove(5));
        assertEquals(AL1.removeLast(),BAL1.remove(4));
        assertEquals(AL1.removeLast(),BAL1.remove(3));
        assertEquals(AL1.removeLast(),BAL1.remove(2));
        assertEquals(AL1.removeLast(),BAL1.remove(1));
        assertEquals(AL1.removeLast(),BAL1.remove(0));
    }

    @Test
    public void RandomizedTest() {

        List<Integer> L = new ArrayList<Integer>();
        ArrayDeque<Integer> B = new ArrayDeque<>();

        int N = 100000;
        for (int i = 0; i < N; i += 1) {

            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                if (B.size()==8){
                    continue;
                }
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.add(randVal);
                B.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                assertEquals(sizeL,sizeB);

            }
            if (B.size()>0) {
                if (operationNumber == 2) {
                    // remove last
                    assertEquals(L.remove(L.size()-1),B.removeLast());


                } else if (operationNumber == 3) {
                    // get
                    int to_get = StdRandom.uniform(0, B.size());
                    assertEquals(L.get(to_get),B.get(to_get));


                }
                else if (operationNumber == 4) {

                    assertEquals(L.remove(0),B.removeFirst());


                }
                else if (operationNumber == 5) {
                    if (B.size()==8){
                        continue;
                    }
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    L.add(0,randVal);
                    B.addFirst(randVal);

                }
            }
        }
    }
}

