package bitwise;

public class IsOddOrEven {
    public static void main(String[] args) {
        //if((n&1) == 0) even else odd
        //Example: 1 & 1
//               001
//               001
//               ---
//               001 = 1  not == 0 false
//       //Example: 2 & 1
//                 010
//                 001
//                 ---
//                 000 = 0 -> even
        System.out.println((2&1) == 0);
        System.out.println((1&1) == 0);
    }
}
