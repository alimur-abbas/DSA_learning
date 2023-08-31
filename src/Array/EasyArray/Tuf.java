package Array.EasyArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tuf {
    public static void main(String[] args) {
        int arr [] = {1,1, 2,1, 1, 4,1 , 1, 1, 0};
        int arr2 [] = {2, 3, 4, 5, 6, 7};
        int n = arr.length;
        System.out.println(longestSubArrayWithSumKUsing2Pointer(arr , n, 5 ));
        //removeDuplicate(arr ,n);
        //countMaximumConsecutiveOnes(arr , n );
    }
    private static int longestSubArrayWithSumKUsing2Pointer(int arr[] , int n, int k){
        int maxi =0 , left = 0 , right =0;
        int sum = arr[0];
        while (right < n){
           // Before adding I need to trim from left
            while (left<= right && sum > k ){
                sum -= arr[left++];
            }
            if(sum == k){
                maxi = Math.max(maxi , right-left+1);
            }
            right++; // sum[0] already added and after adding last element we need a round of processing
            if(right < n) sum+=arr[right];

        }
        return maxi;
    }
    private static int longestSubArrayWithSumK(int arr[] , int n, int k){
        int sum =0, maxi =0;
        Map<Integer , Integer> hashing = new HashMap<>();
        for(int i = 0; i< n; i++){
            sum+=arr[i];
            if(sum == k) maxi = Math.max(maxi , i+1);
            if(!hashing.containsKey(sum)){
                hashing.put(sum , i);
            }
            if(hashing.containsKey(sum-k)){
                int len = i - hashing.get(sum-k);
                maxi = Math.max(maxi , len);
            }
        }
        return maxi;
    }
    private static int countMaximumConsecutiveOnes(int arr[] , int n){
        int count =0;
        int maxi = Integer.MIN_VALUE;
        for(int i =0; i< n;i++){
            if(arr[i] == 1) count++;
            else{
                maxi = Math.max(maxi , count);
                count =0;
            }

        }
        return maxi;
    }

    private static void unionOf2SortedArray(int arr1[] , int arr2[]){
        Stack<Integer> union = new Stack<Integer>();
        System.out.println("size:"+union.size());
        System.out.println("IsEmpty?:"+union.isEmpty());
        System.out.println("union :"+union.toString());
        //System.out.println("Union :"+union.peek());
        int l1 = arr1.length, i =0;
        int l2 = arr2.length, j =0;
        while(i < l1 && j < l2){
     //   System.out.println("24 IsEmpty?:"+union.isEmpty());
           if(arr1[i] <= arr2[j]){
      //  System.out.println("26 IsEmpty?:"+union.isEmpty());
               if( union.isEmpty() || union.peek() != arr1[i]){
                   union.push(arr1[i]);

               }
               i++;// need to be out of if block weather condition match or not it need to be increased
            }else{
                if(union.isEmpty() || union.peek() != arr2[j]){
                    union.push(arr2[j]);

                }
               j++;
            }

        }
        while(i < l1){
            if( union.isEmpty() ||union.peek() != arr1[i]){
                union.push(arr1[i]);

            }
            i++;
        }
        while(j < l2){
            if( union.isEmpty() ||union.peek() != arr2[j]){
                union.push(arr2[j]);

            }
            j++;
        }
        System.out.println("Union :"+union.toString());
    }
    //order needs to be mainted
    //for Input {1 0 2 0 3 4} output - {1 2 3 4 0 0}
    //output should not be {1 4 2 3 0 0}
    private static void moveZeroToEnd(int arr [] , int n){
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1)return;
        for(int i = j+1 ; i<n;i++){
            if(arr[i] != 0) {
                swap(arr, j, i);
                j++;
            }
        }
        printArray(arr , n);

    }
//Reversal Algorithm
    private static void rotateByKposition(int[] arr, int n, int k, String value) {
        if(value.toLowerCase() == "right"){
            reverse(arr , n-k, n-1);
            reverse(arr , 0 ,n-k-1);
            reverse(arr , 0 ,n-1);
        }else{
            reverse(arr , 0 , k-1);
            reverse(arr , k ,n-1);
            reverse(arr ,0 ,n-1);
        }
        printArray(arr , n);
    }
    private static void reverse(int arr[], int start , int end){
        while(start<=end){
           swap(arr , start , end);
           start++;
           end--;
        }
    }
    static void swap(int arr[] , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int findSecondLargest(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        int slast = 0;
        for (int i = 0; i < n; i++) {
             if(arr[i] > maxi){
                 slast = maxi;
                 maxi = arr[i];
             }
             if(arr[i] > slast && arr[i] != maxi){
                 slast = arr[i];
             }
        }
        return slast;
    }
    private static boolean isSortedInAscending(int arr[] , int n){
        int start = 1;
        while(start < n){
            if(arr[start-1]> arr[start]) return false;
            start++;
        }
        return true;
    }
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
    private static void removeDuplicate(int arr[], int n){
        int i =0;
        for (int j = 0; j < n ; j++) {
            if(arr[i] != arr[j]){ // till you won't find a mismatch
                i++;
                arr[i] = arr[j];
            }
        }
        printArray(arr, i+1);
    }
}
