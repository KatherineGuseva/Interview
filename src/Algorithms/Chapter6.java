package Algorithms;

public class Chapter6 {


    public static void test (){

        System.out.println("This is for test");
    }

    public static void maxHeapify(int[] A, int index, int size){

        int largest = index;
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;

        if(leftChild<size && A[leftChild]>A[largest]){
            largest=leftChild;
        }
        if(rightChild<size && A[rightChild]>A[largest]){
            largest=rightChild;
        }
        if(largest != index){
            int temp = A[index];
            A[index]=A[largest];
            A[largest]=temp;
            maxHeapify(A,largest,size);

        }
    }

    public static void buildMaxHeap(int[] A, int n){

        int startInd = (n/2) - 1;

        for(int i=startInd; i>=0; i--){
            maxHeapify(A,i,n);
        }

    }

    public static void heapSort(int[] A, int size){

        buildMaxHeap(A,size);
        for(int i=size-1; i>0; i-- ){
            int temp=A[0];
            A[0]=A[i];
            A[i]=temp;
            size=size-1;
            maxHeapify(A,0,size);

        }

    }

}
