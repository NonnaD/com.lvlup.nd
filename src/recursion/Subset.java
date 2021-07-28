package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subset {

    public static void main(String[] args) {
        System.out.println(check_if_sum_possible(new long[]{2,4,8}, 6));
    }


    //[2,3,4], k=5
    static boolean check_if_sum_possible(long[] arr, long k) {
        List<Long> result = new ArrayList<>();
        List<List<Long>> results = new ArrayList<>(twoInPowerN(arr.length));
        for(long l: arr){
            result.add(0L); }
        findSubset(arr, k, 0, result, results);
        boolean isSumExist = false;
        int sum = 0;
        for (List<Long> sums : results) {
            for (Long l : sums) {
                sum = (int) (sum + l);
            }
            if (sum == k) {
                isSumExist = true;
                break;
            }else {sum = 0;}
        }
        return isSumExist;
    }

    public static int twoInPowerN(int n) {
        if (n == 0) return 1;
        return 2 * twoInPowerN(n - 1);
    }

    public static void findSubset(long[] arr, long k, int n, List<Long> result, List<List<Long>> results) {
        if (n == arr.length) {
            //this is important when we add result as it is, we pass reference of result list to the results
            //and at the end we get list with duplicated final result
            //results does not actually stores the result object itself but just reference to it
            //so once result is updated all references point to the same object in the memory
            List<Long> listik = new ArrayList<>(result.size());
            listik.addAll(result);
            results.add(listik);
            return;
        }

        //exclude
        result.set(n, 0L);
        findSubset(arr, k, n + 1, result, results);

        //include
        result.set(n, arr[n]);
        findSubset(arr, k, n + 1, result, results);
    }

}
