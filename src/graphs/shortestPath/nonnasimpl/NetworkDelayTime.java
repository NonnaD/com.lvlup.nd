package graphs.shortestPath.nonnasimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    /**You are given a network of n nodes, labeled from 1 to n. You are also given times,
    a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
    vi is the target node, and wi is the time it takes for a signal to travel from source to target.

    We will send a signal from a given node k. Return the time it takes for all the n nodes to receive
    the signal. If it is impossible for all the n nodes to receive the signal, return -1.

     https://leetcode.com/problems/network-delay-time */

        /*Dijkstra implementation O(V + E* log(V))
        * See Bellman-Ford impl -> NetworkDelay_BellmanFord.java */
        public int networkDelayTime(int[][] times, int n, int k) {
            PriorityQueue<VertexG> q = new PriorityQueue<>((i , j) -> i.distance - j.distance);
            VertexG[] graph = buildWightedGraph(times, n);
            boolean[] visited = new boolean[n + 1];
            int longestPath = 0;

            VertexG root = graph[k];
            q.add(root);
            //for our root vertex distance is 0
            root.distance = 0;
            root.predessor = null;

            //Dijkstras algo DFS + PQ + Edge relaxation
            while(!q.isEmpty()){
                VertexG curr = q.poll();
                visited[curr.val] = true;

                for(VertexG v: curr.neigh.keySet()){
                    if(visited[curr.val]) {
                        //edge relaxing -  if current neighbour vertex distance < precessor vertex distance + edge weight
                        //replace old distance with new distance
                        int newDistance = curr.distance + curr.neigh.get(v);

                        if(v.distance > newDistance){
                            v.distance = newDistance;
                            v.predessor = curr;
                            q.add(v);
                        }

                    }
                }
            }

            for(int i = 1; i < graph.length; i++){
                if(graph[i] == null || graph[i].distance == Integer.MAX_VALUE) return -1;
                longestPath = Math.max(longestPath, graph[i].distance);
            }

            return longestPath;
        }


    VertexG[] buildWightedGraph(int[][] times, int n){
            VertexG[] graph = new VertexG[n + 1];

            for(int[] t: times){
                VertexG curr = graph[t[0]] == null?new VertexG(t[0]):graph[t[0]];
                VertexG neigh = graph[t[1]] == null? new VertexG(t[1]):graph[t[1]];
                graph[t[1]] = neigh;
                curr.neigh.put(neigh, t[2]);
                graph[t[0]] = curr;
            }
            return graph;
        }
}


class VertexG{
        public int val;
        public VertexG predessor;
        public int distance = Integer.MAX_VALUE;
        public Map<VertexG, Integer> neigh;

    VertexG(int val){
            this.val = val;
            this.neigh = new HashMap();
        }
    }

