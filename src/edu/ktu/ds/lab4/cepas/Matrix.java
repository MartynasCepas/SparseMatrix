package edu.ktu.ds.lab4.cepas;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix {
    private int _size;
    private double[][] _items;

    /**
     * constructor
     *
     * @param size matrix size=n A[nxn]
     */
    Matrix(int size) {
        this._size = size;
        this._items = new double[size][size];  // matrix
    }

    public void random_input(double a, double b) {
        for (int i = 0; i < this._size; ++i) {
            for (int j = 0; j < this._size; ++j) {
                this._items[i][j] = (int) ThreadLocalRandom.current().nextDouble(a, b);
            }
        }
    }

    public void print() {
        for (int i = 0; i < this._size; i++) {
            for (int j = 0; j < this._size; j++) {
                System.out.print(this._items[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public double getElement(int row, int column) {
        for (int i = 0; i < this._size; i++) {
            for (int j = 0; j < this._size; j++) {
                if (row == i && column == j) {
                    return this._items[i][j];
                }
            }
        }
        return 0;
    }

    public void removeElement(int r, int c) {
        _items[r][c] = 0;
    }


}
