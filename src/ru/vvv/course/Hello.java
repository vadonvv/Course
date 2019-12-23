package ru.vvv.course;

public class Hello {
    public static void main(String[] args) {
        int[] arr = new int[20];
        int i = 0;
        while (arr.length>i) {
            arr[i] = i * 2;
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();

        for (int j = 0; j < arr.length/2; j++) {
            arr[j*2+1] *= arr[j*2];
        }

        for (int k:arr
        ) {
            System.out.print(k + " ");
        }
        System.out.println();

        System.out.println("Hello");
    }
}
