package recursion;

public class PermutationSOrderMatter {


    /**
     * Given a list of char print all the possible permuatations
     * Example:
     *
     * String str = "HAT"
     * HAT 1 -> 1
     *Output: HAT, ATH, TAH, AHT, HTA, THA
     *
     */
    public static void main(String[] args) {
        String str = "1234";
        char[] strchar = str.toCharArray();

        permute(strchar, 0, 0);
    }

    public static void permute(char[] str, int index, int k){
        if(index >= str.length) {
            System.out.println(new String(str));
            return;
        }

        for (int i = index; i < str.length; i++){
            swap(str, i, index);
            permute(str, i + 1, k+1);
            swap(str, i, index);
        }

    }

    public static void swap(char[] arr, int index1, int index2){
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
