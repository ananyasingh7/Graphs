package UnoDoTreCuatroINodeYouWantMe;

import java.util.ArrayList;
import java.util.HashMap;

class Node{

    int value;
    boolean visited;
    ArrayList<Node> neighbors;
    HashMap<Node, Integer> weights;

    public Node(int value){
        this.value = value;
        this.visited = false;
        this.neighbors = new ArrayList<Node>();
        this.weights = new HashMap<Node, Integer>();
    }

}