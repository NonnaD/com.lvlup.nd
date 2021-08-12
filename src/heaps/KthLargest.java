package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        lis.add(5);
        lis.add(1);
        lis.add(10);
        lis.add(3);
        lis.add(2);

        System.out.println("result " + kth_largest_in_an_array(lis, 2));
    }
    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {

        //IMPORTANT! PriorityQue is min heap by nature
        // MAx heap - (a,b)->b-a provide this as comparator
        PriorityQueue<Integer> qu = new PriorityQueue<>((a,b)->b-a);
        qu.addAll(numbers);
        int m = numbers.size() - k;

        // Alternative for for -> while(m-- > 0)  qu.poll();
        for (int i = 0; i < m; i++) qu.poll();
        return qu.poll();
    }


}
