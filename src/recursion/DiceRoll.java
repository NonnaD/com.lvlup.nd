package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceRoll {

    //Print all combinations of dice values that add up to given summ
    // Dice can have 6 values - 1,2,3,4,5,6
    //Input dice = 2 sum = 7
    //Output: {1,6}, {2,5}, {3, 4}, {4, 3}, {5,2}, {6,1}

    public static void main(String[] args) {
        int numberOfDices = 2;
        int sum = 7;
        int diceVal= 6;

        dice(numberOfDices, sum, diceVal, new ArrayList<>());
    }


    public static void dice(int dices, int sum, int val, List<Integer> result){
        if(result.size() == dices){
            if (sum == result.stream().mapToInt(i -> i).sum()) {
                System.out.println(Arrays.toString(result.toArray()));
            }
           return;
        }

        for(int i = 1; i <= val; i++){
            result.add(i);
            dice(dices, sum, val, result);
            result.remove(result.size() -1);
        }
    }
}
