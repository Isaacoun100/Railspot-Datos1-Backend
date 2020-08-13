package com.itcr.datos.railspot.dataStructures;

public class GraphEdge<T> {

    private final GraphNode<T> goingFrom;
    private final GraphNode<T> goingTo;
    private final int weight;

    public GraphEdge(GraphNode<T> goingTo,GraphNode<T> goingFrom, int weight) {
        this.goingFrom = goingFrom;
        this.goingTo = goingTo;
        this.weight = weight;
    }

    public GraphNode<T> getGoingTo() {
        return goingTo;
    }

    public GraphNode<T> getGoingFrom() { return goingFrom; }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "goingFrom=" + goingFrom +
                ", goingTo=" + goingTo +
                ", weight=" + weight +
                '}';
    }
}
