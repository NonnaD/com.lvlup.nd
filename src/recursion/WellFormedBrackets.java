package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class WellFormedBrackets {
    public static void main(String[] args) {
        find_all_well_formed_brackets(4);
    }


    /**
     * Given a positive integer n, return ALL strings of length 2*n with well formed round brackets.
     * Input: 3
     * Output:
     *["((()))",
     *"(()())",
     *"(())()",
     *"()(())",
     *"()()()"]
     */
    static String[] find_all_well_formed_brackets(int n) {
        //number of solution n  = catalan number n
        String[] arrResult = new String[catalan(n)];
        ArrayList<String> listresult = new ArrayList<>(catalan(n));
        brackets(n , 0, 0, "", listresult);
        for (int i = 0; i < listresult.size(); i++){
            arrResult[i] = listresult.get(i);
        }
        return arrResult;
    }

    public static int catalan(int n){
        if (n <= 1) return 1;
        int catalan = 0;
        for (int i = 0; i < n; i++){
            catalan = catalan + catalan(i) * catalan(n - i -1);
        }
        return catalan;
    }

    public static void brackets(int n, int l, int r, String result, ArrayList<String> resultArr) {
        if (l == n && r == n) {
            resultArr.add(result);
            return;
        }
        if (l < n) brackets(n, l + 1, r, result + "(", resultArr);
        if (r < l) brackets(n, l, r + 1, result + ")", resultArr);
    }
}


