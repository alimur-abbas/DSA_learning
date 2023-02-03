package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnArray {
    public static void main(String[] args) {
        int arr [] = new int[]{2,7,12,13};
        twoNumberSum(arr, 9);
    }
    public static  void  twoNumberSum(int arr[] , int target){
        int res [] = new int[2];
        Map<Integer, Integer > map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }


        for(int i =0 ; i< arr.length; i++){
            int remain = target - arr[i];
            if(map.containsKey(remain)) {
                int index = map.get(remain);
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        String s =Arrays.toString(res);
        System.out.println(s);
    }
}
