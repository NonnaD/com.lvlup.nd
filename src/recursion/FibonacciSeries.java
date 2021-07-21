package recursion;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(fib(5));
       System.out.println(sumNumber(5));
        System.out.println(factorial(4));
    }

    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    static int sumNumber(int n) {
        if (n <= 1) return n;
        return  n + sumNumber(n-1);
    }

    static int factorial(int n){
        if(n <= 1) return 1;
       return n * factorial(n-1);
    }







}