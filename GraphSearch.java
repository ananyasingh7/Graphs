import java.util.ArrayList;
import java.util.LinkedList; 
import java.util.Queue; 

public class GraphSearch {

    public GraphSearch(){

    }

    ArrayList<Node> DFSRec(final Node start, final Node end){
        ArrayList<Node> list = new ArrayList<>();
        return list;
    }

    ArrayList<Node> DFSIter(final Node start, final Node end){
        ArrayList<Node> list = new ArrayList<>();
        return list;
    }



    ArrayList<Node> BFTRec(final Graph graph){ //which recursively returns an ArrayList of the Nodes in the Graphi n a valid Breadth-First Traversal order.
        ArrayList<Node> vistedNodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;
        return BFTRecHelper(vistedNodes, queue, flag, graph);
    }

    ArrayList<Node> BFTRecHelper(ArrayList<Node> visitedNodes, Queue<Node> queue, boolean flag, Graph graph){ //which recursively returns an ArrayList of the Nodes in the Graphi n a valid Breadth-First Traversal order.
        Node first = graph.listOfNodes.get(0);
        if(!queue.contains(first) & !flag){ //add first node
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


    //used lecture notes 10 Psuedocode
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
                for(Node checkNode: current.neighbors){
                    if(!checkNode.visted){
                        System.out.print(checkNode.value + "->");
                        checkNode.visted = true;
                        queue.add(checkNode);
                        vistedNodes.add(checkNode);
                    }
                }
            }
        }
        return vistedNodes;
    }

    

}