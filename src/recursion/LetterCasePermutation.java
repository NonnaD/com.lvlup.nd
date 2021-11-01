package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {


//    Return the set of strings which can be generated from a given string by changing the case of a group of letter(s).
//    Return all the possible strings in lexicographic order.
//
//    Example One:
//    Input: “a1z”
//    Output: [“A1Z”, “A1z”, “a1Z”, “a1z”]
//
//    Example Two:
//    Input: “123”
//    Output: [“123”]

    public static void main(String[] args) {
        letter_case_permutations("no1a");
    }


    public static List<String> letter_case_permutations(String str) {

        char[] arr = str.toCharArray();
        List<String> slist = new ArrayList<>();

        letter(arr, "", 0, slist);
        slist.forEach(System.out::println);
        return null;

    }

    public static void letter(char[] arr, String str, int n, List<String> alist){
        if (n > arr.length - 1) {
            alist.add(str);
            return;
        }
        if (!Character.isDigit(arr[n])) {
            letter(arr, str + String.valueOf(arr[n]).toUpperCase(), n + 1, alist);
            letter(arr, str + String.valueOf(arr[n]).toLowerCase(), n + 1, alist);
        }else {
            letter(arr, str + String.valueOf(arr[n]), n + 1, alist);
        }
    }

}
