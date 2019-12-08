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
    int determinant();

    /*
        Returns a new matrix which is the minor of the original (See project description for minor definition).
     */
    SparseInterface minor(int row, int col);

    /*
    Should return the nonzero elements of your sparse matrix as a string.
    The String should be k lines, where k is the number of nonzero elements.
    Each line should be in the format "row column data" where row and column are the "coordinate" of the data and all are separated by spaces.
    An empty matrix should return an empty string.
    The print should be from left to right and from top to bottom (like reading a book) i.e. the matrix

                                                     3 0 1
                                                     0 2 0
                                                     0 0 4

                                                 Should print as:
                                                     0 0 3
                                                     0 2 1
                                                     1 1 2
                                                     2 2 4

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
