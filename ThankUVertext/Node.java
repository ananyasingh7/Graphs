package ThankUVertext;

import java.util.ArrayList;

class Node{

    int value;
    int numberOfEdges;
    boolean visited;
    ArrayList<Node> neighbors;

    public Node(int value){
        this.value = value;
        this.visited = false;
        this.neighbors = new ArrayList<Node>();
        this.numberOfEdges = 0;
    }

}