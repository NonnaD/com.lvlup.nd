package graphs.misc;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        List<Integer> r1 = new ArrayList<>();
        r1.add(1); r1.add(0);

        List<Integer> r2 = new ArrayList<>();
        r2.add(0); r2.add(1);

//        List<Integer> r3 = new ArrayList<>();
//        r3.add(3); r3.add(1);
//
//        List<Integer> r4 = new ArrayList<>();
//        r4.add(3); r4.add(2);

        List<List<Integer>> prerequisites = new ArrayList<List<Integer>>();
        prerequisites.add(r1);
        prerequisites.add(r2);
//        prerequisites.add(r3);
//        prerequisites.add(r4);



       // System.out.println(prerequisites);
        List<Integer> schedule = course_schedule(4, prerequisites);
        System.out.println(schedule);
    }

    static List<Integer> course_schedule(int n, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Boolean> visitedCycle = new HashMap<>();
        List<Integer> schedule = new ArrayList<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();

        prerequisites.forEach(p -> {
            if(graph.containsKey(p.get(0))){
                graph.get(p.get(0)).add(p.get(1));
            }
            else{
                List<Integer> neigh = new ArrayList<>();
                neigh.add(p.get(1));
                graph.put(p.get(0), neigh);
            }
        });

        boolean isCycleDetected = false;
        while (--n >= 0){
           if (dfs(n,graph, visitedCycle, schedule, isVisited) == -1) {
               isCycleDetected = true;
               break;
           }
        }

        if (isCycleDetected) {
            schedule = new ArrayList<>();
            schedule.add(-1);
        }

        return schedule;
    }

    public static int dfs(int n, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visitedCycle, List<Integer> schedule, Map<Integer, Boolean> isVisited){
        if (visitedCycle.containsKey(n) && visitedCycle.get(n)) {
            return -1;

        }
        if (!isVisited.containsKey(n) || !isVisited.get(n)) {
            if (!visitedCycle.containsKey(n) || !visitedCycle.get(n)) {
                if (!graph.containsKey(n)) {
                    schedule.add(n);
                    isVisited.put(n, true);
                    return 0;
                }
                visitedCycle.put(n, true);
                for (int i : graph.get(n)) {
                    if (dfs(i, graph, visitedCycle, schedule, isVisited) == -1) return -1;
                }
                visitedCycle.replace(n, false);
                schedule.add(n);
                isVisited.put(n, true);
            }
        }
        return 0;
    }
}
