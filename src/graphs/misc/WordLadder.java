package graphs.misc;

import graphs.Vertex;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

        String begin = "hit";
        String end = "cog";
        String[] dic = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(dic));
        List<Vertex> visited = new ArrayList<>();
        List<Vertex> graph = new ArrayList<>();
        Vertex bWord = new Vertex(begin);
        buildTree(bWord, dictionary, visited, graph);


        System.out.println(findShortestPathWordLadder(bWord, end));

    }

    /**
     *  Find length of shortest transformation from 'hit' to 'cog'
     *  only using words from dictionary
     *  dic = {"hot", "dot", "dog", "lot", "log", "cog"};
     *
     *  1. Constructed graph where each neighbour has 1 char difference from previous - buildTree()
     *  2. Perform BFS shortest path
     *  3. If end word reached before reaching end of G return current level
     *
     */
    public static int findShortestPathWordLadder(Vertex begin, String end){
        Queue<Vertex> q = new LinkedList<>();
        q.add(begin);
        begin.setVisited(true);
        //shortest path in un-weighted graph equals levels
        int level = 1;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Vertex current = q.poll();
                for (Vertex n: current.getNeighbours()){
                    if(!n.isVisited()){
                        //if we reached the end word before we reached end of graph - return current level
                        if (n.getValue().equals(end)) return level;
                        n.setVisited(true);
                        q.add(n);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void buildTree(Vertex v, List<String> dict, List<Vertex> visited, List<Vertex> graph) {
        visited.add(v);
        for (String word : dict) {
            //if such object already exists use this object instead of creating new
            Vertex wordVer = returnVertex(word, graph);
            if (isOneCharDifference(v.getValue(), word)){
                v.addNeighbour(wordVer);
            }
            if (!isInVisited(wordVer, visited)){
                buildTree(wordVer, dict, visited, graph);
            }
        }
    }


    //returns new Vertex object if existing word is not in graph
    //returns existing Vertex if word is in graph
    public static Vertex returnVertex(String word, List<Vertex> graph){
        for (Vertex v: graph) {
            if (v.getValue().equals(word)){
                return v;
            }
        }
        Vertex newv = new Vertex(word);
        graph.add(newv);
        return newv;
    }

    public static boolean isInVisited(Vertex v, List<Vertex> visited){
        for (Vertex visit: visited){
            if (visit.getValue().equals(v.getValue())) return true;
        }
        return false;
    }

    public static boolean isOneCharDifference(String origin, String compare) {
        int diff = 0;

        if (origin.length() == compare.length()) {
            for (int i = origin.length() - 1; i >= 0; i--) {
                diff += origin.charAt(i) == compare.charAt(i) ? 0 : 1;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

}
