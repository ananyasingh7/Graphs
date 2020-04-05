package ThankUVertext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class DirectedGraph {

    ArrayList<Node> listOfNodes;
    public DirectedGraph(){
        listOfNodes = new ArrayList<Node>();
    }

    void addNode(final int nodeVal){
        Node newNode = new Node(nodeVal);
        listOfNodes.add(newNode);
    }

    void addDirectedEdge(final Node first, final Node second){
        if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
            first.neighbors.add(second);
            first.numberOfEdges++;
        }
    }

    void removeDirectedEdge(final Node first, final Node second){
        if(ifExists(first) && ifExists(second) && !checkNeighbor(first, second)){
            first.neighbors.remove(first);
            first.numberOfEdges--;
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

    int getNumberOfEdges(Node node){
        return node.numberOfEdges;
    }

    void decreaseNumberOfEdges(Node node){
        node.numberOfEdges--;
    }

    HashMap<Node, Integer> dictionary(){
        HashMap<Node, Integer> dict = new HashMap<>();

        for(int i = 0; i<listOfNodes.size(); i++){
            dict.put(listOfNodes.get(i), 0);
        }
        for(Node node: listOfNodes){
            for(Node neighbor: node.neighbors){
                dict.replace(neighbor, dict.get(neighbor)+1); //replace neighbor edges, not the actual node edges dumbass
            }
        }

        return dict;
    }

    void resetVisited(){
        for(Node node: listOfNodes){
            node.visited = false;
        }
    }

}