package graphs.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsATree {

    // Complete the function below
    public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {

        //not all node are connected
        if(node_count < edge_start.size() - 1) return false;

        //detect self cycle
        for(int i = 0; i < edge_start.size(); i++){
            if(edge_start.get(i) == edge_end.get(i)) return false;



        }

        Set<Integer> start = new HashSet<>();
        Set<Integer> end = new HashSet<>();


        start.addAll(edge_start);
        end.addAll(edge_end);

        //if in both start and end any V repeaded twice - there cycle
        if (start.size() < edge_start.size() && end.size() < edge_end.size()) return false;
        return true;
    }
}
