package com.itcr.datos.railspot.objects;

import com.itcr.datos.railspot.dataStructures.SinglyList;

/**
 * Class for the user object
 */
public class User {

    private SinglyList<Ticket> tickets;
    private int ID;

    /**
     * Getter fot the tickets
     * @return returns the tickets
     */
    public SinglyList<Ticket> getTickets() { return tickets; }

    /**
     * Setter for the tickets
     * @param tickets the new singly list of tickets
     */
    public void setTickets(SinglyList<Ticket> tickets) { this.tickets = tickets; }

    /**
     * Getter for the ID
     * @return returns the ID
     */
    public int getID() { return ID; }

    /**
     * Setter for the ID
     * @param ID the new ID
     */
    public void setID(int ID) { this.ID = ID; }

    /**
     * Function that adds a new ticket into the singly list
     * @param newTicket the new ticket object 
     */
    public void addTicket(Ticket newTicket){ this.tickets.add(newTicket); }

}
