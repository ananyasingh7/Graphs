import java.util.ArrayList;

class Node{

    int value;
    Node parent;
    boolean visted;
    ArrayList<Node> neighbors;

    public Node(int value){
        this.value = value;
        this.visted = false;
        this.parent = null;
        this.neighbors = new ArrayList<Node>();
    }

}