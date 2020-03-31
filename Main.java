import java.util.Random;

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

    




    public static void main(String[] args) {
        int n = 5;
        Graph graph1 = createRandomUnweightedGraphIter(n);
        for (int i = 0; i<graph1.listOfNodes.size(); i++){
            System.out.println("size of neighbors of Node " + i + " is: " + graph1.listOfNodes.get(i).neighbors.size());
        }
        System.out.println("\n\n");
        int counter = n;
        for(int j = 0; j<counter; j++){
            System.out.println("Neighbors of node " + j + " are: ");
            for (int i = 0; i<graph1.listOfNodes.get(j).neighbors.size(); i++){
                System.out.println(graph1.listOfNodes.get(j).neighbors.get(i).value);
            }
        }

        
    }
}