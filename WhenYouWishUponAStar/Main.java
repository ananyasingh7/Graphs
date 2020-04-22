package WhenYouWishUponAStar;

class Main {

    public static void main(String[] args) {
        GridGraph graph = new GridGraph();
        graph.addGridNode(0, 0, 100);
        graph.addGridNode(0, 1, 101);
        graph.addGridNode(0, 2, 102);
        graph.addGridNode(0, 3, 103);
        graph.addGridNode(0, 4, 104);
        graph.addGridNode(1, 0, 105);
        graph.addGridNode(1, 1, 106);
        graph.addGridNode(1, 2, 107);
        graph.addGridNode(1, 3, 108);
        graph.addGridNode(1, 4, 109);
        graph.addGridNode(2, 0, 110);
        graph.addGridNode(2, 1, 111);
        graph.addGridNode(2, 2, 112);
        graph.addGridNode(2, 3, 113);
        graph.addGridNode(2, 4, 114);
        graph.addGridNode(3, 0, 115);
        graph.addGridNode(3, 1, 116);
        graph.addGridNode(3, 2, 117);
        graph.addGridNode(3, 3, 118);
        graph.addGridNode(3, 4, 119);
        graph.addGridNode(4, 0, 120);
        graph.addGridNode(4, 1, 121);
        graph.addGridNode(4, 2, 122);
        graph.addGridNode(4, 3, 123);
        graph.addGridNode(4, 4, 124);

        //graph.addUndirectedEdge(graph.listOfNodes.get(100), graph.listOfNodes.get(105));
        System.out.println(graph.listOfNodes.get(5).value);

    }
}