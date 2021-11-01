package recursion;

import java.util.List;

public class ThreeLetterWorld {
    public static void main(String[] args) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int size = 3;
        threeLetter(abc, "", 0, size);
    }

    //no duplications
    public static void threeLetter(String abs, String result, int index, int size){
        if (result.length() >= size){
            System.out.println(result);
            return;
        }

        for (int i = index; i < abs.length(); i++){
            threeLetter(abs, result + abs.charAt(i), i + 1, size);
        }
    }
}


