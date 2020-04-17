package UnoDoTreCuatroINodeYouWantMe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node{

    int value;
    boolean visited;
    ArrayList<Node> neighbors;
    Map<Node, Integer> weights;

    public Node(int value){
        this.value = value;
        this.visited = false;
        this.neighbors = new ArrayList<Node>();
        this.weights = new HashMap<Node, Integer>();
    }

}