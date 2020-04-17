package UnoDoTreCuatroINodeYouWantMe;

import java.util.HashSet;
import java.util.ArrayList;

class WeightedGraph{

    ArrayList<Node> listOfNodes;

    public WeightedGraph(){
        listOfNodes = new ArrayList<Node>();
    }
    
    void addNode(final int nodeVal){
        Node newNode = new Node(nodeVal);
        listOfNodes.add(newNode);
    }

    void addWeightedEdge(final Node first, final Node second, final int edgeWeight){
        if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
            first.neighbors.add(second);
            first.weights.put(second, edgeWeight);
        }
    }

    void removeDirectedEdge(final Node first, final Node second){
        if(ifExists(first) && ifExists(second) && !checkNeighbor(first, second)){
            first.neighbors.remove(second);
            first.weights.remove(second);
        }
    }

    HashSet<Node> getAllNodes(){
        HashSet<Node> nodes = new HashSet<Node>(listOfNodes);
        return nodes;
    }

    //helper functions
    boolean ifExists(Node node){
        if(listOfNodes.contains(node)){
            return true;
        }else{
            return false;
        }
    }

    boolean checkNeighbor(Node first, Node second){
        if(first.neighbors.contains(second)){
            return false;
        }else{
            return true;
        }
    }

    void resetVisited(){
        for(Node node: listOfNodes){
            node.visited = false;
        }
    }


}