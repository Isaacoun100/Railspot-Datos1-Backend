package com.itcr.datos.railspot.management;

import com.itcr.datos.railspot.dataStructures.Graph;

/**
 * Class for the graph used for the routes
 */
public class GraphRoutes {

    private static  Graph<String> graphRoutes;

    /**
     * Function that instantiates the graph
     */
    public static void initGraph(){
        graphRoutes = new Graph<>();
        graphRoutes.printGraph();
    }

    /**
     * Function that gets the graph
     * @return returns the graph
     */
    public static Graph<String> getGraph(){ return graphRoutes; }

}
