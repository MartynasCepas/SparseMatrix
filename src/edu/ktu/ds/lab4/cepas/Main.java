package edu.ktu.ds.lab4.cepas;

public class Main {

    public static void main(String[] args) {
        SparseInterface a = new SparseMatrix();

        a.addElement(0, 1, 4);

        String correctString = "0 1 4\n";

        System.out.println("toString is correct: " + correctString.equals(a.toString()));

        a.setSize(3);

        System.out.println("Size is 3 " + (a.getSize() == 3));

        correctString = "";

        System.out.println("toString is correct: " + correctString.equalsIgnoreCase(a.toString()));

        a.addElement(2, 2, 4);
        a.addElement(1, 0, -3);

        correctString = "1 0 -3\n2 2 4\n";

        System.out.println("toString is correct: " + correctString.equalsIgnoreCase(a.toString()));


        a.clear();

        a.addElement(0, 0, 2);
        a.addElement(0, 1, 4);
        a.addElement(0, 2, 5);
        a.addElement(1, 0, 4);
        a.addElement(1, 1, 5);
        a.addElement(1, 2, 1);
        a.addElement(2, 0, 5);
        a.addElement(2, 1, 1);
        a.addElement(2, 2, 2);
        System.out.println(a.toString());


        a.clear();

        System.out.println("Sparse Matrix");
        a.setSize(7);
        a.addElement(5, 4, 9);
        a.addElement(6, 1, 2);
        a.addElement(5, 3, 2);
        a.addElement(1, 1, 4);
        a.addElement(1, 2, 5);
        a.addElement(2, 0, 4);
        a.addElement(2, 2, 1);
        a.addElement(3, 1, 5);
        a.addElement(4, 6, 2);
        a.addElement(0, 5, 2);
        a.addElement(6, 1, 3);
        a.addElement(2, 4, 5);
        a.addElement(1, 4, 5);
        a.addElement(0, 0, 2);
        a.addElement(0, 3, 7);
        a.addElement(3, 3, 1);
        a.addElement(3, 3, 3);
        a.addElement(5, 2, 7);
        a.addElement(2, 1, 8);
        a.addElement(1, 6, 5);
        a.addElement(2, 4, 5);
        a.addElement(4, 6, 3);
        a.addElement(5, 2, 1);


        System.out.println(a.toString());
        System.out.println("Sparse Matrix as Matrix");
        a.printMatrix();
    }
}
