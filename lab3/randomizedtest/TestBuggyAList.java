package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {

      AListNoResizing<Integer> AL1 = new AListNoResizing<Integer>();
      AL1.addLast(10);
      AL1.addLast(20);
      AL1.addLast(30);

      BuggyAList<Integer> BAL1 = new BuggyAList<Integer>();
      BAL1.addLast(10);
      BAL1.addLast(20);
      BAL1.addLast(30);


      assertEquals(AL1.size(),BAL1.size());


      assertEquals(AL1.removeLast(),BAL1.removeLast());
      assertEquals(AL1.removeLast(),BAL1.removeLast());
      assertEquals(AL1.removeLast(),BAL1.removeLast());
  }

  @Test
    public void RandomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> B = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              B.addLast(randVal);

          } else if (operationNumber == 1) {
              // size
              int sizeL = L.size();
              int sizeB = B.size();
              assertEquals(sizeL,sizeB);

          }
          if (L.size()>0) {
              if (operationNumber == 2) {
                  // remove last
                  assertEquals(L.removeLast(),B.removeLast());


              } else if (operationNumber == 3) {
                  // getLast
                  assertEquals(L.getLast(),B.getLast());
//                  int getlastL = L.getLast();
//                  int getlastB = B.getLast();

              }
          }
      }
  }
}

