package UnoDoTreCuatroINodeYouWantMe;

import java.util.HashMap;
import java.util.Map;

class Main{


    WeightedGraph createRandomCompleteWeightedGraph(final int n){
        WeightedGraph graph = new WeightedGraph();
        return graph;
    }

    WeightedGraph createdLinkedList(final int n){
        WeightedGraph graph = new WeightedGraph();
        return graph;
    }

    HashMap<Node, Integer> dijkstras(final Node start){
        HashMap<Node, Integer> map = new HashMap<Node, Integer>();
        return map;
    }


    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        
        for(int i = 0; i<7; i++){
            graph.addNode(i);
        }

        graph.addWeightedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(1), 20);
        graph.addWeightedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(3), 70);
        graph.addWeightedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(5), 50);
        graph.addWeightedEdge(graph.listOfNodes.get(0), graph.listOfNodes.get(2), 40);


        //get neighbors
        for(Node node: graph.listOfNodes){
            System.out.println("Node: " + node.value);
            Map<Node, Integer> map = node.weights;
            for (Map.Entry<Node, Integer> entry : map.entrySet()) {
                System.out.println("Neighbor = " + entry.getKey().value + ", Weight = " + entry.getValue());
            }
            System.out.println();
        }

    }
}