package Array;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PrintAnArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,4};
        int arr2[] = new int[]{2,5,6};

        compress();
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void twoNumberSum(int arr[], int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }


        for (int i = 0; i < arr.length; i++) {
            int remain = target - arr[i];
            if (map.containsKey(remain)) {
                int index = map.get(remain);
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        String s = Arrays.toString(res);
        System.out.println(s);
    }

    public static void reverseArray(int arr[], int size) {
        int end = size - 1;
        int swap = 0;
        for (int i = 0; i < size / 2; i++) {
            swap = arr[end];
            arr[end] = arr[i];
            arr[i] = swap;
            end--;
        }
        // System.out.println(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(" value : " + arr[i]);
        }
    }

    public static void secondMaxNumberWithoutSorting(int arr[], int len) {
        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
        }
        System.out.println("Second Max is :" + secondMax);
        System.out.println(" Max is :" + max);
    }

    public static void swapAlternate(int arr[], int n) {


        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n) {
                arr[i] = arr[i + 1] + arr[i];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
            }
        }
        printArray(arr, n);
    }

    public static void findUnique(int arr[], int n) {
        printArray(arr, n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        System.out.println("Unique Element is :" + ans);
    }

    public static boolean uniqueNumberOfOccurence(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Integer> unique = new HashSet<>();
        for (int i : map.values()) {
            if (unique.contains(i)) {
                return false;
            } else {
                unique.add(i);
            }
        }
        return true;

    }

    public static int duplicate(int arr[], int n) {
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (unique.contains(arr[i])) return arr[i];
            else unique.add(arr[i]);
        }
        return 0;
    }

    public static Set<Integer> duplicateAll(int arr[], int n) {
        Set<Integer> unique = new HashSet<>();
        Set<Integer> allDuplicate = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (unique.contains(arr[i])) allDuplicate.add(arr[i]);
            else unique.add(arr[i]);
        }
        return allDuplicate;
    }

    public static void intersectionOfTwoArray(int arr1[], int arr2[]) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> setOfArr2 = new HashSet<>();
        //putting unique values of arr1 in set
