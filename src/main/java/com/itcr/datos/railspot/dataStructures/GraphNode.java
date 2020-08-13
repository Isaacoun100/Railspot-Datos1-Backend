package com.itcr.datos.railspot.dataStructures;

/**
 * GraphNode represents the Nodes that will be connected
 * @param <T>
 */
public class GraphNode<T>{

    private final T name;
    private SinglyList<GraphEdge<T>> vertex = new SinglyList<>();

    /**
     * Constructor for the class
     * @param name
     */
    public GraphNode(T name) { this.name = name; }

    /**
     * Setter for the Vextex singlyList
     * @param vertex
     */
    public void setVertex(SinglyList<GraphEdge<T>> vertex) { this.vertex = vertex; }

    /**
     * Getter for the name String
     * @return
     */
    public T getName() { return name; }

    /**
     * Getter for the vertex SinglyList
     * @return
     */
    public SinglyList<GraphEdge<T>> getVertex() { return vertex; }

    /**
     * This will connect two nodes
     * @param from
     * @param to
     * @param weight
     */
    public void addEdge(GraphNode<T> from, GraphNode<T> to, int weight){
        GraphEdge<T> toEdge =  new GraphEdge<>(to,from,weight);
        GraphEdge<T> fromEdge =  new GraphEdge<>(from, to,weight);
        from.addEdge(toEdge);
        to.addEdge(fromEdge);

    }

    /**
     * This will add an edge
     * @param edge
     */
    public void addEdge(GraphEdge<T> edge){
        vertex.add(edge);
    }

    /**
     * This method prints the tree in way that is more humane tp understand.
     * @param prefix
     * @param isTail
     * @param sb
     * @param head
     * @return
     */
    @Override
    public String toString() {
        return "GraphNode{" +
                "name=" + name +
                ", vertex=" + vertex +
                '}';
    }
}
