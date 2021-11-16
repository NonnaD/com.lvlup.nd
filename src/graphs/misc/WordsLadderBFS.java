package graphs.misc;

import java.util.*;

public class WordsLadderBFS {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(string_transformation(new String[]{
                "cat",
                "hat",
                "bad",
                "had"}, "bat", "had")));

    }

    static String[] string_transformation(String[] words, String start, String stop) {
        if(start == null || (start.equals(stop) && words.length == 0)) return new String[] {"-1"};
        //1. Build graph  - adjacency Map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> visited = new ArrayList<>();
        List<String> result = new ArrayList();
        List<List<String>> all = new ArrayList();
        List<String> wordsList = new ArrayList<>();
        wordsList.addAll(Arrays.asList(words));

        if (stop.equals(start)) {
            wordsList.add(start);
        } else {
            wordsList.add(start);
            if (!wordsList.contains(stop)) wordsList.add(stop);
        }


        /**
         * This will build a graph Adjacency Map
         */
        for (String s: wordsList) addNeighbours(graph, s, wordsList);


        //  printG(graph);

        distance.put(start, 0);
        //2.DFS to find all possible combination
        dfs(graph, start, stop, distance, result, all, visited, 0);

        //3. Find the shortest path
        int shortest = Integer.MAX_VALUE;
        for (List<String> str : all) {
            shortest = Math.min(str.size(), shortest);
        }

        String[] shortes = new String[0];
        for (List<String> str : all) {
            if (str.size() == shortest) {
                shortes = str.toArray(new String[0]);
                break;
            }
        }

        return shortes;

    }

    public static void dfs(Map<String, List<String>> graph,
                           String start, String stop, Map<String, Integer> distance, List<String> result, List<List<String>> all, List<String> visited, int iteration) {
        if (start.equals(stop)) {
            if (iteration != 0) {
                result.add(start);
                List<String> temp = new ArrayList<>(result);
                all.add(temp);
                result.remove(result.size() - 1);
                return;
            }
        }

        result.add(start);
        visited.add(start);
        int currentDistance = distance.get(start);

        for (String s : graph.get(start)) {
            if (!visited.contains(s)){
                if (!distance.containsKey(s)) distance.put(s, Integer.MAX_VALUE);
                if (distance.get(s) > currentDistance + 1) {
                    distance.replace(s, currentDistance + 1);
                    dfs(graph, s, stop, distance, result, all, visited,iteration + 1);
                }
            }}

        result.remove(result.size() - 1);
    }

    public static void addNeighbours( Map<String, List<String>> graph,  String word,  List<String> wordsList){
        if (graph.containsKey(word)) return;
        List<String> neigh = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++){
            char[] wChar = word.toCharArray();
            for (int i = 0; i < word.length(); i++){
                char curent = wChar[i];
                if (c == wChar[i]) continue;
                wChar[i] = c;
                String newW = String.valueOf(wChar);
                if (wordsList.contains(newW)) {
                    neigh.add(newW);
                }
                //backtrack: change back to original char for next replacment
                wChar[i] = curent;
            }
        }
        graph.put(word, neigh);
    }

    public static void printG(Map<String, List<String>> graph) {
        for (String key : graph.keySet()) {
            System.out.println(key + " " + graph.get(key));
        }
    }
}