//        for (int i = 0; i < arr1.length; i++) {
//            setOfArr1.add(arr1[i]);
//        }
        // putting all the unique values of arr2 in set
        for (int i = 0; i < arr2.length; i++) {
            setOfArr2.add(arr2[i]);
        }
        //System.out.println(setOfArr1);
        System.out.println(setOfArr2);
        for (int i = 0; i < arr1.length; i++) {
            if (setOfArr2.contains(arr1[i])) result.add(arr1[i]);
        }
        System.out.println(result);
    }

    public static void intersectionWithoutCollection(int arr1[], int arr2[]) {
        //hint both the array are sorted in ascending order
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) i++;
            else j++;
        }
    }

    public static void pairSumOfTwo(int arr[], int target) {
        Set<Integer> allUniqueElement = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            allUniqueElement.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            // second condition remove similar element such as 3 3
            if (allUniqueElement.contains(target - arr[i]) && arr[i] != (target - arr[i])) {
                System.out.println(arr[i] + " " + (target - arr[i]));
                //remove 5 1 when we have 1 5
                allUniqueElement.remove(arr[i]);
            }
        }

    }

    public static void tripletSum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> s = new HashSet<>();
            int semiTarget = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (s.contains(semiTarget - arr[j]))
                    System.out.println("Triplet is -> " + arr[i] + " " + (semiTarget - arr[j]) + " " + arr[j]);
                s.add(arr[j]);
            }

        }


    }

    public static void sortArrayOf0And1(int arr[], int n) {
        printArray(arr, n);
        int i = 0, j = n - 1;
        while (i <= j) {
            if (arr[i] == 0) i++;
            else if (arr[j] == 1) j--;
            else {
                arr[i] = arr[i] ^ 1;
                arr[j] = arr[j] ^ 1;
                i++;
                j--;
            }
        }
        printArray(arr, n);
    }

    public static void sortArrayOf01And2(int a[]) {

        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                // If the element is 0
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                   // mid++;
                    break;
                }
                // If the element is 1
                case 1:
                    mid++;
                    break;
                // If the element is 2
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
        printArray(a ,a.length);
    }
    public static int binarySearch(int arr [] , int size , int key){
        int start = 0 , end = size - 1;

        while (start <= end){
            //System.out.println(arr[mid]);
//            int mid = (start + end) / 2; // it can result into some value out of integer range
//            so we can use this to avoid above error
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
               return mid;
            }
            else{
                // move to left side
                if(arr[mid] >= key ){
                    end = mid - 1;
                    //System.out.println("End Changed to "+end);
                }
                // move to right side
                else {
                    start = mid + 1;
                    //System.out.println("Start Changed to "+start);
                }
            }
          //  mid = (start + end) / 2;
        }
        return -1;
    }
    public static int firstOccuUSingBS(int arr [] , int size , int key){
        int start = 0 , end = size - 1 , ans =-1;
        // why ans is -1 because if no match is found it will return -1

        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                ans = mid;
                end = mid - 1;
            }
            else{
                // move to left side
                if(arr[mid] >= key ){
                    end = mid - 1;
                    //System.out.println("End Changed to "+end);
                }
                // move to right side
                else {
                    start = mid + 1;
                    //System.out.println("Start Changed to "+start);
                }
            }
            //  mid = (start + end) / 2;
        }
        return ans;
    }
    public static int lastOccuUSingBS(int arr [] , int size , int key){
        int start = 0 , end = size - 1 , ans =-1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                ans = mid;
                start = mid + 1;
            }
            else{
                // move to left side
                if(arr[mid] >= key ){
                    end = mid - 1;
                    //System.out.println("End Changed to "+end);
                }
                // move to right side
                else {
                    start = mid + 1;
                    //System.out.println("Start Changed to "+start);
                }
            }
            //  mid = (start + end) / 2;
        }
        return ans;
    }
    public static  int peakOfMountainArray(int arr [] , int size){
        int s = 0 , e = size - 1 ;
        while(s<e) {
            int m = s + (e - s) / 2;
            if (arr[m] < arr[m+1]) s = m + 1;
            else e = m;
        }
        return  s;
    }
    public static  int getPivotSmallest(int arr [] , int size){
        int s = 0 , e = size - 1 ;
        while(s<e) {
            int m = s + (e - s) / 2;
            if (arr[m] >= arr[0]) s = m + 1;
            else e = m;
        }
        return  s;
    }

    public static  int getPivotLargest(int arr [] , int size){
        int s = 0 , e = size - 1 ;
        while(s<e) {
            int m = s + (e - s) / 2;
           if (arr[m] >= arr[0]) {
                if(m == 0) s = m+1;// this extra if condition is required only to avoid infinite loop
                else
                s = m;
            }
            else e = m-1;
//            if(arr[m] <= arr[size-1]) e = m - 1;
//            else s = m;
        }
        return  arr[s];
    }

    public static  int searchInRotatedSortedArray(int arr [] , int size , int k){
        int pivot = getPivotSmallest(arr , size);
        System.out.println("pivot is "+ pivot);
        int result = 0  ;
        if(arr[pivot] <= k && k <= arr[size-1])
         result =   binarySearch(arr , pivot , size-1 ,k);
        else
            result =   binarySearch(arr , 0 , pivot-1 ,k);
        return result;
    }
    public static int binarySearch(int arr [] , int s , int e , int key){
        int start = s , end = e;

        while (start <= end){
            //System.out.println(arr[mid]);
//            int mid = (start + end) / 2; // it can result into some value out of integer range
//            so we can use this to avoid above error
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                return mid;
            }
            else{
                // move to left side
                if(arr[mid] >= key ){
                    end = mid - 1;
                    //System.out.println("End Changed to "+end);
                }
                // move to right side
                else {
                    start = mid + 1;
                    //System.out.println("Start Changed to "+start);
                }
            }
            //  mid = (start + end) / 2;
        }
        return -1;
    }

    public static long squareRoot(int n) {
        long start = 0, end = n;
        long mid = 0;
        long ans = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long square = mid * mid;
            if (square == n) {
                return mid;
            } else if (square < n) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;

        }
        return ans;
    }

    public static double morePrecision(int n  , long temSol , int precision){
        double fact = 1;
        double ans = temSol;
        for (int i = 0; i < precision; i++) {
            fact /= 10;
            for (double j = ans; j*j < n; j=j+fact) {

                ans = j;
                System.out.println(ans);
                System.out.println("J value "+j);
            }
        }
        return ans;
    }

    public static boolean isPossible(int arr[] , int n , int m , int mid){
        int student = 1;
        int pageSum = 0;
        for (int i = 0; i < n; i++) {
            if(pageSum+arr[i] <= mid){
                pageSum += arr[i];
            }
            else{
                student++;
                if(student > m || arr[i] > mid) return false;
                else pageSum = arr[i];
            }
        }
        return true;
    }

    public static int bookAllocate(int arr[] , int numberOfBooks  , int numberOfStudent ){
        int s = 0; int sum = 0 , ans = -1 ;
        for (int i = 0; i < numberOfBooks; i++) {
            sum += arr[i];
        }
        int mid =0;
        int e = sum;
        while (s<=e){
            mid = s+(e-s)/2;
            if(isPossible(arr , numberOfBooks , numberOfStudent , mid)){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }


    public static boolean isPossibleAggresiveCow(int arr[] , int n , int m , int mid) {
        int cow = 1;
        int lastPos = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] - lastPos >= mid) {
                cow++;
                if (cow == m) return true;
                lastPos = arr[i];
            }
        }
        return false;
    }


    public static int aggresiveCow(int arr[] , int numberOfStalls  , int numberOfCows ){
        int s = 0; int ans = -1 ;
        Arrays.sort(arr);
//        int maxi = Integer.MIN_VALUE;
//        int mini = Integer.MAX_VALUE;
//        for (int i = 0; i < numberOfStalls; i++) {
//            if(arr[i] > maxi) maxi += arr[i];
//
//            if(arr[i] < mini ) mini += arr[i];
//
//        }
        s = arr[0];
        int mid =0;
        int e = arr[numberOfStalls - 1] - s;
        while (s<=e){
            mid = s+(e-s)/2;
            if(isPossibleAggresiveCow(arr , numberOfStalls , numberOfCows , mid)){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;
    }


    public static void selectionSort(int arr []){
        int temp = 0 , minIndex = 0;
        for (int i = 0; i < arr.length-1; i++) {
                minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                // suppose say arr[i] = 5 and arr[j] = 4 then it will swap moving forward now arr[j] = 2 then again it will swap which is not good pratice
//                if(arr[j] < arr [i])
//                {
//                  temp = arr[i];
//                  arr[i] = arr[j];
//                  arr[j] = temp;
//                }
                // store the index of the min value and then swap for once
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
           if(arr[minIndex] != arr[i]){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
        printArray(arr , arr.length);
    }

    public static void bubbleSort(int arr []){
        int n = arr.length , temp = 0;
        boolean swapped = false;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) break;
        }
        printArray(arr , n);
    }
    public static  void insertionSort(int arr []){
        for(int i = 1 ; i < arr.length ; i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0){
                if(arr[j] > temp) arr[j+1] = arr[j];
                else break;
                j--;
            }
            arr[j+1] = temp;
        }
        printArray(arr , arr.length);
    }

    public static void mergeTwoSortedArray(int arr1 [] , int arr2 []){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0 , j = 0 ,index = 0;
        int arr3 [] = new int[n+m];
        while(i < n && j < m){
            if(arr1[i] < arr2[j])
                arr3[index++] = arr1[i++];
            else
                arr3[index++] = arr2[j++];
        }
        while(i < n)
            arr3[index++] = arr1[i++];
        while (j < m)
            arr3[index++] = arr2[j++];
        printArray(arr3 , arr3.length);

        // T.C = O(n)
        // S.C = O(N+M)
    }

    public static void mergeTwoSortedArrayIntoOne(int arr1 [] , int arr2 []){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0 , j = 0;
            while(i < n ){
                if(arr1[i] == 0)
                    break;


               if(arr1[i] < arr2[j])
                   i++;
               else{
                   int temp = arr1[i];
                   arr1[i++] = arr2[j];
                   arr2[j] = temp;
               }


            }
            while(i < n){
                arr1[i++] = arr2[j++];
            }
            printArray(arr1 , arr1.length);
            // T.C = O(N)
            //S.C = O(1)

    }

    public static void moveZeroes(int arr []){
        for(int j = 0 , i = 0; j < arr.length; j++){
            if (arr[j] != 0){
                int temp = arr [i];
                arr[i++] = arr[j];
                arr[j] = temp;

            }
        }
        printArray(arr , arr.length);
        // above logic can be used to sort the Array of 0 And 1 change if condition as == 0
// This logic don't preserve the position of the elements
//    int n = arr.length;
//        int i = 0, j = n - 1;
//        while (i <= j) {
//            if (arr[i] != 0) i++;
//            else if (arr[j] == 0) j--;
//            else {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        printArray(arr , arr.length);
 }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int temp [] = new int [n];
        for(int i = 0; i < n; i++ ){
            temp[(i+k)%n] = nums[i];
        }
        // copy the array
        nums = temp.clone();
        printArray(nums , nums.length);

    }


    public static void rotate1(int[] nums, int k) {

        int rotation = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, rotation-1);
        rotate(nums, rotation, nums.length - 1);

        printArray(nums, nums.length);
    }
    private static void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean checkSortedRotated(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n; i++  ) {
            if(nums[i-1] > nums[i]) count++;
        }
        if(nums[n-1] > nums[0]) count++;
        return count <= 1;
    }

    public static void sumOfTwoArray(int arr [] , int arr1 []){
        int i = arr.length - 1;
        int j = arr1.length - 1;
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        while(i >= 0 && j >= 0){
            int sum = arr[i]+arr1[j]+carry;
            int digit = sum % 10;
            carry = sum / 10;
           ans.add(digit);
            i--;
            j--;
        }
        while(j >= 0) {
            int sum = arr1[j]+carry;
            int digit = sum % 10;
            carry = sum / 10;
            ans.add(digit);

            j--;
        }
        while(i >= 0)
        {
            int sum = arr[i]+carry;
            int digit = sum % 10;
            carry = sum / 10;
            ans.add(digit);

            i--;
        }
        if(carry !=0) ans.add(carry);
       Collections.reverse(ans);

        System.out.println(ans);
    }


    public  static String removeOccurrences() {

        String s = "aabababa";
        String part = "aba";
        while(s.contains(part)){
            s = s.replace(part ,"");
        }
        return s;
    }

    public static String removeDuplicates() {
        String s = "abbaca";
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(st.isEmpty()){
                st.push(curr);
            }

            else if(st.peek() == curr){
                st.pop();
            }else{
                st.push(curr);
            }

        }
        String n = "";
        while(!st.isEmpty()){
            n =st.pop()+ n  ;
        }
        System.out.println(n);
        return n;
    }

    public static int compress() {
        char[] chars = {'a','a','c','c','c','c','c','c','c','c','c', 'c','c','c'};
        int count = 0;
        int len = chars.length;
        char prev = 0;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < len ; i++ ) {
            if (s.length() == 0) {
                s.append(chars[i]);
                prev = chars[i];
                count++;
            } else if (prev == chars[i] ) {
                count++;
            } else {
                prev = chars[i];
                if (count > 1) {
                    s.append(count);
                    s.append(chars[i]);
                    count = 1;
                }
            }
            if(i+1 == len && count > 1) s.append(count);
        }
        System.out.println(s.toString());
        return s.length();

    }

}

