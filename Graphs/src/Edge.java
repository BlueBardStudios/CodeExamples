public class Edge {
    private Vertex A;
    private Vertex B;
    private String name;

    public Edge(Vertex a, Vertex b, String n){
        A = a;
        B = b;
        name = n;
    }

    public String getName(){return name;}
    public void setName(String n){name = n;}
    public Vertex getA(){return A;}
    public Vertex getB(){return B;}
}
