package recursion;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println("S " + sumNumber(5));
        System.out.println("SF " + sumNumberFormula(5));
        System.out.println("SF1 " + sumNumberFormula1 (5));
        System.out.println(factorial(4));
        System.out.println(power(2,5));
        System.out.println(taylor(3, 10));
    }

    static int fib(int n) {
        if (n <= 1) return 1; //<-- ascending
        int fib = fib(n - 1) + fib(n -2); //<-- descending
        return fib; // <-- descending
    }

    static int sumNumber(int n) {
        if (n <= 1) return n;
        return n + sumNumber(n - 1);
    }

    static long sumNumberFormula(long n) {
      //this is bad choice because
      // n/2 can result some decimal number and int will round it down
      return (n + 1) * (n/2);
    }

    static int sumNumberFormula1(int n) {
        //S = n + (n - n + 1) * n
        //    ---------------
        //         2
        //return ((n + ((n - n) + 1)) * n)/2;
        return ((n + 1) * n)/2 ;
    }

    static double factorial(double n){
       if (n <= 1) return n;
       return n * factorial( n - 1);
    }


    public static double taylor(double x, double n){
        if(n == 0) return 1;
        return taylor(x, n-1) + power(x, n)/factorial(n);
    }

    private static double power(double x, double n) {
        if (n == 0) return 1;
        return x * power(x, n-1);
    }


}