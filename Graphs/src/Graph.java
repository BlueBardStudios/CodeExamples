import java.lang.reflect.Array;
import java.util.ArrayList;

public class Graph implements GraphADT{
    ArrayList<Vertex> vertexList;
    ArrayList<Edge> edgeList;

    public Graph(){
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
        insertVertex("A");
        insertVertex("B");
        insertVertex("C");
        insertVertex("D");
        insertVertex("E");
        insertVertex("F");
        insertVertex("G");
        insertEdge(vertexList.get(0), vertexList.get(1), "A->B");
        insertEdge(vertexList.get(1), vertexList.get(2), "B->C");
        insertEdge(vertexList.get(1), vertexList.get(3), "B->D");
        insertEdge(vertexList.get(1), vertexList.get(4), "B->E");
        insertEdge(vertexList.get(2), vertexList.get(4), "C->E");
        insertEdge(vertexList.get(3), vertexList.get(4), "D->E");
        insertEdge(vertexList.get(4), vertexList.get(5), "E->F");
        insertEdge(vertexList.get(6), vertexList.get(3), "G->D");
    }

    @Override
    public Vertex insertVertex(String n) {
        Vertex v = new Vertex(n);
        vertexList.add(v);
        return v;
    }

    @Override
    public String removeVertex(Vertex v) {
        if (vertexList.contains(v)){
            vertexList.remove(v);
            return v.getName();
        }
        else{
        return null;
        }
    }

    @Override
    public Edge insertEdge(Vertex v, Vertex w, String n) {
        Edge e = new Edge(v, w, n);
        edgeList.add(e);
        return e;
    }

    @Override
    public String removeEdge(Edge e) {
        if (edgeList.contains(e)){
            edgeList.remove(e);
            return e.getName();
        }
        else{
            return null;
        }
    }

    @Override
    public Vertex opposite(Edge e, Vertex v) {
       if(edgeList.contains(e) == true) {
           if (e.getA() != v && e.getB() != v) {
               return null;
           } else if (e.getA() == v) {
               return e.getB();
           } else if (e.getB() == v) {
               return e.getA();
           }
       }
       return null;
    }


    @Override
    public ArrayList<Vertex> vertices() {

        for (int i = 0; i < vertexList.size(); i++){
        System.out.println(vertexList.get(i));
        }
        return vertexList;
    }

    @Override
    public ArrayList<Edge> edges() {
        for (int i = 0; i < edgeList.size(); i++){
            System.out.println(edgeList.get(i));
        }
        return edgeList;
    }

    @Override
    public boolean areAdjacent(Vertex v, Vertex w) {
        boolean adj = false;
        int i = 0;
        while(adj == false && i < edgeList.size()){
            if(edgeList.get(i).getA() == v){
                if(edgeList.get(i).getB() == w){
                    adj = true;
                }
            }
            else if(edgeList.get(i).getB() == v){
                if(edgeList.get(i).getA() == w){
                    adj = true;
                }
            }
            i++;
        }
        return adj;
    }

    @Override
    public ArrayList<Edge> incidentEdges(Vertex v) {
        ArrayList<Edge> eL = new ArrayList<>();
        for(int i = 0; i < edgeList.size(); i++){
            if(edgeList.get(i).getA() == v){
                eL.add(edgeList.get(i));
            }
            else if(edgeList.get(i).getB() == v){
                eL.add(edgeList.get(i));
            }
        }
        return eL;
    }

    @Override
    public String rename(Vertex v, String n) {
        String s = v.getName();
        v.setName(n);
        return s;
    }

    @Override
    public String rename(Edge e, String n) {
        String s = e.getName();
        e.setName(n);
        return s;
    }
}

