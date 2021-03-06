package TraverseThisTown;

import java.util.ArrayList;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Stack;


public class GraphSearch {

    public GraphSearch(){

    }

    //TO DO
    ArrayList<Node> DFSRec(final Node start, final Node end){
        ArrayList<Node> path = new ArrayList<>();
        return DFSRecHelper(start, end, path);
    }

    ArrayList<Node> DFSRecHelper(final Node start, final Node end, ArrayList<Node> path){
        return path;
    }


    
    //modified lesson 10 DFS psuedocode to revolve around the stack instead of Graph
    ArrayList<Node> DFSIter(final Node start, final Node end){ //which ITERATIVELY returns an ArrayList of the Nodes in the Graph in a valid Depth-First Search order
        //Since not allowed to use graph, push (stack.push) start FIRST to the stack
        Stack<Node> stack = new Stack <Node>();
        start.visted = true;
        stack.push(start);
        ArrayList<Node> nullArray = new ArrayList<>();
        ArrayList<Node> path = new ArrayList<>();
        int finalDestination = end.value;
        while(!stack.isEmpty()){
            Node current = stack.pop();
            path.add(current);
            System.out.print(current.value+"->");
            for(Node neighbor: current.neighbors){
                if(!neighbor.visted){
                    neighbor.visted = true;
                    stack.push(neighbor);
                }
            }
            if(current.value == finalDestination){
                return path;
            }
        }

        return null; //returns null if path doesn't exist
    }




    ArrayList<Node> BFTRec(final Graph graph){ //which recursively returns an ArrayList of the Nodes in the Graphi n a valid Breadth-First Traversal order.
        ArrayList<Node> vistedNodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;
        ArrayList<Node> arrayWithoutDisconnected = BFTRecHelper(vistedNodes, queue, flag, graph);
        for(Node node: graph.listOfNodes){
            if(node.visted == false){
                arrayWithoutDisconnected.add(node); //to account for disconnected nodes (code review amend)
            }
        }
        return arrayWithoutDisconnected;
    }

    ArrayList<Node> BFTRecHelper(ArrayList<Node> visitedNodes, Queue<Node> queue, boolean flag, Graph graph){ //which recursively returns an ArrayList of the Nodes in the Graphi n a valid Breadth-First Traversal order.
        Node first = graph.listOfNodes.get(0);
        if(!queue.contains(first) && !flag){ //add first node
            System.out.print(first.value + "->");
            queue.add(first);
        }
        Node current = queue.poll();
        current.visted = true;
        visitedNodes.add(current);
        for(Node neighbor: current.neighbors){
            if(!neighbor.visted){
                neighbor.visted = true;
                System.out.print(neighbor.value + "->");
                queue.add(neighbor);
            }
        }
        if(queue.isEmpty()){ //base case
            return visitedNodes;
        }
        return BFTRecHelper(visitedNodes, queue, true, graph);
    }


    //lecture notes 10 Psuedocode
    ArrayList<Node> BFTIter(final Graph graph){ //which iteratively returns an ArrayList of all of the Nodes in the Graph in a valid Breadth-First Traversal
        ArrayList<Node> vistedNodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        for(Node node : graph.listOfNodes){
            if(!node.visted){
                System.out.print(node.value + "->");
                node.visted = true;
                vistedNodes.add(node);
                queue.add(node);
            }
            while(!queue.isEmpty()){
                Node current = queue.poll();
                for(Node neighbor: current.neighbors){
                    if(!neighbor.visted){
                        System.out.print(neighbor.value + "->");
                        neighbor.visted = true;
                        queue.add(neighbor);
                        vistedNodes.add(neighbor);
                    }
                }
            }
        }
        return vistedNodes;
    }

    

}