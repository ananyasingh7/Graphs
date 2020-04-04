package TraverseThisTown;

import java.util.ArrayList;
import java.util.HashSet;

class Graph{

    ArrayList<Node> listOfNodes;
    public Graph(){
        listOfNodes = new ArrayList<Node>();
    }

    void addNode(final int nodeVal){ //adds a new node to the Graph
        Node newNode = new Node(nodeVal);
        listOfNodes.add(newNode);
    }

    void addUndirectedEdge(final Node first, final Node second){ //adds an undirected edge between first and second
        if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
            first.neighbors.add(second);
            second.neighbors.add(first);
        }

    }

    void removeUndirectedEdge(final Node first, final Node second){ //removes an undirected edge between first and second
        if(ifExists(first) && ifExists(second) && !checkNeighbor(first, second)){
            first.neighbors.remove(second);
            second.neighbors.remove(first);
        }
    }

    HashSet<Node> getAllNodes(){ //returns all the Nodes in the graph
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
        }else if((second.neighbors.contains(first))){
            return false;
        }else{
            return true;
        }
    }

    void resetVisited(){
        for(Node node: listOfNodes){
            node.visted = false;
        }
    }

    



}