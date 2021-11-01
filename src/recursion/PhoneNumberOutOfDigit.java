package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberOutOfDigit {

//    Given a seven-digit phone number, return all the character combinations that can be generated according to the following mapping:
//    Return the combinations in the lexicographical order.
//    Input: “1234567”
//
//    Output: [
//            “adgjmp”,
//            “adgjmq”,
//            “adgjmr”,
//            “adgjms”,
//            “adgjnp",
//            .....
//            “cfilns”,
//            “cfilop”,
//            “cfiloq”,
//            “cfilor”,
//            “cfilos”]
//
//    First string “adgjmp” in the first line comes from the first characters mapped to digits 2,3,4,5,6 and 7 respectively.
//    Since digit 1 maps to nothing, nothing is appended before 'a'. Similarly, the fifth string “adgjnp” generated from first characters of 2,3,4,5,
//    second character of 6 and first character of 7. All combinations generated in such a way must be returned in the lexicographical order.

    public static void main(String[] args) {
        getWordsFromPhoneNumber("1010101").forEach(System.out::println);
    }

    public static List<String> getWordsFromPhoneNumber(String phoneNumber) {
        // Write your code here
        List<String> results = new ArrayList<>();
        Map<Character, String> nums = new HashMap<>();
        nums.put('1', "");
        nums.put('2', "abc");
        nums.put('3', "def");
        nums.put('4', "ghi");
        nums.put('5', "jkl");
        nums.put('6', "mno");
        nums.put('7', "pqrs");
        nums.put('8', "tuv");
        nums.put('9', "wxyz");
        nums.put('0', "");


        String phoneUpdated = phoneNumber.replace("1", "").replace("0", "");
        if(phoneUpdated.length() == 0){
            results.add("-1");
            return results;
        }
        helper(phoneUpdated, 0, nums, new char[phoneUpdated.length()], results);

        return results;

    }

    public static void helper(String phoneNumber, int index, Map<Character, String> nums, char[] result, List<String> results) {
        if (index >= phoneNumber.length()) {
            results.add(new String(result));
            return;
        }

        for (int i = 0; i < nums.get(phoneNumber.charAt(index)).length(); i++) {
            result[index] = nums.get(phoneNumber.charAt(index)).charAt(i);
            helper(phoneNumber, index + 1, nums, result, results);
        }
    }
}