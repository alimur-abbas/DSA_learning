import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int arr[] = {2,2, 3, 1, 1,1,1, 6};
        int n = arr.length;
        int k = 4;
        int res = longestSubArraywithKSumPositive(arr , n , k);
        System.out.println("Max Length :"+res);


    }

    private static int longestSubArraywithKSumPositive(int[] arr, int n, int k) {
        int sum =0 , maxi =0,left =0 , right =0;
        while(right < n){

            if (sum > k){
                sum -= arr[left];
                left++;
            }
            else {
                sum += arr[right];
                if(sum == k)
                    maxi = Math.max(maxi , (right - left)+1);

                right++;
            }
//            else {
//                maxi = Math.max(maxi , (right - left)+1);
//                right++;
//            }
        }
        return maxi;
    }


    static void Frequency(int arr[], int n) {
        Map<Integer , Integer> mp = new HashMap<>();
        for(int i =0 ; i< arr.length;i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }else{
                mp.put(arr[i],mp.get(arr[i])+1);
            }
        }
        System.out.println("Map :"+mp.toString());
        int maxElement=0 , minElement = 0;
        int maxFeq = Integer.MIN_VALUE , minFreq = Integer.MAX_VALUE;
        for (int a: mp.keySet()) {

            if(mp.get(a) > maxFeq) {
                maxElement = a;
                maxFeq = mp.get(a);
            }
            if(mp.get(a) < minFreq) {
                minElement = a;
                minFreq = mp.get(a);
            }
        }
        System.out.println("Max Element :"+maxElement);
        System.out.println("Min Element :"+minElement);
    }
}