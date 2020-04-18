package ThankUVertext;

import java.util.ArrayList;
import java.util.HashMap;

class Test {

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        TopSort top = new TopSort();
        for(int i = 0; i<8; i++){
            graph.addNode(i);
        }


        //Node 0 neighbors
        graph.addDirectedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(6));
        graph.addDirectedEdge(graph.listOfNodes.get(7), graph.listOfNodes.get(0));

        //Node 1 neighbors
        graph.addDirectedEdge(graph.listOfNodes.get(5), graph.listOfNodes.get(1));
        graph.addDirectedEdge(graph.listOfNodes.get(7), graph.listOfNodes.get(1));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(6));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(4));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(2));

        //Node 2 neighbors

        //Node 3 neighbors
        graph.addDirectedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(0));
        graph.addDirectedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(4));

        //Node 4 neighbors

        //Node 5 neighbors
        
        //Node 6 neighbors

        top.Kahns(graph);
        graph.resetVisited();
        System.out.println();
        top.mDFS(graph);
        graph.resetVisited();
    }
}