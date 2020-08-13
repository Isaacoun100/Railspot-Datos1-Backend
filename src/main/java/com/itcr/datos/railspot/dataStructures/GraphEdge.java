package com.itcr.datos.railspot.dataStructures;

public class GraphEdge<T> {

    private final GraphNode<T> goingTo;
    private final int weight;

    public GraphEdge(GraphNode<T> goingTo, int weight) {
        this.goingTo = goingTo;
        this.weight = weight;
    }

    public GraphNode<T> getGoingTo() {
        return goingTo;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "goingTo=" + goingTo +
                ", weight=" + weight +
                '}';
    }
}
