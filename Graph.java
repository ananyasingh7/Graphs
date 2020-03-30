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
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    void removeUndirectedEdge(final Node first, final Node second){ //removes an undirected edge between first and second
        first.neighbors.remove(second);
        second.neighbors.remove(first);
    }

    HashSet<Node> getAllNodes(){ //returns all the Nodes in the graph
        HashSet<Node> nodes = new HashSet<Node>(listOfNodes);
        return nodes;
    }

    



}