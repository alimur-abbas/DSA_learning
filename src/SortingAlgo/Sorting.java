package SortingAlgo;

import java.util.ArrayList;

public class Sorting {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length-1;
        //mergeS(arr ,0,n );
        quickSort(arr , 0 , n);

        printArray(arr);
    }
    private static void quickSort(int[] arr, int low , int high){
        if(low<high){
           // int mid = (low+high)/2;
            int pIndex = partitionIndexMethod(arr , low  , high);
            quickSort(arr , low , pIndex-1);
            quickSort(arr , pIndex+1 , high);
        }

    }

    private static int partitionIndexMethod(int[] arr, int low,  int high) {
        int pivot = arr[low], i = low , j= high;
        while(i<j){
            while(arr[i]<= pivot && i<high) i++;
            while(arr[j]> pivot && j > low) j--;
            if(i < j ) swap(arr , i , j);
        }
        swap(arr , low , j);
        return j ;
    }

    private static void selectionSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int mini = i;
            for (int j = i+1; j <= n; j++) {
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            swap(arr , mini , i);
        }
        printArray(arr);
    }
    private static void bubbleSort(int[] arr, int n){
        for(int i =0 ; i< n; i++){
            for(int j = 0;j < n-i;j++){
                if(arr[j] > arr[j+1]){
                   swap(arr , j , j+1);
                }
            }
        }
        printArray(arr);

    }
    private static void insertionSort(int[] arr, int n){
        for (int i = 1; i <= n; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                swap(arr , j , j-1);
                j--;
            }
        }
        printArray(arr);
    }

    private static void mergeS(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low+high)/2;
        mergeS(arr , low , mid);//left half
        mergeS(arr , mid+1 , high);//right half
        mergee(arr , low , mid , high);//merging sorted halves
    }

    private static void mergee(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low  , right = mid+1;
        //storing elements in the temporary array in a sorted manner//
        while(left <= mid && right <= high ){
            if(arr[left] <= arr[right]) temp.add( arr[left++]);
            else temp.add( arr[right++]);
        }
        // if elements on the left half are still left //
        while(left<=mid)
            temp.add( arr[left++]);
        //  if elements on the right half are still left //
        while(right<=high)
            temp.add( arr[right++]);

        // J is started from Low to map to the correct potion in the array
        //temp.get(j-low) because suppose low is 4(right side) it will not get element in 4th position of list
        //first element will be in 0 , next in 1 and so on

        // transfering all elements from temporary to arr //
        for( int j =low ; j<=high; j++){
            arr[j] = temp.get(j-low);
        }

    }
    static void swap(int arr[] , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
