package com.itcr.datos.railspot.dataStructures;

public class GraphNode<T> implements Comparable<GraphNode<T>>{
    private T data;

    //Variable for djikstra not yet implemented
    private GraphNode<T> previous = null;
    int minSourceDistance = Integer.MAX_VALUE;

    private SinglyList<GraphNode> incoming;
    private SinglyList<GraphNode> outgoing;
    private int visited;

    public GraphNode(T data){
        this.data = data;
        incoming = new SinglyList<>();
        outgoing = new SinglyList<>();
        visited = -1;
    }


    public void addVertexIncoming(GraphNode<T> vertex){
        incoming.add(vertex);
    }

    public void addVertexOutgoing(GraphNode<T> vertex){
        outgoing.add(vertex);

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GraphNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(GraphNode<T> previous) {
        this.previous = previous;
    }

    public int getMinSourceDistance() {
        return minSourceDistance;
    }

    public void setMinSourceDistance(int minSourceDistance) {
        this.minSourceDistance = minSourceDistance;
    }

    public SinglyList<GraphNode> getIncoming() {
        return incoming;
    }

    public void setIncoming(SinglyList<GraphNode> incoming) {
        this.incoming = incoming;
    }

    public SinglyList<GraphNode> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(SinglyList<GraphNode> outgoing) {
        this.outgoing = outgoing;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vertex: ").append(data).append(" : ").append("minD: ").append(minSourceDistance).append(" ");
        stringBuilder.append(" In: ");
        for (int i = 0; i < incoming.getLength(); i++) {
            stringBuilder.append(incoming.get(i).getData().getData()).append(" ");
        }
        stringBuilder.append("Out: ");
        for (int i = 0; i < outgoing.getLength(); i++) {
            stringBuilder.append(outgoing.get(i).getData().getData()).append(" ");
        }
        return stringBuilder.toString();
    }
    @Override
    public int compareTo(GraphNode<T> other) {
        return Integer.compare(minSourceDistance, other.minSourceDistance);
    }
}
