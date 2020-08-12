package com.itcr.datos.railspot.objects;

import com.itcr.datos.railspot.dataStructures.SinglyList;

public class Ticket {

    private final String goingTo;
    private final String goingFrom;
    private final int price;
    private final String date;
    private final int ownerID;

    public Ticket(String goingTo, String goingFrom, int price, String date, int ownerID) {
        this.goingTo = goingTo;
        this.goingFrom = goingFrom;
        this.price = price;
        this.date = date;
        this.ownerID = ownerID;
    }

    public String getGoingTo() {
        return goingTo;
    }

    public String getGoingFrom() {
        return goingFrom;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getOwnerID() {
        return ownerID;
    }


}
