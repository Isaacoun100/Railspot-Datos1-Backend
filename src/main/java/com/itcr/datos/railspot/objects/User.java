package com.itcr.datos.railspot.objects;

import com.itcr.datos.railspot.dataStructures.SinglyList;

public class User {

    private SinglyList<Ticket> tickets;
    private int ID;

    public SinglyList<Ticket> getTickets() { return tickets; }

    public void setTickets(SinglyList<Ticket> tickets) { this.tickets = tickets; }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public void addTicket(Ticket newTicket){ this.tickets.add(newTicket); }

}
