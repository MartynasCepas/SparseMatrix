package edu.ktu.ds.lab4.cepas;

import java.util.LinkedList;

public interface SparseInterface {
    void clear();

    /*
        Adds an element to the row and column passed as arguments (overwrites if element is already present at that position).
        Throws an error if row/column combination is out of bounds.
     */
    void addElement(int row, int col, int data);

    /*
        Remove (make 0) the element at the specified row and column.
        Throws an error if row/column combination is out of bounds.
     */
    void removeElement(int row, int col);

    /*
        Return the element at the specified row and column
        Throws an error if row/column combination is out of bounds.
     */
    int getElement(int row, int col);

    /*
        Returns the determinant of the matrix calculated recursively (Use the formula provided in the project description).
     */

    public String toString();

    /*
    Returns the size of the matrix.
     */
    int getSize();

    /*
        Sets maximum size of the matrix, clears the matrix (make all elements 0)
     */
    void setSize(int size);

    LinkedList getMat();
}
