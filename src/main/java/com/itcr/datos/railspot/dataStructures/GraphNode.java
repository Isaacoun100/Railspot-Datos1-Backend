package com.itcr.datos.railspot.dataStructures;

public class GraphNode<T> {
    private T data;
    private int minDistanceFromSource = Integer.MAX_VALUE;
    private double longitude;
    private double latitude;
    private GraphNode<T> prev = null;
    private SinglyList<GraphNode<T>> incomingNode;
    private SinglyList<GraphNode<T>> outgoingNode;
    private boolean visited;

    public GraphNode(){
        incomingNode = new SinglyList<>();
        outgoingNode = new SinglyList<>();
        visited = false;

    }
    /**
     * Adds Node to adjacent incoming list
     * @param graphNode Vertex of incoming adjacent
     */
    public void addIncoming(GraphNode<T> graphNode) {
        incomingNode.add(graphNode);
    }

    /**
     * Adds Node to adjacent outgoing list
     * @param graphNode Vertex of outgoing adjacent
     */
    public void addOutgoing(GraphNode<T> graphNode) {
        outgoingNode.add(graphNode);
    }

    /**
     * Getter for the longitude attribute
     * @return double the longitude of the station
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Setter for the longitude attribute
     * @param longitude double the longitude of the station
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter for the latitude attribute
     * @return double the latitude of the station
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Setter for the latitude attribute
     * @param latitude double the latitude of the station
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * set method for vertex element
     * @param data T type data to place in the vertex
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * get method for vertex element
     * @return T type element located in the vertex data
     */
    public T getData() {
        return this.data;
    }

    /**
     * get method fot visited boolean
     * @return returns boolean
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Set method for visited boolean
     * @param visited returns visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMinDistanceFromSource() {
        return minDistanceFromSource;
    }

    public void setMinDistanceFromSource(int minDistanceFromSource) {
        this.minDistanceFromSource = minDistanceFromSource;
    }

    public GraphNode<T> getPrev() {
        return prev;
    }

    public void setPrev(GraphNode<T> prev) {
        this.prev = prev;
    }

    public SinglyList<GraphNode<T>> getIncomingNode() {
        return incomingNode;
    }

    public void setIncomingNode(SinglyList<GraphNode<T>> incomingNode) {
        this.incomingNode = incomingNode;
    }

    public SinglyList<GraphNode<T>> getOutgoingNode() {
        return outgoingNode;
    }

    public void setOutgoingNode(SinglyList<GraphNode<T>> outgoingNode) {
        this.outgoingNode = outgoingNode;
    }

    /**
     * Get string of Vertex with all it's ingoing and outgoing adjacent values
     * @ return string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Vertex: ").append(data).append(" : ").append("minD: ").append(minDistanceFromSource).append(" ");
        string.append(" In: ");
        for (int i = 0; i < incomingNode.getLength(); i++) {
            string.append(incomingNode.get(i).getData().getData()).append(" ");
        }
        string.append("Out: ");
        for (int i = 0; i < outgoingNode.getLength(); i++) {
            string.append(outgoingNode.get(i).getData().getData()).append(" ");
        }
        return string.toString();
    }
}


