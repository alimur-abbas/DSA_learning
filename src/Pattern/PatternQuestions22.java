package Pattern;

public class PatternQuestions22 {
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
        pattern11(5);
        pattern12(5);
        pattern13(5);
        pattern14(5);
        pattern15(5);
        pattern16(5);
        pattern17(5);
        pattern18(5);
        pattern19(5);
        pattern20(5);
        pattern21(5);
        pattern22(5);
        replacaOfPattern17(4);

    }
    public static void pattern1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern6(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n-i+1) ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern7(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i-1) ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i+1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*(n-i)-1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n){
       pattern7(n);
       pattern8(n);
    }
    public static void pattern10(int n){
        int star = 0;
        for (int i = 1; i <=(2*n-1); i++) {
            star = (i > n )? 2*n -i : i;
            for (int j = 1; j <=star ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern11(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print((i+j)%2);
            }
            System.out.println();
        }
    }
    public static void pattern12(int n){
        //number
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);
            }
            // space
            for (int j = 1; j <= 2*(n-i) ; j++) {
                System.out.print(" ");
            }
            // number
            for (int j = i; j > 0 ; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern13(int n){
        int start = 1;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(start+" ");
                start++;
            }
            System.out.println();
        }
    }
    public static void pattern14(int n){
        for (int i = 0; i <n; i++) {
            for (char ch = 'A'; ch<='A'+i;ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
    public static void pattern15(int n){
        for (int i = 0; i <n; i++) {
            for (char ch = 'A'; ch<'A'+n-i;ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
    public static void pattern16(int n){
        char ch;
        for (int i = 0; i <n; i++) {
             ch = (char) ('A'+i);
            for (int j = 0 ; j <= i;j++) {
                System.out.print(ch +" ");
            }
            System.out.println();
        }
    }
    public static void pattern17(int n){
        for (int i = 0; i <n; i++) {
            //space
            for (int j = 0; j < (n-i-1); j++) {
                System.out.print(" ");
            }
                char ch = 'A';
            int breakPoint = (2*i+1)/2;
            for (int j = 0 ; j < (2*i+1); j++ ) {
                System.out.print(ch );
              if(j<breakPoint){
                  ch++;
              }
              else {
                  ch--;
              }

            }
            System.out.println();
        }
    }
    public static void pattern18(int n){
        for (int i = 0; i <n; i++) {
            for (char ch = (char)('E'-i); ch<='E';ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
    public static void pattern19(int n){
        for (int i = 0; i < n; i++) {
            //upper symmetry
            //star
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            //space
            for (int j = 0; j < 2*i; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            //bottom symmetry
            //star
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            //space
            for (int j = 0; j < 2*(n-i) ; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void pattern20(int n){
        int space , star;
        for (int i = 1; i <= 2*n-1; i++) {
            if(i>n){
                space = 2*(i-n);
                star = 2*n-i;
            }
            else{
                space = 2*(n-i);
                star = i;
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void pattern21(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == n-1 ||j == n-1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void pattern22(int n){
        int top ,bottom , left , right , horizontalMinDistance , verticalMinDistance;
        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                //calculating distance from all 4 side
                 top = i; bottom = (2*n-2)-i ; left = j ; right = (2*n-2)-j;
                horizontalMinDistance = Math.min(top ,bottom);
                 verticalMinDistance = Math.min(left , right);
                System.out.print(n-Math.min(horizontalMinDistance , verticalMinDistance));
            }
            System.out.println();
        }
    }

    public static void replacaOfPattern17(int n){
        for(int i =1 ; i<=n ; i++){
            //space
            for(int space = n-i;space>0;space--){
                System.out.print(" ");
            }
            //character
            int element = 1;
            for(int j = 1; j<=(2*i)-1; j++){
                System.out.print(element);
                if(j<i) element++; // or the condition can be element < i
                else element--;
            }
            System.out.println();
        }
    }

}
