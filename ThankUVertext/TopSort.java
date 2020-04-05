package ThankUVertext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


class TopSort {

    ArrayList<Node> Kahns(final DirectedGraph graph){
        HashMap<Node, Integer> map = graph.dictionary();
        ArrayList<Node> nodesOutputted = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<>();

        for(Node node: map.keySet()){
            if(node.numberOfEdges == 0){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            Node first = queue.peek();
            //System.out.println(first.value);
            nodesOutputted.add(first);
            for(Node neighbor: first.neighbors){
                neighbor.numberOfEdges--;
            }
            first.numberOfEdges = -1;
            for(Node neighbor: first.neighbors){
                System.out.println(neighbor.value);
                if(neighbor.numberOfEdges == 0){
                    queue.add(neighbor);
                }
            }
            queue.remove(first);
        }

        return nodesOutputted;
    }
}