package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NtoK {

    //Given 2 integers n and k
    //n=4 and k =2
    //Find all possible combinations of k numbers out of 1...n
    //Output:

    public static void main(String[] args) {
        int k = 2;
        int n = 4;
        nofk(n, k, 1, new ArrayList<>());
    }

    public static void nofk(int n, int k, int i, ArrayList<Integer> arr){
        if (k == arr.size()){
            System.out.println(Arrays.toString(arr.toArray()));
            return;
        }
        if ( i > n) return;

        arr.add(i);
        nofk(n, k, i+1,  arr);
        arr.remove(arr.size() -1);
        nofk(n, k,i+1, arr);
    }
}
