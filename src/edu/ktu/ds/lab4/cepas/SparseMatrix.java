package edu.ktu.ds.lab4.cepas;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SparseMatrix implements SparseInterface {
    LinkedList<Node> mat = new LinkedList<>();

    int sizeOfMat;
    // default constructor
    public SparseMatrix() {
        setSize(5);
    }

    public SparseMatrix(int size) {
        setSize(size);
    }

    // returns size of the sparse matrix
    public int getSize() {
        return sizeOfMat;
    }

    // changes size of the sparse matrix
    public void setSize(int size) {
        if (size >= 0) {
            clear();
            sizeOfMat = size;
        } else {
            System.out.println("Not a valid size");
        }
    }

    // clears sparse matrix
    public void clear() {
        while (!mat.isEmpty()) {
            mat.removeFirst();
        }
    }

    // adds element to the specified position
    public void addElement(int row, int col, int data) {
        // checks if range is legit
        if (row >= sizeOfMat || col >= sizeOfMat || row < 0 || col < 0) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index not in range");
            }
        } else if (data != 0) {
            Node hold = new Node(row, col, data);
            mat.add(hold);
        }
    }

    // removes specified element from the sparse matrix
    public void removeElement(int row, int col) {
        if (row >= sizeOfMat || col >= sizeOfMat || row < 0 || col < 0) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index not in range");
            }
        } else {
            for (Node n : mat) {
                if (n.getRow() == row && n.getCol() == col) {
                    mat.remove(n);
                    break;
                }
            }
        }
    }

    // returns data from the specified position
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

    // prints matrix
    public String toString() {
        String matrixStr = "";

        for (Node n : mat) {
            matrixStr += n.getRow() + " " + n.getCol() + " " + n.getValue() + "\n";
        }

        return matrixStr;
    }

    public LinkedList<Node> getMat() {
        return mat;
    }

    // populates sparse matrix with data
    public void randomInput(double a, double b) {
        for (int i = 0; i < this.sizeOfMat; i++) {
            for (int j = 0; j < this.sizeOfMat; j++) {
                int k = (int) ThreadLocalRandom.current().nextDouble(a, b);
                addElement(i, j, k);
            }
        }
    }

    // prints sparse matrix as a matrix
    public void printMatrix() {
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