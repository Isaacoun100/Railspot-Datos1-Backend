package com.itcr.datos.railspot.dataStructures;

public class GraphNode<T>{

    private final T name;
    private SinglyList<GraphEdge<T>> vertex = new SinglyList<>();

    public GraphNode(T name) { this.name = name; }

    public void setVertex(SinglyList<GraphEdge<T>> vertex) { this.vertex = vertex; }

    public T getName() { return name; }

    public SinglyList<GraphEdge<T>> getVertex() { return vertex; }

    public void addEdge(GraphNode<T> from, GraphNode<T> to, int weight){
        GraphEdge<T> toEdge =  new GraphEdge<>(to,weight);
        GraphEdge<T> fromEdge =  new GraphEdge<>(from,weight);
        from.addEdge(toEdge);
        to.addEdge(fromEdge);

    }

    public void addEdge(GraphEdge<T> edge){
        vertex.add(edge);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name=" + name +
                ", vertex=" + vertex +
                '}';
    }
}
