package easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int shortest = 0;
        for (int i = 0; i < strs.length; i++) shortest = strs[shortest].length() > strs[i].length() ? i : shortest;


        boolean isEqual = false;
        String shortestString = strs[shortest];
        int j = shortestString.length();

        while (j-- >= 1) {
            isEqual = isEqualPartInStrings(strs, strs.length - 1, shortestString, j);
            System.out.println(isEqual + " " + j);
            if (isEqual) return shortestString.substring(j);
        }

        return "";

    }

    public static boolean isEqualPartInStrings(String[] arr, int i, String shortestString, int j){
        if (i < 0) return true;
        return arr[i].substring(0, j).equals(shortestString.substring(0, j)) && isEqualPartInStrings(arr, --i, shortestString, j);
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }
}
