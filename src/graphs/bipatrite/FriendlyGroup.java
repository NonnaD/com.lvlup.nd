package graphs.bipatrite;

import java.util.*;

public class FriendlyGroup {
    public static void main(String[] args) {
        Integer[] l1 = {6,6,4,4,0};
        Integer[] l2 = {5,3,3,5,5};
        List<Integer> dislike1 = Arrays.asList(l1);
        List<Integer> dislike2 = Arrays.asList(l2);
        System.out.println(can_be_divided(7, dislike1, dislike2));
    }

    public static boolean can_be_divided(int num_of_people, List<Integer> dislike1, List<Integer> dislike2) {
        if (dislike1.size() != dislike2.size() || dislike2.size() <= 0) return true;
        //1.Build graph
        int[][] graph = new int[num_of_people][num_of_people];
        for (int i = 0; i < dislike1.size(); i++) {
            graph[dislike2.get(i)][dislike1.get(i)] = 1;
            graph[dislike1.get(i)][dislike2.get(i)] = 1;
        }

         for(int[] i: graph){
             System.out.println(Arrays.toString(i));
         }

        //2. BFS with coloring to detect even/odd cycle
        //Will use 2 colors 0 and 1
        Map<Integer, Integer> coloredG = new HashMap<>();
        List<Integer> visited = new ArrayList<>();

        //Corner case graph is disconected
        for (int i: dislike1)
               if (!bfs(graph, coloredG, visited, i)) return false;
        return true;
    }

    public static boolean bfs(int[][] graph, Map<Integer, Integer> colored, List<Integer> visited,  int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colored.put(start, 0);
        visited.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.remove();

            for (int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1) {

                    if (!visited.contains(i)){
                        queue.add(i);
                        visited.add(i);
                    }
                    int nColor = colored.get(cur) == 0 ? 1 : 0;
                    if (!colored.containsKey(i)) {
                        colored.put(i, nColor);
                    } else {
                        if (colored.get(i).equals(colored.get(cur))) return false;
                    }
                }
            }
        }

        return true;
    }
}
