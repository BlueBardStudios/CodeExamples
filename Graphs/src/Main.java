public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        for(int i = 0; i < graph.vertexList.size(); i++){
            System.out.println(graph.vertexList.get(i).getName());
        }
        for(int i = 0; i < graph.edgeList.size(); i++){
            System.out.println(graph.edgeList.get(i).getA().getName() + " -> " + graph.edgeList.get(i).getB().getName());
        }
    }
}
