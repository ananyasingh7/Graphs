package TraverseThisTown;

import java.util.Random;
import java.util.ArrayList;


class Main{

    static Graph createRandomUnweightedGraphIter(int n){ //creates n random nodes with randomly assigned unweighted,  bidirectional edges
        Graph graph = new Graph();

        for(int i = 0; i<n; i++){
            graph.addNode(i);
        }
        Random rand = new Random();
        int counter = rand.nextInt(n);

        while(counter > 0){
            int randomNode1 = rand.nextInt(n);
            int randomNode2 = rand.nextInt(n);
            graph.addUndirectedEdge(graph.listOfNodes.get(randomNode1), graph.listOfNodes.get(randomNode2));
            counter--;
        }

        return graph;
    }

    static Graph createLinkedList(int n){
        Graph graph = new Graph();
        for(int i = 0; i<n; i++){
            graph.addNode(i);
        }

        int size = n-1;
        for(int i = 0; i<size; i++){ //i<n returns IndexOutOfBoundsException, first and last node should only have 1 neighbor
            graph.addUndirectedEdge(graph.listOfNodes.get(i), graph.listOfNodes.get(i+1));
        }
        return graph;
    }

    static ArrayList<Node> BFTRecLinkedList(final Graph graph){
        GraphSearch graphSearchtest = new GraphSearch();
        Graph graph1 = createLinkedList(10000);
        return graphSearchtest.BFTRec(graph1);
    }

    static ArrayList<Node> BFTIterLinkedList(final Graph graph){
        GraphSearch graphSearchtest = new GraphSearch();
        Graph graph1 = createLinkedList(10000);
        return graphSearchtest.BFTIter(graph1);
    }




    public static void main(String[] args) {
        Graph graph1 = new Graph();
        BFTIterLinkedList(graph1);
        //BFTRecLinkedList(graph1);
    }
}