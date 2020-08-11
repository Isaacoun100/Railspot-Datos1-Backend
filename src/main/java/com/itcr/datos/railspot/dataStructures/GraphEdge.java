package com.itcr.datos.railspot.dataStructures;

public class GraphEdge<T> {
    private Graph<T> weightedGraph;
    private GraphNode<T> fromNodeIndex;
    private GraphNode<T> toNodeIndex;
    private int weight;

    public GraphEdge(T fromNode, T toNode, int weight, Graph<T> graph){
        fromNodeIndex = weightedGraph.searchVertex(fromNode);
        if (fromNodeIndex == null)
        {
            fromNodeIndex = new GraphNode<T>(fromNode);
            graph.getVertexList().add(fromNodeIndex);
        }
        toNodeIndex = graph.searchVertex(toNode);
        if (toNodeIndex == null) {
            toNodeIndex = new GraphNode<T>(toNode);
            graph.getVertexList().add(toNodeIndex);
        }
        this.weightedGraph = graph;
        this.weight = weight;

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
