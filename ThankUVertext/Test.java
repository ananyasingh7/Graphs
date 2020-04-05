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


        //0
        graph.addDirectedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(6));
        graph.addDirectedEdge(graph.listOfNodes.get(7), graph.listOfNodes.get(0));
        //1
        graph.addDirectedEdge(graph.listOfNodes.get(5), graph.listOfNodes.get(1));
        graph.addDirectedEdge(graph.listOfNodes.get(7), graph.listOfNodes.get(1));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(6));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(4));
        graph.addDirectedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(2));

        //2

        //3
        graph.addDirectedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(0));
        graph.addDirectedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(4));

        //4

        //5
        
        //6
        
        for(Node node: graph.listOfNodes.get(1).neighbors){
            for(int i = 0; i<node.neighbors.size(); i++){
                System.out.println(node.neighbors.get(i).value);
            }
        }




        ArrayList<Node> run1 = top.Kahns(graph);
        for(Node node: run1){
            //System.out.println(node.value);
        }
    }
}