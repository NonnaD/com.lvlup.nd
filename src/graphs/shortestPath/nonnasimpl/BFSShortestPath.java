package graphs.shortestPath.nonnasimpl;

import graphs.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSShortestPath {
    public static void main(String[] args) {
        graphs.Vertex a = new graphs.Vertex("A");
        graphs.Vertex b = new graphs.Vertex("B");
        graphs.Vertex c = new graphs.Vertex("C");
        graphs.Vertex d = new graphs.Vertex("D");
        graphs.Vertex e = new graphs.Vertex("E");
        graphs.Vertex f = new graphs.Vertex("F");
        graphs.Vertex g = new graphs.Vertex("G");
        graphs.Vertex h = new graphs.Vertex("H");
        graphs.Vertex i = new graphs.Vertex("I");

        a.addNeighbour(b,c,d);
        b.addNeighbour(a,e);
        c.addNeighbour(a,d,f);
        d.addNeighbour(a,e, f, c);
        e.addNeighbour(d, h, g, d);
        f.addNeighbour(c,d,g,i);
        g.addNeighbour(f,e,h,i);
        h.addNeighbour(e,g,i);
        i.addNeighbour(f,g,h);

        bfsShortestPath(a);
    }

    public static void bfsShortestPath(Vertex a){
        Queue<Vertex> q = new LinkedList<>();
        q.add(a);
        a.setVisited(true);

        int level = 1;
        while (!q.isEmpty()){
            /**
             * IMPORTANT: Is there a moment when Q has only Vertices from single level
             * YES! When all Vertices from previous level are removed
             *
             * We can use size() of q at each level as a virtual divider
             * We increase int level when all V from this level are removed
             * For that when we start inserting at any level we declare fixed size
             * which is a size of Q at the moment when it contains V for certain level
             */
           int size = q.size();
           for (int i = 0; i < size; i++){
               Vertex current = q.poll();
               for (Vertex n: current.getNeighbours()){
                   if (!n.isVisited()){
                       q.offer(n);
                       n.setVisited(true);
                   }
               }
           }
           level++;
        }

        System.out.println(level);
    }
}
