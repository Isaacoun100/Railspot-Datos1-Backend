package com.itcr.datos.railspot.dataStructures;

import com.itcr.datos.railspot.objects.Ticket;

public class Graph<T>{

    private GraphNode<T> reference =null;

    public void addReference(GraphNode<T> newNode){
        reference=newNode;
    }

    public void printGraph(){
        printGraph(reference, new SinglyList<>());
    }

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

    public GraphNode<T> search(T search){
        try{ return search(search, new SinglyList<>(), reference);}
        catch (NullPointerException e){ return new GraphNode<T>(null); }
    }


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

    public void shortestPathBetween(){ }

//    public Graph<T> dijkstra (GraphNode<T> head){
//        SinglyList<GraphEdge<T>> weightTable = weightList();
//        SinglyList<GraphNode<T>> nodeTable = nodeList();
//
//        GraphNode<T> dijkstraGraph = reference;
//
//    }

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

    public SinglyList<GraphNode<T>> nodeList (){
        SinglyList<GraphNode<T>> finalList = new SinglyList<>();
        nodeList(reference, finalList);
        return finalList;
    }

    public void nodeList (GraphNode<T> head, SinglyList<GraphNode<T>> finalList ){
        if(!finalList.contains(head)){
            finalList.add(head);
            for(int i=0; i<head.getVertex().getLength(); i++){
                nodeList(head.getVertex().get(i).getData().getGoingTo(),finalList);
            }
        }

    }

    public void deleteEdge(T fromData, T toData) {

        GraphNode<T> from = search(fromData);
        GraphNode<T> to = search(toData);

        SinglyList<GraphEdge<T>> fromVertex = from.getVertex();
        SinglyList<GraphEdge<T>> toVertex = to.getVertex();

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

    public static void main(String[] args) {

        Graph<String> newGraph = new Graph<String>();
        GraphNode<String> eredia = new GraphNode<>("EREDIA");
        GraphNode<String> alajuela = new GraphNode<>("ALAJUELA");
        GraphNode<String> jochepe = new GraphNode<>("SAN JOCHEPE");
        GraphNode<String> papa = new GraphNode<>("Cartucho");
        GraphNode<String> fishyfish = new GraphNode<>("Puntarenas");

        eredia.addEdge(eredia,alajuela,10);
        eredia.addEdge(eredia,jochepe,5);
        alajuela.addEdge(alajuela,papa,12);
        papa.addEdge(papa, eredia,5);
        fishyfish.addEdge(fishyfish, alajuela,50);

        newGraph.addReference(eredia);

        newGraph.deleteEdge("EREDIA","Cartucho");

        newGraph.weightList().print();

    }


}


