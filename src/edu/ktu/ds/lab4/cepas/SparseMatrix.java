package edu.ktu.ds.lab4.cepas;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SparseMatrix implements SparseInterface {
    LinkedList<Node> mat = new LinkedList<>();  //Linked list to hold all of the non 0 entries of the matrix

    int sizeOfMat;                              //Size of the matrix

    public SparseMatrix() {
        setSize(5);
    }

    //Matrix constructor that sets the size of the size x size matrix
    public SparseMatrix(int size) {
        setSize(size);
    }

    public int getSize() {
        return sizeOfMat;
    }

    public void setSize(int size) {
        if (size >= 0) {
            clear();
            sizeOfMat = size;
        } else {
            System.out.println("Not a valid size");
        }
    }

    public void clear() {
        while (!mat.isEmpty()) {
            mat.removeFirst();
        }
    }

    public void addElement(int row, int col, int data) {
        // checks if range is legit
        if (row >= sizeOfMat || col >= sizeOfMat || row < 0 || col < 0) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index not in range");
            }
        } else if(data != 0){
            Node hold = new Node(row, col, data);
            mat.add(hold);
        }
    }


    public void removeElement(int row, int col) {

        if (row >= sizeOfMat || col >= sizeOfMat || row < 0 || col < 0) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index not in range");
            }
        } else {
            //Traverses through the linked list and sees if there is an element in the list
            for (Node n : mat) {
                if (n.getRow() == row && n.getCol() == col) {
                    mat.remove(n);
                    //break to end the traversal because there is only 1 position that will be deleted
                    break;
                }
            }
        }
    }

    public int getElement(int row, int col) {

        if (row >= sizeOfMat || col >= sizeOfMat || row < 0 || col < 0) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index not in range");
            }
        } else {
            for (Node n : mat) {
                if (n.getRow() == row && n.getCol() == col) {
                    return n.getValue();
                }
            }
        }

        return 0;
    }


    public String toString() {

        String matrixStr = "";

        //Prints the string from left to right

        for (Node n : mat) {
            matrixStr += n.getRow() + " " + n.getCol() + " " + n.getValue() + "\n";
        }

        return matrixStr;
    }

    public LinkedList<Node> getMat() {
        return mat;
    }

    public void randomInput(double a, double b) {
        for (int i = 0; i < this.sizeOfMat; i++) {
            for (int j = 0; j < this.sizeOfMat; j++) {
                int k = (int) ThreadLocalRandom.current().nextDouble(a, b);
                addElement(i, j, k);
            }
        }
    }

    public void printMatrix(){
        String matrix = "";
        for (int i = 0; i < this.sizeOfMat; i++) {
            for (int j = 0; j < this.sizeOfMat; j++) {
                var k = getElement(i, j);
                matrix += k + " ";
            }
            matrix += "\n";
        }
        System.out.println(matrix);
    }
}


//This class will hold the information of all of the nodes in the matrix: row, col, value
class Node {

    int row;
    int col;
    int value;

    public Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }

    public int getCol() {
        return col;
    }

}