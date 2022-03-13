package graphs.shortestPath.nonnasimpl;

import java.util.Arrays;

public class NetworkDelay_BellmanFord {

    /**
     * See the Problem Description here NetworkDelayTime.java
     *
     * Bellman-Ford vs Dijkstra
     * BF algo works for negative weighted edges when Dijkstra may or may not work
     * Performance:
     *          Dijkstra  O(V + E* log(V))
     *          Bellman-Ford (V*E)
     *
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        //wight can became to large and overflow int so we will use Double here
        double[] weights = new double[n];
        Arrays.fill(weights, Double.MAX_VALUE);
        weights[k - 1] = 0;
        //we set default signal time to min value
        //Bellman-Ford Algo assumes negative values as well
        //and signla time can became < 0
        double signalTime = Double.MIN_VALUE;

        //We need to iterate thru all edges |v -1| time where v is N of vertecies
        for(int i = 0; i < n -1; i++){
            for(int[] edge: times){
                int u = edge[0] - 1, v = edge[1] - 1, currW = edge[2];
                weights[v] = Math.min(weights[v], weights[u] + currW);
            }
        }

        for(double d: weights)
            signalTime = Math.max(d, signalTime);


        return signalTime == Double.MAX_VALUE?-1: (int) signalTime;
    }
}
