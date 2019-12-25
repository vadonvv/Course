package ru.vvv.course;

public class Task5 {
    static public void run(int size){
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size-1-i] = 1;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        for (int[] row:matrix
             ) {
            for (int i:row
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
    }
}
