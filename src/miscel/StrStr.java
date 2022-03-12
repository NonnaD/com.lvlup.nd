package miscel;

public class StrStr {

    public static void main(String[] args) {
        String twins = "kninokurbanod";
        String nino = "nino";

        //IndexOf if string contains another string indexof returns first char position
        System.out.println(twins.indexOf(nino));

        myIndexOFImpl("mississippi", "issipi");
    }


    public static int myIndexOFImpl(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;

        int isSubstring = -1;

        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) != needle.charAt(0)) continue;
            isSubstring = i;
            for(int j = 0; j < needle.length(); j++){
                //for corner case "mississippi", "issipi"
                if(i + needle.length() > haystack.length()) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)) isSubstring = -1;
            }
            if(isSubstring != -1) return isSubstring;
        }

        return isSubstring;
    }


}
