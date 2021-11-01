package recursion;

public class CatalanNumbers {

    public static void main(String[] args) {

        System.out.println(catalanNum(5));

    }

    /**
     *  Find N'th catalan number
     *  Cn = C0Cn-1 + C1Cn-2 + C2Cn-3 + ... Cn-1C0 where c0 and c1 = 1
     *  For n = 2 Cn = 1*1 + 1*1 = 2
     *  C0=1 C1=1 C2=2
     *  C2=2 C1=1 C0=1
     *  To find C3 we perform reflection multiplication
     *  For n = 3 Cn = 1*2 + 1*1 + 2*1 = 2+1+2=5
     *  No we have C3 to find C4
     *  C0=1 C1=1 C2=2 C3=5
     *  C3=5 C2=2 C1=1 C0=1
     *  C4 = 1*5 + 1*2 + 2*1 + 5*1 = 5+2+2+5 = 14
     *
     *    i        ------------>     n - 1
     *    n-i-1    <------------     n - n - 1
     *
     *    0 1 2 3  4    - catalan sequence starts from 0
     *
     *    1  1 2 5 14
     *                catalan 5 = 1*14 + 1*5 + 2*2 + 5*1 + 14*1 = 14 + 5 + 4 + 5 + 14 = 42
     *    14 5 2 1 1
     */
    public static int catalanNum(int n){
        if (n <= 1) return 1;
        int catalan = 0;
        for (int i = 0; i < n; i++ ){
            catalan = catalan + (catalanNum(i) * catalanNum(n-i-1));
        }
        return catalan;
    }
}
