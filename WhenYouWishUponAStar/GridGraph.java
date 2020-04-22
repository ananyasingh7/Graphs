package WhenYouWishUponAStar;

import java.util.ArrayList;
import java.util.HashSet;

class GridGraph {

    ArrayList<Node> listOfNodes;

    public GridGraph(){
        listOfNodes = new ArrayList<Node>();
    }

    void addGridNode(final int x, final int y, final int nodeVal){
        Node newNode = new Node(x,y, nodeVal);
        listOfNodes.add(newNode); 
    }

    void addUndirectedEdge(final Node first, final Node second){
        if(first.x == second.x){
            if(second.y-first.y == 1){
                if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
                    first.neighbors.add(second);
                    second.neighbors.add(first);
                }
            }
            else if(first.y-second.y == 1){
                if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
                    first.neighbors.add(second);
                    second.neighbors.add(first);
                }
            }
            else{
                System.out.println("You cannot form an edge here because these nodes are not neighbors in the graph!");
            }
        }else if(first.y == second.y){
            if(second.x-first.x == 1){
                if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
                    first.neighbors.add(second);
                    second.neighbors.add(first);
                }
            }
            else if(first.x-second.x == 1){
                if(ifExists(first) && ifExists(second) && checkNeighbor(first, second)){
                    first.neighbors.add(second);
                    second.neighbors.add(first);
                }
            }
            else{
                System.out.println("You cannot form an edge here because these nodes are not neighbors in the graph!");
            }
        }else{
            System.out.println("You cannot form an edge here because these nodes are not neighbors in the graph!");
        }
    }

    void removeUndirectedEdge(final Node first, final Node second){

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
        if(first.neighbors.contains(second) || second.neighbors.contains(first)){
            return false;
        }else{
            return true;
        }
    }

    void resetVisited(){
        for(Node node: listOfNodes){
            node.visited = false;
        }
    }

}