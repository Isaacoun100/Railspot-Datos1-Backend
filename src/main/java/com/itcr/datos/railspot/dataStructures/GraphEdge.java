package com.itcr.datos.railspot.dataStructures;

public class GraphEdge<T> {
    private Graph<T> weightedGraph;
    private GraphNode<T> fromNodeIndex;
    private GraphNode<T> toNodeIndex;
    private int weight;

    public GraphEdge(T vertex1, T vertex2, int weight, Graph<T> graph){
        fromNodeIndex = weightedGraph.searchVertex(vertex1);
        if (fromNodeIndex == null)
        {
            fromNodeIndex = new GraphNode<T>(vertex1);
            graph.getVertexList().add(fromNodeIndex);
        }
        toNodeIndex = graph.searchVertex(vertex2);
        if (toNodeIndex == null) {
            toNodeIndex = new GraphNode<T>(vertex2);
            graph.getVertexList().add(toNodeIndex);
        }
        this.weight = weight;
        this.weightedGraph = graph;

        toNodeIndex.addVertexIncoming(fromNodeIndex);
        fromNodeIndex.addVertexOutgoing(toNodeIndex);
    }

    public GraphNode<T> getFromNodeIndex() {
        return fromNodeIndex;
    }

    public void setFromNodeIndex(GraphNode<T> fromNodeIndex) {
        this.fromNodeIndex = fromNodeIndex;
    }

    public GraphNode<T> getToNodeIndex() {
        return toNodeIndex;
    }

    public void setToNodeIndex(GraphNode<T> toNodeIndex) {
        this.toNodeIndex = toNodeIndex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge From: " + fromNodeIndex.getData() + " to: " + toNodeIndex.getData() + " weight: " + weight;
    }
}
