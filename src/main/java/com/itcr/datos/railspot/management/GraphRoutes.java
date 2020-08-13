package com.itcr.datos.railspot.management;

import com.itcr.datos.railspot.dataStructures.Graph;

public class GraphRoutes {

    private static  Graph<String> graphRoutes;

    public static void initGraph(){ graphRoutes = new Graph<>(); }

    public static Graph<String> getGraph(){ return graphRoutes; }

}
