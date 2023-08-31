package BinarySearch.OneD;

public class Tuf {
    public static void main(String[] args) {
        int arr[] = { 1,2,3,6, 5,4,9};
        int n = arr.length;
        System.out.println(peak(arr , n ));

    }
    public static int bsIterative(int arr[] , int n, int target){
        int low = 0 , high = n-1;
        while(low <= high){
            int mid = low + (high- low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }

        return -1;
    }
    public static int bsRecursive(int arr[] ,int low,  int high , int target){
        // base
        if(low > high ) return -1;

        int mid = low + (high- low)/2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] < target)
            return bsRecursive(arr , mid+1 ,high , target);
        else
            return bsRecursive(arr , low , mid-1, target);


    }
    public static int lowerBound(int arr[] , int n ,int target){
        int low = 0 , high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }
    public static int upperBound(int arr[] , int n ,int target){
        int low = 0 , high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }
    public static int searchInsert(int arr[] , int n ,int target){
        int low = 0 , high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }
    public static void printFloorAndCeilOfTarget(int arr[] , int n , int target){
        // Edges Cases needs to be handle as per requirement
        int low = 0, high = n-1 , floor = 0 , ceil =0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
               floor = arr[mid];
               ceil = arr[mid];
               break;
            }
            else if(arr[mid] > target){
                floor = arr[mid-1];
                ceil = arr[mid];
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        System.out.println("Floor :"+ floor);
        System.out.println("Ceil :"+ ceil);
    }
    public static int firstOccurence(int arr[] , int n , int target){
        int low =0 ,  high = n-1 , ans =-1;
        while(low<= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid -1;
            }
            else if(arr[mid] > target)
                high = mid -1;
            else
                low = mid +1;
        }
        return ans;
    }

    public static int lastOccurence(int arr[] , int n , int target){
        int low =0 ,  high = n-1 , ans =-1;
        while(low<= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid +1;
            }
            else if(arr[mid] > target)
                high = mid -1;
            else
                low = mid +1;
        }
        return ans;
    }
    public static int countOccurence(int arr[] , int n , int target){
        int first = firstOccurence(arr , n , target);
        int last = lastOccurence(arr , n , target);
        return (last-first)+1;
    }

    public static int searchInRotatedArray(int arr[] , int n , int target){
        //4, 5, 1,2,3
        // find the pivot or the point of rotation arr[i] > arr[i+1]
        // if the array is not rotated then it will take O(n)
        int ans = -1;
        for(int i =0 ; i < n-1;i++){
            if(arr[i] > arr[i+1]) {
                if (arr[0] <= target && target <= arr[i]) {
                    ans = search(arr, 0, i, target);
                } else {
                    ans = search(arr, i+1, n - 1, target);
                }
                break;
            }
        }
        return ans;
    }

    public static int searchInRotatedArrayBS(int arr[] , int n , int target) {
        //4,5,1,2,3
        // if we take any element and look at left and right of it either of the side is sorted.
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                   high = mid -1;
                }else{
                    //left part is sorted but target is not in its range , so we ignore left half
                    low = mid+1;
                }
            }else{
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
        // there is a special edge case when it will fail [3, 1,2,3,3,3,3]
        // when low , high and mid has same element
    }

    public static int search(int[] arr, int low, int high, int target) {
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid -1;
            else low = mid+1;
        }
        return -1;
    }

    public static int minimumInRotatedSortedArray(int arr[] , int n){
        int low = 0 , high = n-1 , mini = Integer.MAX_VALUE;
        if(arr[low] < arr[high]) return arr[low];
        while(low<= high){
            int mid = low+(high - low)/2;
            if(arr[low] <= arr[mid]){
               mini = Math.min(mini , arr[low]);
               low = mid+1;
            }else{
                mini = Math.min(mini , arr[mid]);
                high = mid -1;
            }
        }
        return mini;
    }

    public static int numberOfTimesArrayIsRotated(int arr[] , int n){
        // Index of minimum element is number of times array is rotated.
        int low = 0 , high = n-1 , mini = Integer.MAX_VALUE, miniIndex = -1;
        if(arr[low] < arr[high]) return arr[low];
        while(low<= high){
            int mid = low+(high - low)/2;
            if(arr[low] <= arr[mid]){
                if(arr[low] < mini){
                    mini = arr[low];
                    miniIndex = low;
                }
                low = mid+1;
            }else{
                if(arr[mid] < mini){
                    mini = arr[mid];
                    miniIndex = mid;
                }
                high = mid -1;
            }
        }
        return miniIndex;
    }

    public static int singleElementInArrayUsingBS(int arr[] , int n){
        int low =1,high = n-2;
        if(n == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1] ) return arr[mid];
            else if ((mid >> 1 == 0 && arr[mid] == arr[mid+1]) ||(mid >>1 == 1 && arr[mid] == arr[mid-1]))
                low = mid +1;
            else
                high = mid -1;
        }
        return Integer.MIN_VALUE;
    }

    public static int peak(int arr[] , int n){
        int low =1, high = n-2;
        if(n == 1) return arr[0];
        if(arr[0] > arr[1]) return arr[0];
        if(arr[n-1] > arr[n-2]) return arr[n-1];
        while (low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            else if (arr[mid] > arr[mid -1])
                low = mid +1;
            else
                high = mid -1;
        }
        return -1;
    }


}
