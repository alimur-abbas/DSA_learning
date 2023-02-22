package Array;

public class Revision {
    public static void main(String[] args) {
       int arr [] = {7,9,1,2,3};


        System.out.println("Pivot Value index is: "+Pivot(arr));
    }
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void intersectionOfTwoArrayWithoutCollection(int arr1[] , int arr2[]){
        //Hint :- Both the array are sorted in ascending order
        int i =0 ,j = 0;
        while(i < arr1.length && j < arr2.length){
           if(arr1[i] > arr2[j]) j++;
           else if (arr1[i] < arr2[j]) i++;
           else {
               System.out.print(arr1[i]+" ");
               i++;
               j++;
           }
        }
        System.out.println();
    }

    public static void sortArrayOfZeroAndOne(int arr []){
        int i = 0 , j = arr.length-1;
        while(i <= j){
            if(arr[i] == 0) i++;
            else if(arr[j] == 1) j--;
            else {
                arr[i] -= 1;     //arr[i] ^= 1;
                arr[j] += 1;     // arr[j] ^=1;
            }
        }
        printArray(arr , arr.length);
    }

    public static void sortArrayOfZeroOneAndTwo(int arr []){
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0 ;
        while(mid <= hi){
            switch (arr[mid]){
                // swap from left side
                case 0 :
                  arr[mid] = arr[lo];
                  arr[lo] = 0;
                  lo++;
                  break;
                  // In this case just increase mid
                case 1 :
                    mid++;
                    break;
                case 2 :
                    arr[mid] = arr[hi];
                    arr[hi] = 2;
                    hi--;
                    break;
            }

        }
        printArray(arr , arr.length);


    }

    public static int firstOccurence(int arr [] , int key){
        int s = 0  , e = arr.length-1;
        int mid = 0 , ans = 0;
        while(s <= e){
            mid = s + (e -s)/2;
            if(arr[mid] == key ){
                ans = mid;
                e = mid -1;
            } else if (arr[mid] > key) {
               e = mid -1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }

    public static int LastOccurence(int arr [] , int key){
        int s = 0  , e = arr.length-1;
        int mid = 0 , ans = 0;
        while(s <= e){
            mid = s + (e -s)/2;
            if(arr[mid] == key ){
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] > key) {
                e = mid -1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }


    public static int peakValue (int arr []){
        int s = 0 , e = arr.length-1;
        int mid = 0;
        while(s < e){
            mid = s + (e -s)/2;
            if (arr[mid] < arr[mid+1]) s = mid+1;
            else e = mid;
        }
        return s;
    }
    public static int Pivot (int arr []){
        int s = 0 , e = arr.length-1;
        int mid = 0;
        while(s < e){
            mid = s + (e -s)/2;
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            }
            else e = mid;
        }
        return s;
    }
}
