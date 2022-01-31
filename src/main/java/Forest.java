
import java.util.*;

public class Forest {

    ArrayDeque<Tree> treeQ1;
    ArrayDeque<Tree> treeQ2 = new ArrayDeque<Tree>();
    ArrayDeque<Tree> treeQ3 = new ArrayDeque<Tree>();

    Forest(ArrayDeque<Tree> t) {
        treeQ1 = t;
        Swing();
    }

    void Swing() {
        Tree t1;
        Tree t2;
        int count = 0;
        System.out.println("============================ ALL SOLUTION =============================");

        ArrayDeque<Tree> treeSwing1 = new ArrayDeque<Tree>();
        ArrayDeque<Tree> treeSwingTemp = new ArrayDeque<Tree>();

        while (!treeQ1.isEmpty()) {
            if (treeQ3.isEmpty()) {
                treeSwing1 = treeQ2;
                treeSwingTemp = treeQ3;
            } else {
                treeSwing1 = treeQ3;
                treeSwingTemp = treeQ2;
            }
            count++;
            t1 = treeQ1.pollFirst();
            t2 = treeQ1.peekFirst();

            if (t2 == null) {
                count--;
                break;
            }
            t1.print(t2, count);

            if (t1.getHeight() > t2.getHeight()) {
                t1.setMax(t2.getHeight());
                treeSwing1.add(t1);
            } else if (t1.getHeight() < t2.getHeight()) {
                while (!treeSwing1.isEmpty()) {
                    t1 = treeSwing1.pollLast();
                    if (t1.getMax() < t2.getHeight()) {
                        //System.out.println("Check");
                        t1.setMax(t2.getHeight());
                        count++;
                        t1.print(t2, count);
                    }

                    if (t1.getHeight() > t2.getHeight()) {
                        treeSwingTemp.addFirst(t1);
                    }
                }
            }
        }
        System.out.println("=======================================================================");
        System.out.println("Total tree-pairs : " + count + " paths");
        System.out.println("=======================================================================");
    }
}
