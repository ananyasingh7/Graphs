import java.util.ArrayList;

class Test{
    
    public static void main(String[] args) {
        Graph graph1 = new Graph(); //graph1 is the example graph from question 1, 0 is the source, 9 is the destination
        Graph graph2 = new Graph(); //graph2 is from WilliamFiset YouTube Video example
        GraphSearch graphSearchtest = new GraphSearch();

        for(int i = 0; i<10; i++){
            graph1.addNode(i);
        }

        for(int j = 0; j<13; j++){
            graph2.addNode(j);
        }

        //adding undirected edges
        graph1.addUndirectedEdge(graph1.listOfNodes.get(5), graph1.listOfNodes.get(3));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(4), graph1.listOfNodes.get(3));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(2), graph1.listOfNodes.get(3));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(3), graph1.listOfNodes.get(9));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(2), graph1.listOfNodes.get(9));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(7), graph1.listOfNodes.get(9));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(7), graph1.listOfNodes.get(6));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(6), graph1.listOfNodes.get(1));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(0), graph1.listOfNodes.get(1));
        graph1.addUndirectedEdge(graph1.listOfNodes.get(0), graph1.listOfNodes.get(8));
        
        graph2.addUndirectedEdge(graph2.listOfNodes.get(10), graph2.listOfNodes.get(1));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(10), graph2.listOfNodes.get(9));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(1), graph2.listOfNodes.get(8));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(9), graph2.listOfNodes.get(8));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(9), graph2.listOfNodes.get(0));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(8), graph2.listOfNodes.get(12));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(0), graph2.listOfNodes.get(7));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(12), graph2.listOfNodes.get(2));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(2), graph2.listOfNodes.get(3));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(0), graph2.listOfNodes.get(11));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(7), graph2.listOfNodes.get(11));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(3), graph2.listOfNodes.get(7));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(7), graph2.listOfNodes.get(6));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(3), graph2.listOfNodes.get(4));
        graph2.addUndirectedEdge(graph2.listOfNodes.get(6), graph2.listOfNodes.get(5));


        System.out.print("BFT Iterative for Graph 1: ");
        graphSearchtest.BFTIter(graph1);
        graph1.resetVisited();
        System.out.println("");
        System.out.print("BFT Recursive for Graph 1: ");
        graphSearchtest.BFTRec(graph1);
        graph1.resetVisited();
        System.out.println("");
        System.out.print("BFT Iterative for Graph 2: ");
        graphSearchtest.BFTIter(graph2);
        graph2.resetVisited();
        System.out.println("");
        System.out.print("BFT Recursive for Graph 2: ");
        graphSearchtest.BFTRec(graph2);
        graph2.resetVisited();
        graph1.resetVisited();
        System.out.println("\n");
        System.out.print("DFS Iterative for Graph 1: ");
        ArrayList<Node> lst = graphSearchtest.DFSIter(graph1.listOfNodes.get(4), graph1.listOfNodes.get(8));
        for(Node node: lst){
            System.out.print(node.value + "->");
        }
        graph1.resetVisited();
        graph2.resetVisited();
        System.out.println("");
        System.out.print("DFS Iterative for Graph 2: ");
        ArrayList<Node> lst2 = graphSearchtest.DFSIter(graph2.listOfNodes.get(10), graph2.listOfNodes.get(5));
        for(Node node: lst2){
            System.out.print(node.value + "->");
        }
        graph1.resetVisited();
        graph2.resetVisited();
        System.out.println("");
        System.out.print("DFS Recursive for Graph 1: ");
        ArrayList<Node> lst3 = graphSearchtest.DFSRec(graph1.listOfNodes.get(4), graph1.listOfNodes.get(8));
        for(Node node: lst3){
            System.out.print(node.value + "->");
        }
        graph1.resetVisited();
 
    }
}