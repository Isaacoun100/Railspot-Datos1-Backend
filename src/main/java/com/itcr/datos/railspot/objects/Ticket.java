package com.itcr.datos.railspot.objects;

import com.itcr.datos.railspot.dataStructures.GraphEdge;
import com.itcr.datos.railspot.dataStructures.SinglyList;

/**
 * Function for the ticket object
 */
public class Ticket {

    private final String goingTo;
    private final String goingFrom;
    private SinglyList<GraphEdge<String>> route;
    private final int price;
    private final String date;
    private final int ownerID;

    public Ticket(String goingTo, String goingFrom, SinglyList<GraphEdge<String>> route, int price, String date, int ownerID) {
    /**
     * Constructor for the class ticket
     * @param goingTo the string where its going to
     * @param goingFrom the string where its coming from
     * @param price the price of the ticket
     * @param date the date from the ticket
     * @param ownerID the owner of the ticket
     */
    public Ticket(String goingTo, String goingFrom, int price, String date, int ownerID) {
        this.goingTo = goingTo;
        this.goingFrom = goingFrom;
        this.price = price;
        this.date = date;
        this.ownerID = ownerID;
    }

    public void setRoute(SinglyList<GraphEdge<String>> route) { this.route = route; }

    public SinglyList<GraphEdge<String>> getRoute() { return route; }

    public void addRoute(GraphEdge<String> edge){ route.add(edge); }

    /**
     * getter for going to
     * @return returns goingto
     */
    public String getGoingTo() {
        return goingTo;
    }

    /**
     * Getter for going from
     * @return returns going from
     */
    public String getGoingFrom() {
        return goingFrom;
    }

    /**
     * Getter for the price
     * @return returns the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter for the date
     * @return returns the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter for the owner
     * @return returns the owner
     */
    public int getOwnerID() {
        return ownerID;
    }


}
