package ThankUVertext;

import java.util.Random;


public class Main {

    static DirectedGraph createRandomDAGIter(final int n){
        DirectedGraph graph = new DirectedGraph();

        for(int i = 0; i<n; i++){
            graph.addNode(i);
        }
        Random rand = new Random();
        int counter = rand.nextInt(n);

        while(counter > 0){
            int randomNode1 = rand.nextInt(n);
            int randomNode2 = rand.nextInt(n);
            if(randomNode1 != randomNode2){
                graph.addDirectedEdge(graph.listOfNodes.get(randomNode1), graph.listOfNodes.get(randomNode2));
                counter--;
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        DirectedGraph graphRandom = createRandomDAGIter(30);
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