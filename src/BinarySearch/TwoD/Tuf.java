package BinarySearch.TwoD;

public class Tuf {
    public static void main(String[] args) {
        int a[][] ={{1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}};
        //[1,1,2,2,3,3,4,5,8]
        //[0,1,2,3,4,5,6,7,8]
        int n = a.length;
        int m = a[0].length;
        System.out.println(findMedianIn2DArray(a,n,m));
    }

    private static boolean searchIn2DArray(int[][] a, int n, int m, int i) {
        int low = 0, high = n*m-1;
        while(low<= high){
            int mid = low+(high-low)/2;
            // suppose mid = 5 , row = mid/col = 5/4 = 1
            // col = mid%col = 5%4 = 1  a[1][1] = 6
            // in a linear array [ 1,2,3,4,5,6,7,8,9,10,11,12] -> 5th position refers to 6
            int value = a[mid/m][mid%m]; // element value
            if(value == i){
                return true;
            } else if (value < i) {
                low = mid+1;
            }
            else {
                high = mid+1;
            }
        }
        return false;
    }


    private static int findMedianIn2DArray(int [][] a , int rows, int cols){
        // a contains odd number of element (Given), matrix is row wise sorted
//        1 4 9    [ 1 2 3 4 5 6 7 8 9]
//        2 5 6    [ 0,1,2,3,4,5,6,7,8]
//        3 8 7
        // Answer lies between 1-9
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            maxi = Math.max(maxi, a[i][cols-1]);
            mini = Math.min(mini, a[i][0]);
        }
        int low = mini , high = maxi;
        while(low <= high){
            int mid = low+(high-low)/2;
            int count =0;
            for (int i = 0; i < rows; i++) {
                count += countNumberOfElementOnLeft(a[i], cols, mid);
            }
            if (count <= (rows*cols)/2) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private static int countNumberOfElementOnLeft(int[] a,  int cols,int mid) {
        // mid is a answer don't think of this as a index.

            int low = 0 , high = cols-1;
            while(low <= high){
                int md = low+(high-low)/2;
                if(a[md] <= mid){
                    low = md+1;
                }else{
                    high = md -1;
                }
            }

        return low;

    }
}
