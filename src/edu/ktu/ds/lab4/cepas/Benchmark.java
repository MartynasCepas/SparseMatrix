package edu.ktu.ds.lab4.cepas;

import java.lang.reflect.Array;

public class Benchmark {
    public static void main(String[] args) {
        int numberOfElements = 500;
        int memUsed = 0;

        Matrix matrix = new Matrix(numberOfElements);
        SparseMatrix sparseMatrix = new SparseMatrix(numberOfElements);
        long m1 = currentMemUse();
        long t0 = System.nanoTime();
        matrix.random_input(0, 2);
        long t1 = System.nanoTime();
        System.out.println("Matrix finished add() in: " + (t1 - t0) * 1e-9);
        long m2 = currentMemUse();
        //long matrixMemory = memDifference();

        long m3 = currentMemUse();
        long t2 = System.nanoTime();
        sparseMatrix.random_input(0, 2);
        long t3 = System.nanoTime();
        long m4 = currentMemUse();
        System.out.println("Sparse Matrix finished add() in: " + (t3 - t2) * 1e-9);
        // long sparseMatrixMemory = memDifference();

        getElementTest(numberOfElements, matrix, sparseMatrix);
        removeTest(numberOfElements, sparseMatrix);
        System.out.println("Memory used by Matrix: " + (m2 - m1));
        System.out.println("Memory used by Sparse Matrix " + (m4 - m3));
    }

    private static void removeTest(int numberOfElements, SparseMatrix sparseMatrix) {
        long t0 = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            for (int j = 0; j < numberOfElements; j++) {
                sparseMatrix.removeElement(i, j);
            }
        }
        long t1 = System.nanoTime();
        System.out.println("Sparse matrix remove() finished in: " + (t1 - t0) * 1e-9);
    }

    private static void getElementTest(int numberOfElements, Matrix matrix, SparseMatrix sparseMatrix) {
        long t0 = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            for (int j = 0; j < numberOfElements; j++) {
                sparseMatrix.getElement(i, j);
            }
        }
        long t1 = System.nanoTime();
        System.out.println("Sparse matrix get() finished in: " + (t1 - t0) * 1e-9);

        long t2 = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            for (int j = 0; j < numberOfElements; j++) {
                double k = matrix.getElement(i, j);
            }
        }
        long t3 = System.nanoTime();
        System.out.println("Matrix get() finished in: " + (t3 - t2) * 1e-9);
    }

    private static long currentMemUse() {
        System.gc();
        System.gc();
        System.gc();
        long memTotal = Runtime.getRuntime().totalMemory();
        long memFree = Runtime.getRuntime().freeMemory();
        long memUsed = memTotal - memFree;
        return memUsed;
    }
}
