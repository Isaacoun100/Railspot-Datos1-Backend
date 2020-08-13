package com.itcr.datos.railspot.dataStructures;

/**
 * This class will handle the connectios between two nodes
 * @param <T>
 */
public class GraphEdge<T> {

    private final GraphNode<T> goingFrom;
    private final GraphNode<T> goingTo;
    private final int weight;

    /**
     * Constructor for the class
     * @param goingTo
     * @param goingFrom
     * @param weight
     */
    public GraphEdge(GraphNode<T> goingTo,GraphNode<T> goingFrom, int weight) {
        this.goingFrom = goingFrom;
        this.goingTo = goingTo;
        this.weight = weight;
    }

    /**
     * Getter for the goingTo variable
     * @return
     */
    public GraphNode<T> getGoingTo() {
        return goingTo;
    }

    /**
     * Getter for the goingFrom variable
     * @return
     */
    public GraphNode<T> getGoingFrom() { return goingFrom; }

    /**
     * Getter for the weight variable
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * This class will convert the class into a readable String
     * @return
     */
    @Override
    public String toString() {
        return "GraphEdge{" +
                "goingFrom=" + goingFrom +
                ", goingTo=" + goingTo +
                ", weight=" + weight +
                '}';
    }
}
