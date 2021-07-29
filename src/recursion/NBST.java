package recursion;

public class NBST {
    public static void main(String[] args) {
        System.out.println(how_many_BSTs(4));
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
        if (n <= 1) return 1;
        long catalan = 0;
        for (int i =0; i < n; i++){
            catalan = catalan + how_many_BSTs(i) * how_many_BSTs(n - i -1);
        }
        return catalan;
    }
}
