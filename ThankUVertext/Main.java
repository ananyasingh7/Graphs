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
            graph.addDirectedEdge(graph.listOfNodes.get(randomNode1), graph.listOfNodes.get(randomNode2));
            counter--;
        }

        return graph;
    }

    public static void main(String[] args) {

        DirectedGraph graph = createRandomDAGIter(10);
        
    }
}