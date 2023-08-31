package BasicMaths;

public class Tuf {
    public static void main(String[] args) {
        int n = 36;
        //System.out.println(Math.sqrt(n));
        //findAllDivisor(n);
        int a = 15 , b = 31;
       // CalculateGcd(a , b);
        System.out.println(CalculateGcd(a , b));

    }

    //Eulidian Algorithm
    private static Integer CalculateGcd(int a, int b) {
        while(a>0 && b>0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        if ( a == 0) return b;
        else return a;
    }

    private static void findAllDivisor(int n) {
        for (int i = 1; i*i <=n ; i++) {
            if (n%i == 0) {
                System.out.print(i+" ");
                if(n/i != i){
                    System.out.print(n/i+" ");
                }
            }


        }
    }
}
