package Algorithms;

public class Chapter4 {


    public static void test (){

        System.out.println("This is for test");
    }


    public static int maximumSubArray(int[] arr, int f, int l){

        if (f>=l) return arr[f];
        int m=(l+f)/2;
        int leftSum = maximumSubArray(arr, f, m);
        int rightSum = maximumSubArray(arr, m+1, l);
        int crosSum = maximumCrosSub(arr,m);

        if (leftSum>rightSum && leftSum>crosSum) return leftSum;
        if (rightSum>leftSum && rightSum>crosSum) return rightSum;
        return crosSum;

    }

    public static int maximumCrosSub(int[] arr, int middle){
        int leftSide = 0;
        int rightSide = 0;

        int f=middle,l=middle+1;
        int newSum=0;
        while (f>=0){
            newSum = newSum+arr[f];
            if(newSum>leftSide){
                leftSide=newSum;
            }
            f--;
        }
        newSum=0;
        while (l<=arr.length-1){
            newSum = newSum+arr[l];
            if(newSum>rightSide){
                rightSide=newSum;
            }
            l++;
        }
        return Math.max(Math.max(rightSide,leftSide),leftSide+rightSide);
    }

    public static int maximumSubArrayBrutForce(int[] arr) {
        int maxSum = 0;

        for (int i=0; i<arr.length; i++){
            int newSum=arr[i];
            for(int j=i+1; j<arr.length; j++){
                newSum=newSum+arr[j];
                if (maxSum<newSum){
                    maxSum=newSum;
                }
            }

        }
        return maxSum;
    }

    public static int[][] matrixMultiplicationBrutForce(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = b[0].length;
        int[][] resultMatrix = new int[rows][columns];
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++)
            {
                int newElem = 0;
                for(int k=0; k<a[i].length;k++){
                    newElem=newElem+a[i][k]*b[k][j];

                }
                resultMatrix[i][j]=newElem;
            }
        }
        return resultMatrix;
    }

    //ONLY WORKS FOR SQUARE
    public static int[][] matrixMultiplicationDevideAndConq(int[][] a, int[][] b, int rowA, int colA,
                                                                    int rowB, int colB, int size) {

        int[][] resultMatrix = new int[size][size];

        if (size == 1) {
            resultMatrix[0][0] = a[rowA][colA]*b[rowB][colB];
        }else {
            int newSize = size/2;

            add(resultMatrix, matrixMultiplicationDevideAndConq(a,b,rowA,colA,rowB,colB,newSize),
                    matrixMultiplicationDevideAndConq(a,b,rowA,colA+newSize,rowB+newSize,colB,newSize),0,0);

            add(resultMatrix, matrixMultiplicationDevideAndConq(a,b,rowA,colA,rowB,colB+newSize,newSize),
                    matrixMultiplicationDevideAndConq(a,b,rowA,colA+newSize,rowB+newSize,colB+newSize,newSize),0,newSize);

            add(resultMatrix, matrixMultiplicationDevideAndConq(a,b,rowA+newSize,colA,rowB,colB,newSize),
                    matrixMultiplicationDevideAndConq(a,b,rowA+newSize,colA+newSize,rowB+newSize,colB,newSize),newSize,0);

            add(resultMatrix, matrixMultiplicationDevideAndConq(a,b,rowA+newSize,colA,rowB,colB+newSize,newSize),
                    matrixMultiplicationDevideAndConq(a,b,rowA+newSize,colA+newSize,rowB+newSize,colB+newSize,newSize),newSize,newSize);

        }



        return resultMatrix;
    }

    public static void add(int[][] c, int[][] a, int[][] b, int rowC, int colC) {

        int n = a.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                c[rowC+i][colC+j] = a[i][j]+b[i][j];
            }
        }

    }
}
