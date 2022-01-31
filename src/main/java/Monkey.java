/*
    Natthawee   Koengfak          6213125
    Wasawat     Pengprakhon       6213132
    Nicharee    Chalermsuksri     6213198
    Puwich      Rotchanakanokchok 6213209
 */

import java.util.*;

class Tree {

    private String ID;
    private int height;
    private int max = 0;

    public Tree(String name, int h) {
        ID = name;
        height = h;
    }

    public String getID() {
        return ID;
    }

    public void setID(String name) {
        ID = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int m) {
        max = m;
    }

    public void print(Tree t2, int count) {
        System.out.println("   path " + count + " :" + "  Tree (" + this.getID() + "), Height = " + this.getHeight() + " ft >>>>>> Tree (" + t2.getID() + "), Height = " + t2.getHeight() + " ft");
    }
}

public class Monkey {

    public static void main(String[] args) {

        int n = 0;
        Scanner scanIn = new Scanner(System.in);
        boolean checkInput = false;
        System.out.println("========================= INPUT YOUR TREE DATA ========================");
        while (!checkInput) {
            try {
                System.out.println("Number of trees: ");
                n = Integer.parseInt(scanIn.nextLine());
                if (n < 3) {
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.println("         Number of trees must be more than 3, please try again.        ");
                    System.out.println("***********************************************************************\n");
                } else {
                    checkInput = true;
                }
            } catch (Exception NumberFormatException) {
                System.out.println("*************************** !!! WARNING !!! ***************************");
                System.out.println("                 Type of input error (Integer only) or");
                System.out.println("            A number is out of range(-2147483647,2147483647)");
                System.out.println("                           Please try again. ");
                System.out.println("***********************************************************************\n");
                scanIn.reset();
            }
        }

        ArrayDeque<Tree> treeQ1 = new ArrayDeque<Tree>();
        int h = 0;
        for (int i = 0; i < n; i++) {
            checkInput = false;
            while (!checkInput) {
                try {
                    System.out.println("Height of tree (" + (i + 1) + "): ");
                    h = Integer.parseInt(scanIn.nextLine());
                    if (h < 1) {
                        System.out.println("*************************** !!! WARNING !!! ***************************");
                        System.out.println("         Height of tree must be more than 0, please try again. ");
                        System.out.println("***********************************************************************\n");
                    } else {
                        checkInput = true;
                    }
                } catch (Exception NumberFormatException) {
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.println("                 Type of input error (Integer only) or");
                    System.out.println("            A number is out of range(-2147483647,2147483647)");
                    System.out.println("                           Please try again. ");
                    System.out.println("***********************************************************************\n");
                    scanIn.reset();
                }
            }
            Tree t = new Tree(Integer.toString(i + 1), h);
            treeQ1.add(t);
        }
        new Forest(treeQ1);

    }
}
