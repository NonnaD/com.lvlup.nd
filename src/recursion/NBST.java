package recursion;

public class NBST {
    public static void main(String[] args) {
        System.out.println(nonUnique(3));
        System.out.println(how_many_BSTs(3));
    }

    /**
     * How many unique binary trees can be constructed from n
     * This problem can be represented by Catalan sequence
     *     To find C3 we perform reflection multiplication
     *      *  For n = 3 Cn = 1*2 + 1*1 + 2*1 = 2+1+2=5
     *      *  No we have C3 to find C4
     *      *  C0=1 C1=1 C2=2 C3=5
     *      *  C3=5 C2=2 C1=1 C0=1
     *      *  C4 = 1*5 + 1*2 + 2*1 + 5*1 = 5+2+2+5 = 14
     *
     *    i        ------------>     n - 1
     *    n-i-1    <------------     n - n - 1
     * @return long number of unique trees
     */
    static long how_many_BSTs(int n) {
        if(n <= 1) return 1;
        long catalan = 0;
        for (int i = 0; i < n; i ++){
            catalan = catalan + how_many_BSTs(i) * how_many_BSTs(n - 1 - i);
        }
        return catalan;
    }

    /** For each unique BT we can have catalan(n) * n! non - unique  BT
     *  Number of non unique BT = Catalan(n) * n!
     * @return
     */
    static long nonUnique(int n){
        long nonUnique  = how_many_BSTs(n) *  factorial(n);
        return nonUnique;
    }

    static long factorial(long n){
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}


