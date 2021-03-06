package UnoDoTreCuatroINodeYouWantMe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

class Main{


    static WeightedGraph createRandomCompleteWeightedGraph(final int n){ 
        WeightedGraph graph = new WeightedGraph(); //needs to be a complete weighted graph
        for(int i = 0; i<n; i++){
            graph.addNode(i);
        }

        Random rand = new Random(); //ONLY weights are RANDOM
        int counter = rand.nextInt(n);
        
        //need n(n-1) directed edges
        for(Node firstNode: graph.listOfNodes){
            for(Node secondNode: graph.listOfNodes){
                if(firstNode != secondNode){
                    int weight = rand.nextInt(Integer.MAX_VALUE);
                    graph.addWeightedEdge(firstNode, secondNode, weight);
                }
            }
        }

        return graph;
    }

    static WeightedGraph createdLinkedList(final int n){ 
        WeightedGraph graph = new WeightedGraph();

        for(int i = 0; i<n; i++){
            graph.addNode(i);
        }

        int size = n-1;
        for(int i = 0; i<size; i++){ //i<n returns IndexOutOfBoundsException, first and last node should only have 1 neighbor
            graph.addWeightedEdge(graph.listOfNodes.get(i), graph.listOfNodes.get(i+1), 1);
        }
        return graph;
    }

    /*
    LESSON 17 PSUEDOCODE
    function dijkstra(G, S)
        for each vertex V in G
            distance[V] ← infinite
            previous[V] ← NULL
            If V != S
                add V to Priority Queue Q
                distance[S] ← 0
            fi
        while Q IS NOT EMPTY
            U ← Extract MIN from Q
            for each unvisited neighbour V of U
                tempDistance ← distance[U] + edgeweight(U, V)
                if tempDistance < distance[V]
                    distance[V] ← tempDistance
                    previous[V] ← U
                fi
            rof
        eliwh
        return distance[], previous[]
    */

    /*
    MODIFIED PSUEDOCODE
    function dijkstra(G, S)
        distance[S] <-  0
        add S to Priority Queue
        while Q IS NOT EMPTY
            add V to Priority Queue Q
            U ← Extract MIN from Q
            for each unvisited neighbour V of U
                if NOT distance.contains[V]
                    tempDistance ← distance[U] + edgeweight(U, V)
                    distance[V] ← tempDistance
                else
                    tempDistance ← distance[U] + edgeweight(U, V)
                    if tempDistance < distance[V]
                        distance[V] ← tempDistance
                    else
                        distance[V] = distance[V]
                    fi
                fi
            rof
        eliwh
    return distance[]
    */

    static HashMap<Node, Integer> dijkstras(final Node start){
        //distance[S] <-  0
        HashMap<Node, Integer> distance = new HashMap<Node, Integer>();
        distance.put(start, 0);

        //add S to Priority Queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        //while Q IS NOT EMPTY
        while(!queue.isEmpty()){
            //U ← Extract MIN from Q
            Node node = queue.poll();
            node.visited = true;

            //for each unvisited neighbour V of U
            for(Node neighbor: node.neighbors){
                //add V to Priority Queue Q
                queue.add(neighbor);

                //if NOT distance.contains[V]
                if(!distance.containsKey(neighbor) && !neighbor.visited){
                    //tempDistance ← distance[U] + edgeweight(U, V)
                    int nodeDistanceToNeighborWeight = node.weights.get(neighbor);
                    int tempDistance = distance.get(node)+nodeDistanceToNeighborWeight;
                    //distance[V] ← tempDistance
                    distance.put(neighbor, tempDistance);
                }else{
                    //tempDistance ← distance[U] + edgeweight(U, V)
                    int nodeDistanceToNeighborWeight = node.weights.get(neighbor);
                    int tempDistance = distance.get(neighbor)+nodeDistanceToNeighborWeight;
                    //if tempDistance < distance[V]
                    if(tempDistance < distance.get(neighbor)){
                        //distance[V] ← tempDistance
                        distance.replace(neighbor, tempDistance);
                    }else{
                        //distance[V] = distance[V]
                        distance.replace(neighbor, distance.get(neighbor));
                    }
                }
                neighbor.visited = true;
            }
        }

        for (Map.Entry<Node, Integer> entry : distance.entrySet()) {
            System.out.println("Node = " + entry.getKey().value + ", Distance = " + entry.getValue());
        }

        //return distance[]
        return distance;
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

        graph.addWeightedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(4), 30);
        graph.addWeightedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(6), 50);
        graph.addWeightedEdge(graph.listOfNodes.get(1), graph.listOfNodes.get(3), 60);

        graph.addWeightedEdge(graph.listOfNodes.get(2), graph.listOfNodes.get(5), 60);

        graph.addWeightedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(5), 100);
        graph.addWeightedEdge(graph.listOfNodes.get(3), graph.listOfNodes.get(6), 60);

        graph.addWeightedEdge(graph.listOfNodes.get(4), graph.listOfNodes.get(6), 70);

        graph.addWeightedEdge(graph.listOfNodes.get(5), graph.listOfNodes.get(6), 60);


        for(Node node: graph.listOfNodes){
            System.out.println("Node: " + node.value);
            HashMap<Node, Integer> map = node.weights;
            for (Map.Entry<Node, Integer> entry : map.entrySet()) {
                System.out.println("Neighbor = " + entry.getKey().value + ", Weight = " + entry.getValue());
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        dijkstras(graph.listOfNodes.get(0));
        System.out.println("---------------------------------");
        
        
        WeightedGraph graph2 = createRandomCompleteWeightedGraph(5);
        for(Node node: graph2.listOfNodes){
            System.out.println("Node: " + node.value);
            HashMap<Node, Integer> map = node.weights;
            for (Map.Entry<Node, Integer> entry : map.entrySet()) {
                System.out.println("Neighbor = " + entry.getKey().value + ", Weight = " + entry.getValue());
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

        WeightedGraph graph3 = createdLinkedList(10);
        for(Node node: graph3.listOfNodes){
            System.out.println("Node: " + node.value);
            HashMap<Node, Integer> map = node.weights;
            for (Map.Entry<Node, Integer> entry : map.entrySet()) {
                System.out.println("Neighbor = " + entry.getKey().value + ", Weight = " + entry.getValue());
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        dijkstras(graph3.listOfNodes.get(0));
        System.out.println("---------------------------------");
        

    }
}