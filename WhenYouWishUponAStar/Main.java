package WhenYouWishUponAStar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.lang.Math;

class Main {

    static GridGraph createRandomGridGraph(int n){
        int size = n;
        GridGraph graph = new GridGraph();
        //create n^2 random nodes
        int start = 100;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                start++;
                graph.addGridNode(i, j, start); //(x,y,nodeVal)
            }
        }

        Random rand = new Random();
        for(Node node: graph.listOfNodes){
            if(node.x == 0 && node.y != size-1){
                if(node.y != 0){
                    int chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x, node.y-1));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x+1, node.y));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x, node.y+1));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                    }
                }else{
                    int chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x+1, node.y));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x, node.y+1));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                    }
                }
            }
            else if(node.x == 0 && node.y == size-1){
                int chance = rand.nextInt(2);
                if(chance == 1){
                    //node.neighbors.add(graph.getNodeWithXY(node.x, node.y-1));
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    //node.neighbors.add(graph.getNodeWithXY(node.x+1, node.y));
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                }
            }
            else if(node.x != 0 && node.y == 0){
                if(node.x == size-1 && node.y == 0){
                    int chance = rand.nextInt(2);
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x, node.y+1));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x-1, node.y));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x-1, node.y));
                    }
                }else{
                    int chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x+1, node.y));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        //node.neighbors.add(graph.getNodeWithXY(node.x, node.y+1));
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                    }
                }
            }
            else if(node.x == size-1 && node.y != 0){
                if(node.x == size-1 && node.y == size-1){
                    int chance = rand.nextInt(2);
                    if(chance == 1){
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x-1, node.y));
                    }
                }else{
                    int chance = rand.nextInt(2);
                    if(chance == 1){
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x-1, node.y));
                    }
                    chance = rand.nextInt(2);
                    if(chance == 1){
                        graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                    }
                }
            }
            else if(node.x != 0 && node.x != size-1 && node.y == size-1){
                int chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x-1, node.y));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                }
            }
            else{
                int chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y-1));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x, node.y+1));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x-1, node.y));
                }
                chance = rand.nextInt(2);
                if(chance == 1){
                    graph.addUndirectedEdge(node, graph.getNodeWithXY(node.x+1, node.y));
                }
            }

        }
        return graph;
    }

    static int manhattanDistance(Node currentSquare, Node goalSquare){
        return Math.abs(currentSquare.x-goalSquare.y) + Math.abs(currentSquare.y-goalSquare.y);
    }

    static ArrayList<Node> astar(final Node sourceNode, final Node destNode){
        ArrayList<Node> list = new ArrayList<Node>();
        HashMap<Node, Integer> distanceTable = new HashMap<Node, Integer>();
        HashMap<Node, Node> parentsTable = new HashMap<Node, Node>();
        HashMap<Node, Integer> heuristicTable = new HashMap<Node, Integer>();
        boolean ifFound = false;
        list.add(sourceNode);
        distanceTable.put(sourceNode, 0);
        heuristicTable.put(sourceNode, manhattanDistance(sourceNode, destNode));
        Stack<Node> stack = new Stack<Node>();
        stack.add(sourceNode);
        while(!stack.isEmpty() && !ifFound){
            Node node = stack.pop();
            node.visited = true;
            int minimum = 0;
            for(Node neighbor: node.neighbors){
                list.add(neighbor);
                //System.out.println(neighbor.value);
                int distance = distanceTable.get(node) + 1;
                if(!distanceTable.containsKey(neighbor)){
                    distanceTable.put(neighbor, distance);
                    parentsTable.put(neighbor, node);
                    heuristicTable.put(neighbor, manhattanDistance(neighbor, destNode));
                }else if(distanceTable.get(neighbor) > distance){
                    distanceTable.replace(neighbor, distance);
                    parentsTable.replace(neighbor, node);
                    heuristicTable.replace(neighbor, manhattanDistance(neighbor, destNode));
                }
                for(Node n: list){
                    if(minimum == 0 && !n.visited){
                        minimum = distanceTable.get(n) + heuristicTable.get(n);
                        if(list.size() == 1){
                            stack.add(n);
                        }
                    }
                    else if(distanceTable.get(n) + heuristicTable.get(n) < minimum && !n.visited){
                        minimum = distanceTable.get(n) + heuristicTable.get(n);
                        stack.add(n);
                    }
                }
                if(node == destNode && node.visited){
                    ifFound = true;
                }
            }
        }
        ArrayList<Node> path = new ArrayList<Node>();
        if(ifFound){
            Node parentOfDest =  parentsTable.get(destNode);
            //System.out.println(parentOfDest.value);
            path.add(destNode);
            path.add(parentOfDest);
            while(parentOfDest != sourceNode){
                parentOfDest = parentsTable.get(parentOfDest);
                path.add(parentOfDest);
            }
            path.add(sourceNode);

        }else{
            return null;
        }
        
        return path;
    }

    


    public static void main(String[] args) {
        

        GridGraph graph = createRandomGridGraph(100);
        /*
        System.out.println("(0,0)");
        for(Node neighbor: graph1.getNodeWithXY(0,0).neighbors){
            System.out.println(neighbor.value);
        }
        */
        astar(graph.getNodeWithXY(0, 0), graph.getNodeWithXY(99, 99));
        //for(Node node: path){
            //System.out.println(node);
        //}
        
    }
}