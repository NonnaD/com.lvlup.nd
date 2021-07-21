package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfSet {
    public static void main(String[] args) {
        String name = "testme";
        System.out.println(Arrays.toString(generate_all_subsets(name)));

    }

    static String[] generate_all_subsets(String s) {
        List<String> arrList = new ArrayList<>(nset(s.length()));
        String[] arr = new String[nset(s.length())];
        powerSet(arrList, s, 0, "");
        System.out.println(arrList.toString());
        for(int i = 0; i < arr.length; i++){
            arr[i] = arrList.get(i);
        }
        return arr;
    }

    static void powerSet(List<String> arr, String str, int i, String curr) {
        if (i == str.length()){
            arr.add(curr);
            return; }
        powerSet(arr, str, i + 1, curr + str.charAt(i));
        powerSet(arr, str, i + 1, curr);
    }

    public static int nset(int n){
        if(n == 0) return 1;
        return 2 * nset(--n);
    }

}