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

    }

    void removeDirectedEdge(final Node first, final Node second){

    }

    HashSet<Node> getAllNodes(){
        HashSet<Node> nodes = new HashSet<Node>(listOfNodes);
        return nodes;
    }


}