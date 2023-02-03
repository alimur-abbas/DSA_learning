package Pattern;

public class PatternQuestions {
    public static void main(String[] args) {
//        abovePattern();
//        triangle();
        pattenOneZero(5);
    }

    //    1,2,3
//    4,5,6
//    7,8,9
   /* public static void abovePattern(){
        int n = 3;
        int count = 1;
        int i = 1;
        while(i++<=n){
            int j = 1;
            while(j++<=n){
                System.out.print(count++ +" ");
            }
            System.out.println();
        }

    }*/
    public static void triangle() {
        int row = 4;
        int count = 1;
        int i = 1;
        while (i <= row) {
            int j = 1;
            while (j <= i) {
                System.out.print(count++ + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    //            1
//            2 3
//            3 4 5
//            4 5 6 7
    public static void abovePattern() {
        //commented code is for solution using one extra variable
        int n = 4;
        int row = 1;
        while (row <= n) {
            int j = 0;//j=1
            // int value = row;
            while (j < row) {//j<=row
                // System.out.print(value++ +" ");
                System.out.print(j + row + " ");
                j++;
            }
            System.out.println();
            row++;
        }
    }

    public static void pattern() {
        int n = 4, row = 1;
        while (row <= n) {
            int col = row;
            while (col >= 1) {
                System.out.print(col + " ");
                col--;
            }
            System.out.println();
            row++;
        }
    }

    //    D
//    C D
//    B C D
//    A B C D
    public static void pattern1() {
        int n = 4, row = 1;
        int no = 65;
        while (row <= n) {
            int col = 0;

            while (col < row) {

                System.out.print((char) (no + n - row + col) + " ");
                col++;
            }
            System.out.println();
            row++;
        }
    }

    public static void pattern2() {
        int n = 4, row = 1;
        //int no = 65;
        while (row <= n) {
            int space = row - 1;
            while (space > 0) {
                System.out.print(" ");
                space--;
            }
            int col = 0;

            while (col < (n - row + 1)) {

                System.out.print(row + col);
                col++;
            }
            System.out.println();
            row++;
        }
    }

    public static void pattern3() {
        int n = 5, i = 0;
        int blank = 0;
        while (i < n) {
            // print 1 triangle
            int j = 1;
            while (j <= (n - i)) {
                System.out.print(j);
                j++;
            }
            // print space
            int space = blank;
            while (space > 0) {
                System.out.print(" ");
                space--;
            }


            //print last triangle
            int k = n - i;
            while (k > 0) {
                System.out.print(k);
                k--;
            }
            System.out.println();
            i++;
            blank += 2;

        }


    }

    public static void invertedPant() {
        int n = 4, row = 1, blank = 5;
        while (row <= n) {
            int j = 1;
            while (j <= row) {
                System.out.print(j);
                j++;
            }
            int space = blank;
            while (space > 0) {
                System.out.print(" ");
                space--;
            }
            int k;
            if(row==n){
                k = row-1;
            }else {
                k = row;
            }
            while (k > 0) {
                System.out.print(k);
                k--;
            }

            System.out.println();
            row++;
            blank -= 2;
        }

    }
    //fibonacci series
    public static void fibonacci(){
        int n = 10 , a = 0 ,b = 1;
        for (int i = 0; i <= 15; i+=2) {
            System.out.print(i+" ");
            if ((i & 1)>0) {
                continue;
            }
            i++;

        }
        //fibo logic
//        System.out.print(a+" ");
//        System.out.print(b+" ");
//        for(int i = 1; i<=n;i++){
//            int nextNum = a+b;
//            System.out.print(nextNum+" ");
//            a = b;
//            b = nextNum;
  //      }

    }
    public static void subtractProductAndSum(){
        int n = 123, prod = 1 , sum = 0;
        while (n!=0){
            int digit = n % 10;
            prod = prod * digit;
            sum = sum + digit;
            n = n / 10;
        }
        int answer = prod - sum;
        System.out.println(answer);

    }

    //counting the number of 1 bit
    //question might contain value as 11111101111011101110101010101010
    //i am checking for a small int value
    public static void countOneBits(){
        int n = 00000000000000000000000000001011 , count=0;
        System.out.println("N is :"+ n);
        while(n!=0){
            //checking last digit
            if((n&1)!=0){
                count++;
            } System.out.println("count :"+count);
            n = n>>1;
            System.out.println("After shift :"+ n);
        }

    }
    public  static int hammingWeight() {
        int n =00000000000000000000000000001011;
        System.out.println(n);
        int bits = 0;
        int mask = 1;
        while(n!=0) {
            n = n & (n - 1);
            bits++;
            System.out.println(n);
        }
        System.out.println("bits :"+bits);
        return bits;
    }
    public static void convertBinary(int n){
        int answer =0,answer1 =0;
        int i =0;
        while(n!=0){
            int digit = n & 1;
           answer = (int)((Math.pow(10, i)*digit)+answer);
           answer1 = (10*answer1)+digit;

            n>>=1;
            i++;
        }
        System.out.println(answer);
        System.out.println(answer1);
    }
    public static void pattenOneZero(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <i; j++) {
                System.out.print((i+j)%2);
            }
            System.out.println();
            
        }
    }
}
