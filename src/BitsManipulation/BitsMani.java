package BitsManipulation;

//Leetcode Questions
public class BitsMani {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(7));
    }
    //leetcode no 7
    public static int reverseInteger( int n ){
        int reverse = 0;
        int digit = 0;
        while(n != 0){
          digit = n % 10;
          if(reverse < Integer.MIN_VALUE/10 || reverse > Integer.MAX_VALUE/10) return 0;
          reverse = (reverse * 10) + digit;
          n /= 10;
        }
       return reverse;
    }
    //leetcode no 1009
    public static int complimentOfBase10( int n ){
        int result = 0;
        int m =  n , mask = 0;
        if (m == 0 ) return 1;
        while(m != 0){
            mask = (mask << 1) | 1;
            m = m >> 1;
        }
        result = (~n) & mask ;
       return result;
    }
    //leetcode no 231
    public static boolean powerOfTwo( int n ){
        if(n == 0) return false;
        int res = n & (n -1);
        if(res == 0) return true;
        else return false;
    }
}
