package BinarySearch;

public class Tuf {
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 12, 18, 20, 22};
        int n = arr.length;
        // System.out.println(majority(arr , n));
        printFloorAndCeilOfTarget(arr, n, 21);

    }

    private static void printFloorAndCeilOfTarget(int arr[], int n, int k) {
        int s = 0, e = n - 1, floor = 0, ceil = 0;
        if (arr[0] > k || k > arr[n - 1]) {
            System.out.println("Floor :" + floor);
            System.out.println("Ceil :" + ceil);
            return;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= k) {
                if (arr[mid] == k) {
                    floor = arr[mid];
                    ceil = arr[mid];
                    break;
                } else {
                    floor = arr[mid - 1];
                    ceil = arr[mid];
                    e = mid - 1;
                }
            } else {
                s = mid + 1;
            }
        }
        System.out.println("Floor :" + floor);
        System.out.println("Ceil :" + ceil);

    }
}
