package ru.vvv.course;

public class Task2 {
    public static void run(){
        //First
        int[] arr = genArr();
        for (int j = 0; j < arr.length/2; j++) {
            arr[j*2+1] *= arr[j*2];
        }
        printArr(arr);

        //Next
        arr = genArr();
        int tmp =0;
        int k = 0;
        do{
            if(k%2==1) {
                arr[k] *= tmp;
            }
            else {
                tmp = arr[k];
            }
            k++;
        }while(k<arr.length);
        printArr(arr);

        //Next
        arr = genArr();
        int j = 0;
        while(arr.length/2>j){
            arr[j*2+1]*=arr[j*2];
            j++;
        }
        printArr(arr);
    }
    private static int[] genArr(){
        int[] arr = new int[20];
        int i = 0;
        while (arr.length>i) {
            arr[i] = i * 2;
            i++;
        }
        return arr;
    }

    private  static void printArr(int[] arr){
        for (int k:arr
        ) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}
