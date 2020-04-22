package WhenYouWishUponAStar;

import java.util.ArrayList;

class Node {

    int value;
    boolean visited;
    ArrayList<Node> neighbors;
    int x;
    int y;

    public Node(int x, int y, int value){
        this.value = value;
        this.visited = false;
        this.neighbors = new ArrayList<Node>();
        this.x = x;
        this.y = y;
    }

}