package edu.ktu.ds.lab4.cepas;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SparseMatrix implements SparseInterface {
    LinkedList<Node> mat = new LinkedList<>();  //Linked list to hold all of the non 0 entries of the matrix

    int sizeOfMat;                              //Size of the matrix
    int deter = 0;                              //Holds the value of the determinant

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
        } else if (data != 0) {
            Node hold = new Node(row, col, data);
            //If an entry already exists then it will delete that entry at that position and add the new value
            if (hold.getCol() == col && hold.getRow() == row) {
                removeElement(row, col);
            }
            int index = 0;

            for (Node n : mat) {
                if ((n.getRow() > row) || (n.getRow() == row && n.getCol() > col)) {
                    mat.add(index, hold);
                    break;
                }
                index++;
            }

            // if list is empty
            if (mat.size() == 0) {
                mat.add(hold);
            } else if (index == mat.size()) {
                mat.add(hold);
            }
        } else if (data == 0) {
            removeElement(row, col);
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

    public int determinant() {

        //If the matrix is a 1X1 matrix
        if (sizeOfMat == 1)
            return getElement(0, 0);

        //Base case if the matrix gets down to 2X2
        if (sizeOfMat == 2) {
            return getElement(0, 0) * getElement(1, 1) - getElement(0, 1) * getElement(1, 0);
        }

        for (int i = 0; i < mat.size(); i++) {
            //Just resets the deter variable if determinant is called multiple times
            if (i == 0) {
                deter = 0;
            }

            Node ele = mat.get(i);
            //The element that will be determine the minor
            int element = mat.get(i).getValue();

            //The equation to calculate the determinant
            deter += element * (int) Math.pow(-1, ele.getCol()) * minor(0, ele.getCol()).determinant();

        }

        return deter;
    }

    //Returns the smaller version of the matrix
    public SparseInterface minor(int row, int col) {

        SparseInterface temp = new SparseMatrix(sizeOfMat - 1);
        //These shifts to move the indexes from the larger matrix to the smaller matrix

        int colShift;
        for (Node n : mat) {
            int rowNum = n.getRow();
            int numCol = n.getCol();
            //If the index is not on this row and this column then it will add to the smaller matrix
            if (rowNum != row && numCol != col) {
                //If the column is to the right of the column being deleted then it has to be shifted to the left one otherwise stay the same
                colShift = numCol > col ? 1 : 0;
                //Row is always shifted up because row 0 is being deleted
                temp.addElement(rowNum - 1, numCol - colShift, n.getValue());

            }
        }
        return temp;
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

    public void random_input(double a, double b) {
        for (int i = 0; i < this.sizeOfMat; ++i) {
            for (int j = 0; j < this.sizeOfMat; ++j) {
                int k = (int) ThreadLocalRandom.current().nextDouble(a, b);
                addElement(i, j, k);
            }
        }
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