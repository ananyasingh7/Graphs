package ThankUVertext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TopSort {

    //shout out lesson 11 psuedocode
    ArrayList<Node> Kahns(final DirectedGraph graph){
        HashMap<Node, Integer> map = graph.dictionary();
        ArrayList<Node> nodesOutputted = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<>();

        for(Node node: map.keySet()){
            if(map.get(node) == 0){
                //System.out.println(node.value);
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            Node first = queue.peek();
            //System.out.println(first.value);
            nodesOutputted.add(first);
            for(Node neighbor: first.neighbors){
                //System.out.println(neighbors.value);
                int val = map.get(neighbor);
                //System.out.println(val);
                val--;
                map.replace(neighbor, val);
            }
            first.numberOfEdges = -1;
            for(Node neigh: first.neighbors){
                if(map.get(neigh) == 0){
                    //System.out.println(neigh.value);
                    queue.add(neigh);
                }
            }
            System.out.print(first.value + "->");
            queue.remove(first);
        }

        return nodesOutputted;
    }


    ArrayList<Node> mDFS(final DirectedGraph graph){
        ArrayList<Node> nodesOutputted = new ArrayList<Node>();

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output= new Stack<Node>();
        for(Node node: graph.listOfNodes){
            if(!node.visited){
                output = DFSHelper(graph, node, stack);
            }
        }
        while(!output.empty()){
            Node node = output.pop();
            nodesOutputted.add(node);
        }
        return nodesOutputted;
    }

    Stack<Node> DFSHelper(final DirectedGraph graph, final Node node, final Stack<Node> stack){
        return stack;
    }




}