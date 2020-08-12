package com.itcr.datos.railspot.dataStructures;



/**
 * Class used for the implementation for the weighted graph.
 * Part of the code was based from reddit post https://www.reddit.com/r/javaexamples/comments/386pb8/intermediate_generic_directed_weighted_graph_with/
 */
public class Graph<T>{
    private SinglyList<GraphNode<T>> vertexList = new SinglyList<>();
    private SinglyList<GraphEdge<T>> edgeList = new SinglyList<>();

    public void insertNewNode(T fromIndex, T toIndex, int weight){
        GraphEdge<T> current = findEdgeFromData(fromIndex, toIndex);
        if (current != null){
            System.out.println("Edge " + fromIndex + "," + toIndex + " already exists. Changing cost.");
           current.setWeight(weight);
        }else {
            GraphEdge<T> edge = new GraphEdge<>(fromIndex, toIndex, weight, this);
        }
    }

    public GraphEdge<T> findEdgeFromVertices(GraphNode<T> firstNode, GraphNode<T> secondNode){
        for (int i = 0; i < edgeList.getLength(); i++) {
            if (edgeList.get(i).getData().getFromNodeIndex().equals(firstNode) && edgeList.get(i).getData().getToNodeIndex().equals(secondNode)) {
                return edgeList.get(i).getData();
            }
        }
        return null;
    }

    public GraphEdge<T> findEdgeFromData(T fromNode, T toNode){
        for (int i = 0; i < edgeList.getLength(); i++) {
            if (edgeList.get(i).getData().getFromNodeIndex().equals(fromNode) && edgeList.get(i).getData().getToNodeIndex().equals(toNode)) {
                return edgeList.get(i).getData();
            }
        }
        return null;
    }


    public GraphNode<T> searchVertex(T data){
        for (int i = 0; i < vertexList.getLength(); i++){
            if (vertexList.get(i).getData().compareTo((GraphNode<T>) data)== 0) {
                return vertexList.get(i).getData();
            }
        }
        return null;
    }
    private void unvisit(){
        for (int i = 0; i < vertexList.getLength(); i++){
            vertexList.get(i).getData().setVisited(-1);
        }
    }

    /**
     * Function that cheks if the graph is connected to another node
     * by accesing its visited value
     * @return returns false if its different from 1 (completed) else returns true
     */
    public boolean isLinked(){
        for(int i = 0; i < vertexList.getLength(); i++){
            if (vertexList.get(i).getData().getVisited() != 1){
                return false;
            }
        }
        return true;
    }

    public boolean depthFirstSearch(){
        if (vertexList.getHead() == null){
            return false;
        }
        unvisit();
        GraphNode<T> head =  vertexList.get(0).getData();
        if (head == null){
            return false;
        }
        depthFirstSearchAux(head);
        return isLinked();

    }

    private void depthFirstSearchAux(GraphNode<T> node){
        node.setVisited(0);

        for (int i = 0; i < node.getOutgoing().getLength(); i++){
            if (node.getOutgoing().get(i).getData().getVisited() == -1){
                depthFirstSearchAux(node.getOutgoing().get(i).getData());
            }
        }
        node.setVisited(1);
    }

    public boolean SearchBreathFirst(T data){
        if (vertexList.getHead() == null) {
            return false;
        }
        unvisit();

        GraphNode<T> root = searchVertex(data);
        if (root == null) {
            return false;
        }

        SinglyList<GraphNode<T>> list = new SinglyList<>();
        list.add(root);
        root.setVisited(1);

        while (!(list.getHead() == null)) {
            root = list.getHead().getData(); // again used in place of queue.peak()
            for (int i = 0; i < root.getOutgoing().getLength(); i++) {
                GraphNode<T> each = root.getOutgoing().get(i).getData();
                if (each.getVisited() == -1) {
                    each.setVisited(1);
                    list.add(each);
                }
            }
            list.remove(0);
        }
        return isLinked();
    }
    /*
    private void resetLenghts() {
        for (int i = 0; i < vertexList.getLength(); i++) {
            vertexList.get(i).getData().setMinSourceDistance(Integer.MAX_VALUE);
            vertexList.get(i).getData().setPrevious(null);
        }
    }

    private boolean Dijkstra(T value) {
        if (vertexList.getHead() == null) {
            return false;
        }

        // reset all the distances and the previous values.
        resetLenghts();

        // make sure it is valid
        GraphNode<T> source = searchVertex(value);
        if (source == null) { return false; }

        // set to 0 and add to heap
        source.setMinSourceDistance(0);
        // hover mouse on instance type to see it's import value
        PriorityQueueList<GraphNode<T>> pq = new PriorityQueueList<>();
        pq.enQueue(source);

        while (!pq.isEmpty()) {
            // pull off top of queue, based on priority
            GraphNode<T> u = pq.deQueue();
            //loop through adjacent vertices
            for (int i = 0; i < u.getOutgoing().getLength(); i++) {
                GraphNode<T> temp = u.getOutgoing().get(i).getData();
                //get the edge
                GraphEdge<T> edge = findEdgeFromVertices(u, temp);
                if (edge == null) { return false; }
                // add cost to current
                int totalDistance = u.getMinSourceDistance() + edge.getWeight();
                if (totalDistance < temp.getMinSourceDistance()) {
                    // new cost is lower, set it and add to queue
                    pq.remove(temp);
                    temp.setMinSourceDistance(totalDistance);
                    // link the vertex
                    temp.setPrevious(u);
                    pq.enQueue(temp);
                }
            }
        }
        return true;
    }

     */



    public SinglyList<GraphNode<T>> getVertexList() {
        return vertexList;
    }

    public SinglyList<GraphEdge<T>> getEdgeList() {
        return edgeList;
    }
    /**
     *
     * @return string with all the vertices
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < vertexList.getLength(); i++) {
            string.append(vertexList.get(i).getData().toString()).append("\n");
        }
        return string.toString();
    }

    /**
     *
     * @return string with all the edges
     */
    public String edgesToString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < edgeList.getLength(); i++) {
            string.append(edgeList.get(i).getData().toString()).append("\n");
        }
        return string.toString();
    }

}


