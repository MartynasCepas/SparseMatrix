package edu.ktu.ds.lab4.cepas;

import java.util.LinkedList;

public interface SparseInterface {
    void clear();

    void addElement(int row, int col, int data);

    void removeElement(int row, int col);

    int getElement(int row, int col);

    String toString();

    int getSize();

    void setSize(int size);

    LinkedList getMat();

    void printMatrix();
}
