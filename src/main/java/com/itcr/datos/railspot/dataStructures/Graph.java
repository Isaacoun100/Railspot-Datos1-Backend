package com.itcr.datos.railspot.dataStructures;

import com.itcr.datos.railspot.objects.Ticket;

/**
 * This class will be instanced to create a new graph
 * @param <T>
 */
public class Graph<T>{


    private GraphNode<T> reference =null;

    /**
     * This sets the reference of the graph
     * @param newNode
     */
    public void addReference(GraphNode<T> newNode){
        reference=newNode;
    }

    /**
     * This method prints all pf the connection between the nodes
     */
    public void printGraph(){
        printGraph(reference, new SinglyList<>());
    }

    /**
     * Auxiliary method for the printGraph method
     * @param node
     * @param visited
     */
    public void printGraph(GraphNode<T> node, SinglyList<GraphNode<T>> visited){
        if(!visited.contains(node)){
            if(node!=null){
                System.out.println(node.getName() + "is connected to ");
                node.getVertex().print();
                visited.add(node);

                if(node.getVertex()!=null){
                    for(int x = 0; x<node.getVertex().getLength(); x++) {
                        printGraph(node.getVertex().get(x).getData().getGoingTo(), visited);
                    }
                }
            }
        }
    }

    /**
     * This method will receive a data and it will search for it
     * @param search
     * @return
     */
    public GraphNode<T> search(T search){
        try{ return search(search, new SinglyList<>(), reference);}
        catch (NullPointerException e){ return new GraphNode<T>(null); }
    }

    /**
     * Auxiliary method for the search method
     * @param search
     * @param visited
     * @param head
     * @return
     */
    public GraphNode<T> search(T search, SinglyList<GraphNode<T>> visited, GraphNode<T> head){
        if(!visited.contains(head)){
            if(head.getName().equals(search)){ return head; }
            else{
                visited.add(head);
                for(int i=0; i<head.getVertex().getLength(); i++){
                    GraphNode<T> node = search(search, visited, head.getVertex().get(i).getData().getGoingTo());
                    if(node!=null){ return node; }

                }
            }
        }
        return null;
    }

    /**
     * This class will return a list with all of the NodeEdges
     * @return
     */
    public SinglyList<GraphEdge<T>> weightList (){

        SinglyList<GraphNode<T>> nodeSinglyList= nodeList();
        SinglyList<GraphEdge<T>> resultList= new SinglyList<>();

        for(int i=0; i<nodeSinglyList.getLength(); i++){
            SinglyNode<GraphNode<T>> head = nodeSinglyList.get(i);
            for(int j=0; j<head.getData().getVertex().getLength(); j++){
                GraphEdge<T> ticket = head.getData().getVertex().get(j).getData();
                if(!resultList.contains(ticket)){ resultList.add(ticket); }
            }
        }
        return resultList;

    }

    /**
     * This will return a list with all of the GraphNodes
     * @return
     */
    public SinglyList<GraphNode<T>> nodeList (){
        SinglyList<GraphNode<T>> finalList = new SinglyList<>();
        nodeList(reference, finalList);
        return finalList;
    }

    /**
     * Auxiliary method for the nodeList method
     * @param head
     * @param finalList
     */
    public void nodeList (GraphNode<T> head, SinglyList<GraphNode<T>> finalList ){
        if(!finalList.contains(head)){
            finalList.add(head);
            for(int i=0; i<head.getVertex().getLength(); i++){
                nodeList(head.getVertex().get(i).getData().getGoingTo(),finalList);
            }
        }

    }

    /**
     * This method will delete the NodeEdge between two datas, if they exist in the server the method will delete their
     * connection
     * @param fromData
     * @param toData
     */
    public void deleteEdge(T fromData, T toData) {


        GraphNode<T> from = search(fromData);
        GraphNode<T> to = search(toData);
        SinglyList<GraphEdge<T>> fromVertex, toVertex;
        try{
            fromVertex = from.getVertex();
            toVertex = to.getVertex();
        }
        catch (NullPointerException e){ return; }

        for (int i = 0; i < fromVertex.getLength(); i++) {
            if (fromVertex.get(i).getData().getGoingTo().equals(to) &&
                    fromVertex.get(i).getData().getGoingFrom().equals(from)) {
                from.getVertex().remove(i);
            }
        }

        for (int i = 0; i < toVertex.getLength(); i++) {
            if (toVertex.get(i).getData().getGoingTo().equals(from) &&
                    toVertex.get(i).getData().getGoingFrom().equals(to)) {
                to.getVertex().remove(i);
            }

        }
    }

    /**
     * This method will delete a given edge and all of its relation between two nodes
     * @param edge
     */
    public void deleteEdge(GraphEdge<T> edge){
        deleteEdge(edge.getGoingTo().getName(), edge.getGoingFrom().getName());
    }

}


