package BasicRecursion;

import java.util.Arrays;

public class Tuf {
   static int sum = 0;
    public static void main(String[] args) {
        int n = 3;
        int arr [] = {1, 2, 3, 1 ,5};
        int len = arr.length;
        frequency(arr , len);
       // fibo(n);
        //printArray(arr , len);
        //printNTo1(n);
        //System.out.println(fibo(n));
    }
    private static void frequency(int arr[] , int n){
        int res[] = new int [n+1];
        Arrays.fill(res , 0);
        for(int i =0 ; i<n; i++){
            res[arr[i]]++;
        }
        printArray(res , n);

    }

    private static int fibo(int n) {
        if(n <= 1) return n;
        int slast = fibo(n-1);
        int last = fibo(n-2);
        return last+slast;
    }

    private static void reverse(int[] arr, int start ,int end) {
        if ( start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            reverse(arr ,start , end );
        }

    }

    private static void printArray(int arr[] ,int n){
        for(int i =0; i< n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //parametrized way
    private static Integer SumOfFirstN(int n) {
        if(n<1) return 0 ;
        sum += n;
        SumOfFirstN(--n);
        return sum;

    }
    //functional way
    private static Integer SumOfFirstNF(int n) {
        if(n<1) return 0 ;
        return n+SumOfFirstN(--n);

    }

    private static void printNTo1(int n) {
        if(n < 1) return;
        System.out.println(n);
        // if using increment or decrement use prefix
        printNTo1(--n);
    }
}
