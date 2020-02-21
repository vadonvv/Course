package ru.vvv.course;

public class Task4 {
    public static void run(int size){
        double[] inputArr;
        double maxVal, currVal;

        inputArr = genArr(size);
        maxVal = inputArr[0] + inputArr[size*2-1];
        for (int i = 1; i < size; i++) {
            currVal = inputArr[i] + inputArr[2*size - i - 1];
            if(maxVal < currVal) {
               maxVal = currVal;
            }
        }
        System.out.println(maxVal);

    }

    public static double[] genArr(int n){
        double[] rndArr = new double[2*n];

        for (int i = 0; i < 2*n; i++){
            rndArr[i] = Math.random()*1000-500;
            System.out.println(rndArr[i]);
        }
        System.out.println();
        return rndArr;
    }

}
