package ThankUVertext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TopSort {

    ArrayList<Node> Kahns(final DirectedGraph graph){
        HashMap<Node, Integer> map = graph.dictionary();
        ArrayList<Node> nodesOutputted = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<>();

        for(Node node: map.keySet()){
            if(map.get(node) == 0){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){ //FIFO 
            Node first = queue.peek();
            nodesOutputted.add(first);
            for(Node neighbor: first.neighbors){
                int val = map.get(neighbor);
                val--;
                map.replace(neighbor, val);
            }
            first.numberOfEdges = -1;
            for(Node neigh: first.neighbors){
                if(map.get(neigh) == 0){
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
                output = DFSHelper(node, stack);
            }
        }
        while(!output.empty()){
            Node node = output.pop();
            System.out.print(node.value + "->");
            nodesOutputted.add(node);
        }
        return nodesOutputted;
    }

    Stack<Node> DFSHelper(final Node node, final Stack<Node> stack){
        node.visited = true;
        for(Node neighbor: node.neighbors){
            if(!neighbor.visited){
                DFSHelper(neighbor, stack);
            }
        }
        stack.add(node);
        return stack;
    }

}