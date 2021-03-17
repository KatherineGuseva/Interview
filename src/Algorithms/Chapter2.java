package Algorithms;

public class Chapter2 {


    public static void test (){

        System.out.println("THis is for test");
    }

    public static int[] insertSort(int[] arr){

        for (int j=1; j<arr.length; j++){
            int elem = arr[j];
            int i=j-1;
            while (i>=0 && arr[i]>elem){
                arr[i+1]=arr[i];
                i=i-1;
            }
            arr[i+1]=elem;
        }
        return arr;

    }


    public static void mergeSort(int[] arr, int f, int l){

        if (f<l){
            int middle = (l+f)/2;
            mergeSort(arr,f,middle);
            mergeSort(arr,middle+1,l);
            merge(arr,f,middle,l);
        }

    }

    public static void merge(int[] arr, int f, int m, int l){

        int[] newArr = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }

        int i=f,k =f;
        int j=m+1;

        while (i<=m && j<=l){

            if (newArr[i]<newArr[j]){
                arr[k]=newArr[i];
                i++;
            }else {
                arr[k]=newArr[j];
                j++;
            }
            k++;
        }

        while(i<=m){
            arr[k]=newArr[i];
            i++;
            k++;
        }

        while(j<=m){
            arr[k]=newArr[j];
            j++;
            k++;
        }
    }

    public static int getMin(int[] arr, int f){
        int minInd=f;
        int minElem=arr[minInd];
        for(int i=f; i<arr.length; i++){
            if(minElem>arr[i]){
                minInd=i;
                minElem=arr[minInd];
            }
        }
        return minInd;
    }

    public static void sortMin(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int ind=getMin(arr,i);
            int temp = arr[i];
            arr[i]=arr[ind];
            arr[ind]=temp;
        }

    }
}
