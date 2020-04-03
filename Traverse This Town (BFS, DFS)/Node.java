import java.util.ArrayList;

class Node{

    int value;
    boolean visted;
    ArrayList<Node> neighbors;

    public Node(int value){
        this.value = value;
        this.visted = false;
        this.neighbors = new ArrayList<Node>();
    }

}