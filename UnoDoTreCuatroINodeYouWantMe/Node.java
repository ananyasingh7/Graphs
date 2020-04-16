package UnoDoTreCuatroINodeYouWantMe;

import java.util.ArrayList;
import java.util.HashMap;

class Node{

    int value;
    boolean visted;
    ArrayList<Node> neighbors;
    HashMap<Node, Integer> weights;

    public Node(int value){
        this.value = value;
        this.visted = false;
        this.neighbors = new ArrayList<Node>();
        this.weights = new HashMap<Node, Integer>();
    }

}