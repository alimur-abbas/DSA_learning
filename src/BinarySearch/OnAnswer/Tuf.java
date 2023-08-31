package BinarySearch.OnAnswer;

import java.util.Arrays;
import java.util.Collections;

public class Tuf {
    public static void main(String[] args) {
        int arr[] = {2,4,6,9};
        int arr1[] = {1,3,5};
        int n = arr.length;
        System.out.println(KthElementOF2SortedArray(arr ,arr1, 3));

    }

    public static int squareRoot(int num) {
        int low = 1 , high = num/2;
        while(low<= high){
            int mid = low+(high-low)/2;
            int sqr = mid * mid;
            if(sqr == num) return mid;
            else if(sqr > num) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
    public static int nthRoot(int num , int root){
        int low = 1 , high = num;
        while(low<= high){
            int mid = low+(high - low)/2;
            double val = Math.pow((double) mid,(double) root);
            if(num == (int)val) return mid;
            else if((int)val > num) high = mid -1;
            else low = mid+1;

        }
        return -1;
    }

    public static int kokoEatingBanana(int arr[] , int n , int h){
        int low = 1 , high = findMax(arr , n), ans =0;
        while(low<= high){
            int mid = low+(high-low)/2;
            int val = calculatedHours(arr , n , mid);
            if(val<= h){
               ans = mid;
               high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int roseGarden(int arr[] ,int n, int m , int k ){
        int numberOfRequiredRoses = m*k;
        if(numberOfRequiredRoses > n) return -1;
        int low = findMin(arr , n), high = findMax(arr , n), ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(possible(arr , n, mid , m ,k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int smallestDivisor(int arr[] , int n, int limit){
        int low = 1 , high = findMax(arr ,n), ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int sum = sumAfterDivision(arr , n, mid);
            if(sum <= limit){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
       return ans;
    }

    public static int shippmentOfGoods(int arr[], int n, int day){
        int low = findMax(arr , n) , high = findSum(arr , n);
        while(low <= high){
            int mid = low+(high-low)/2;
            if(check(arr , n, mid) <= day){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int kthMissingNumberBF(int arr[] , int n , int k){
        for (int i = 0; i < n; i++) {
           if(arr[i] <= k) k++;
           else break;
        }
        return k;
    }

    public static int kthMissingNumberBS(int arr[] , int n , int k){
       int low = 0, high = n-1;
       while(low <= high){
           int mid = low+(high-low)/2;
           //check while reaching upto mid how much element u have missed
           int missed = arr[mid] - (mid+1);
           if(missed < k){
             low = mid+1;
           }
           else high = mid -1;

       }
       return k+high+1;
    }

    public static int aggressiveCow(int arr[] , int n, int cows){
        Arrays.sort(arr);
        int low = 1, high = arr[n-1]- low;

        while(low<= high){
            int mid = low+(high-low)/2;
            if(solution(arr,n, cows,mid)){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return high;
    }

    public static int bookAllocation(int arr[], int n, int students){
        int low = findMax(arr, n), high = findSum(arr, n);
        while(low<= high){
            int mid = low+(high-low)/2;
            if(isAnswer(arr , n, students, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int splitArray(int arr[],int n, int k){
        int low = findMax(arr , n), high = findSum(arr, n);
        while(low <= high){
            int mid = low+(high-low)/2;
            if(validate(arr , n, k , mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int paritionPainter(int arr[] , int n , int painter){
        int low = arr[n-1], high = findSum(arr , n);
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isSolution(arr, n , painter, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }


    public static double medianOf2SortedArray(int a[] , int b[]){
        int n1 = a.length , n2 = b.length, n = n1 + n2;
        int low = 0 , high = n1-1;
        int numberOfElementInLeft = (n1+n2+1)/2;
        while(low <= high){
            int cut1 = low+(high-low)/2;
            int cut2 = numberOfElementInLeft-cut1;
            int l1 = (cut1 > 0)? a[cut1-1]:Integer.MIN_VALUE;
            int l2 = (cut2 > 0)? b[cut2-1]:Integer.MIN_VALUE;
            int r1 = (cut1 < n1)? a[cut1]:Integer.MAX_VALUE;
            int r2 = (cut2 < n2)? b[cut2]:Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if((n & 1) !=0 ) return Math.max(l1,l2);
                else return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
            }else{
                if(l1 > r2) high = cut1 -1;
                else low = cut1+1;
            }
        }
        return -1;
    }

    public static double KthElementOF2SortedArray(int a[] , int b[], int k){
        int n1 = a.length , n2 = b.length, n = n1 + n2;
        if(n1 > n2) return KthElementOF2SortedArray(b ,a, k);
        //IMPORTANT
        int low = Math.max(0, k-n2);
        int high = Math.min(n1 , k);

        while(low <= high){
            int cut1 = low+(high-low)/2;
            int cut2 = k-cut1;
            int l1 = (cut1 > 0)? a[cut1-1]:Integer.MIN_VALUE;
            int l2 = (cut2 > 0)? b[cut2-1]:Integer.MIN_VALUE;
            int r1 = (cut1 < n1)? a[cut1]:Integer.MAX_VALUE;
            int r2 = (cut2 < n2)? b[cut2]:Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                 return Math.max(l1,l2);

            }else{
                if(l1 > r2) high = cut1 -1;
                else low = cut1+1;
            }
        }
        return -1;
    }

    public static double gasStation(int arr[] , int n , int k){
        double low = 0 ,high = findMaxSectionLength(arr,n );
        while(low <= high){
            double mid = low+(high-low)/2;
            int temp = neededGasStation(arr, n,mid);
            if (temp > k){
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return high;
    }

    private static int neededGasStation(int[] arr, int n, double mid) {
        int count = 0;
        for (int i = 0; i < n-1; i++) {
           int numberOfRequiredGasStation = (int)(arr[i+1]- arr[i] / mid);
           // Edge case if mid completely divide the section length.
           if(arr[i+1]-arr[i] % mid == 0) {
               numberOfRequiredGasStation--;
           }
           count += numberOfRequiredGasStation;
        }
        return count;
    }

    private static double findMaxSectionLength(int arr[] , int n){
        double dis = 0;
        for (int i = 0; i < n-1; i++) {
            dis = Math.max(dis , arr[i+1]-arr[i]);
        }
        return dis;
    }

    private static boolean isSolution(int[] arr, int n, int painter, int mid) {
        int count = 1, time = 0;
        for (int i = 0; i < n; i++) {
            if(time+arr[i] > mid){
                count++;
                time = arr[i];
            }else{
                time += arr[i];
            }
        }
        if(count <= painter) return true;
        return false;
    }

    private static boolean validate(int[] arr, int n, int k, int mid) {
        int subArray =1,sum =0;
        for (int i = 0; i < n; i++) {
            if(sum+arr[i] > mid){
                subArray++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        if(subArray > k) return true;
        return false;
    }

    private static boolean isAnswer(int[] arr, int n, int students, int mid) {
        int count = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]+pages > mid){
                count++;
                pages = arr[i];
            }else{
                pages += arr[i];
            }
        }
        if(count <= students) return true;
        return false;
    }

    private static boolean solution(int[] arr, int n, int cows,int mid) {
        int placedCow = 1, previous = arr[0] ;
        for (int i = 1; i < n; i++) {
            if(arr[i]-previous >= mid){
                placedCow++;
                previous = arr[i];
            }
        }
        if(placedCow >= cows) return true;
        return false;
    }

    private static int check(int[] arr, int n, int cap ) {
        int load = 0, days = 1;
        for (int i = 0; i < n; i++) {
            if(load+arr[i] <= cap) load += arr[i];
            else{
                days++;
                load=arr[i];
            }

        }
        return days;

    }

    private static int sumAfterDivision(int[] arr, int n, int mid) {
        int sum =0;
        for(int i=0; i<n;i++)
            sum += Math.ceil((double) arr[i] / (double) mid);
        return sum;
    }

    private static boolean possible(int[] arr, int n, int mid, int m, int k) {
        int count = 0, noOfB = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= mid){
                count++;
            }else{
                // here we can write if count == k then noOfB++ , but this is optimize way.
                noOfB += count/k;
                count =0;
            }
        }
        // once the loop is ended count will be holding some value , that also needs to be checked.
        noOfB += count/k;
        return noOfB >= m;
    }

    private static int calculatedHours(int[] arr, int n, int mid) {
        int hours = 0;
        for (int i = 0; i < n; i++) {
           hours += Math.ceil((double) arr[i] / (double) mid);
        }
        return hours;
    }





    private static int findMax(int[] arr, int n) {
        int ans = Integer.MIN_VALUE;
        for(int i =0; i< n ; i++){
           ans = Math.max(arr[i], ans);
        }
        return ans;
    }
    private static int findMin(int[] arr, int n) {
        int ans = Integer.MAX_VALUE;
        for(int i =0; i< n ; i++){
            ans = Math.min(arr[i], ans);
        }
        return ans;
    }
    private static int findSum(int arr[] , int n){
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
