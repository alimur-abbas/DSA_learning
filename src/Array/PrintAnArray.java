package Array;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PrintAnArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{1, 0, 1, 0, 0,1, 0, 0,0, 1};
        // int arr2[] = new int[]{1,2,3,5};
        //System.out.println(duplicateAll(arr ,6));
        sortArrayOf0And1(arr1 ,10);
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


}

