import java.util.HashSet;


class Main{

    public static void main(String[] args) {
        Graph graph1 = new Graph(); //graph1 is the example graph from question 1, 0 is the source, 9 is the destination

        for(int i = 0; i<10; i++){
            graph1.addNode(i);
        }

        //adding undirected edges
        graph1.addUndirectedEdge(graph1.listOfNodes.get(0), graph1.listOfNodes.get(1));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(1), graph1.listOfNodes.get(2));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(1), graph1.listOfNodes.get(3));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(1), graph1.listOfNodes.get(4));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(3), graph1.listOfNodes.get(4));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(4), graph1.listOfNodes.get(5));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(5), graph1.listOfNodes.get(6));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(6), graph1.listOfNodes.get(7));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(7), graph1.listOfNodes.get(8));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(8), graph1.listOfNodes.get(9));


        for (int i = 0; i<graph1.listOfNodes.size(); i++){
            System.out.println("size of neighbors of Node " + i + " is: " + graph1.listOfNodes.get(i).neighbors.size());
        }

        System.out.println("\n\n");
        System.out.println("Neighbors of node 1 are: ");
        for (int i = 0; i<graph1.listOfNodes.get(1).neighbors.size(); i++){
            System.out.println(graph1.listOfNodes.get(1).neighbors.get(i).value);
        }

        System.out.println("\n\n");
        System.out.println("Removing edge between 1 and 2");
        graph1.removeUndirectedEdge(graph1.listOfNodes.get(1), graph1.listOfNodes.get(2));
        System.out.println("After Removal");
        System.out.println("Neighbors of node 1 are: ");
        for (int i = 0; i<graph1.listOfNodes.get(1).neighbors.size(); i++){
            System.out.println(graph1.listOfNodes.get(1).neighbors.get(i).value);
        }

        System.out.println("\n\n");
        System.out.println("Removing edge between 4 and 3");
        graph1.removeUndirectedEdge(graph1.listOfNodes.get(4), graph1.listOfNodes.get(3));
        System.out.println("After Removal");
        System.out.println("Neighbors of node 4 are: ");
        for (int i = 0; i<graph1.listOfNodes.get(4).neighbors.size(); i++){
            System.out.println(graph1.listOfNodes.get(4).neighbors.get(i).value);
        }

        System.out.println("\n\n");
        System.out.println("Removing edge between 1 and 3");
        graph1.removeUndirectedEdge(graph1.listOfNodes.get(1), graph1.listOfNodes.get(3));
        System.out.println("After Removal");
        System.out.println("Neighbors of node 3 are: ");
        for (int i = 0; i<graph1.listOfNodes.get(3).neighbors.size(); i++){
            System.out.println(graph1.listOfNodes.get(3).neighbors.get(i).value);
        }

        System.out.println("\n\n");
        for (int i = 0; i<graph1.listOfNodes.size(); i++){
            System.out.println("size of neighbors of Node " + i + " is: " + graph1.listOfNodes.get(i).neighbors.size());
        }

        
        
    }
}