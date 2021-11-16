package graphs.misc;

import graphs.shortestPath.nonnasimpl.Vertex;

import java.util.*;

public class WordsLadderPathDjikstra {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(string_transformation(new String[]{
                "cat",
                "hat",
                "bad",
                "had"}, "bat", "had")));

    }

    /**
     * IMPORTANT!: OnceCharDifference() function time complexity --> O(n2) is to slow and timeOuts when dict > 4000 words
     * Alternative is instead of looping thru array of words:
     * 1. For vertex candidate -> convert to s.toCharArray()
     * 2. Loop thru char array and each char replace by each alphabet char for(char c = 'a'; c < 'z'; c++)
     * 3. Replace given char in our char array and convert to string
     * 4. Check if dictionary contains new string with modified char
     * 5. If 4 is true add to neighbours
     */
    static String[] string_transformation(String[] words, String start, String stop) {
        if (start == null || (start.equals(stop) && words.length == 0)) return new String[]{"-1"};

        List<Vertex> graph = new LinkedList<>();
        List<String> result = new LinkedList<>();
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));

        wordsList.add(start);
        if (!wordsList.contains(stop)) wordsList.add(stop);


        for (String s : wordsList) graph.add(new Vertex(s));
        for (Vertex v : graph) addNeighbours(v, wordsList, graph);

        for (Vertex v : graph) {
            if (v.value.equals(start)) {
                v.distance = 0;
                for (Vertex dest: graph) {
                if (dest.value.equals(stop)) {
                    djikstra(v, stop);
                    printShortestPath(v, dest, result);
                }
            }
            }
        }

        String[] res = result.toArray(new String[0]);
        return res;
    }

    public static void printShortestPath(Vertex source, Vertex destination, List<String> result){
        if (source.value.equals(destination.value)){
            result.add(destination.value);
            return;
        }
        printShortestPath(source, destination.predecessor, result);
        result.add(destination.value);
    }

    public static void djikstra(Vertex v, String stop) {
        if (v.value.equals(stop)) return;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex min = queue.poll();
            for (Vertex n : min.neigh) {
                if (!n.isVisited) {
                    if (min.distance + 1 < n.distance) {
                        n.distance = min.distance + 1;
                        n.predecessor = min;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void addNeighbours(Vertex v, List<String> dict, List<Vertex> graph) {
        List<Vertex> neighbours = new ArrayList<>();
        char[] charAr = v.value.toCharArray();

        for (int i = 0; i < charAr.length; i++) {
            char old = charAr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == charAr[i]) continue;
                charAr[i] = c;
                String modified = String.valueOf(charAr);
                if (dict.contains(modified)) {
                    for (Vertex vert : graph) {
                        if (vert.value.equals(modified)) {
                            neighbours.add(vert);
                        }
                    }
                }
            }
            charAr[i] = old;
        }
        v.neigh = neighbours;
    }

    static class Vertex implements Comparable<Vertex> {
        public String value;
        public List<Vertex> neigh;
        public int distance = Integer.MAX_VALUE;
        public Vertex predecessor;
        public boolean isVisited = false;

        public Vertex(String value) {
            this.value = value;
            this.neigh = new ArrayList<>();
        }

        //I need this comparator to get the min from PriorityQueue based on distance value
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance, o.distance);
        }

        public String toString() {
            return this.value;
        }
    }
}
