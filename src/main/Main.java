package main;

import Algorithms.Chapter6;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        int[] arr = new int[]{6,4,7,5,12,1,9,11,45,3,24,34};
        //int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        System.out.println("The input array");
        for(int i=0; i<arr.length; i++){
            System.out.print(String.valueOf(arr[i])+", ");
        }
        System.out.println();
        System.out.println("The output array");

        Chapter6.heapSort(arr,arr.length);
        for(int i=0; i<arr.length; i++){
            System.out.print(String.valueOf(arr[i])+", ");
        }
    }
}
