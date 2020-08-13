package com.itcr.datos.railspot.dataStructures;

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

    public GraphNode<T> search(T search){ return search(search, new SinglyList<>(), reference); }


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

    //public void shortestPathBetween(){ }

    //public Graph<T> dijkstra (GraphNode<T> head){ }

//    public SinglyList<GraphNode<T>> nodeList (){
//        return nodeList(reference, new SinglyList<>());
//    }
//
//    public SinglyList<GraphNode<T>> nodeList (GraphNode<T> head, SinglyList<GraphNode<T>> finalList ){
//        if(finalList.contains(head)){
//
//        }
//        else{
//            finalList.add(head);
//        }
//    }

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

        newGraph.printGraph();

        System.out.println("Cartucho y su info es: "+newGraph.search("Cartucho"));

    }


}


