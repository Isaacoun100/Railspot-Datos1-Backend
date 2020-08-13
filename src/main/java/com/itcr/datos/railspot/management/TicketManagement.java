package com.itcr.datos.railspot.management;

import com.itcr.datos.railspot.objects.Ticket;
import org.json.simple.JSONObject;

/**
 * Class used for the managing of the tickets
 */
public class TicketManagement {
    /**
     * Function that turns a ticket into JSON
     * @param ticket the object ticket
     * @return returns a JSON object
     */
    @SuppressWarnings("unchecked")
    public static JSONObject ticketToJSON(Ticket ticket){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("goingTo", ticket.getGoingTo());
        jsonObject.put("goingFrom", ticket.getGoingFrom());
        jsonObject.put("price", ticket.getPrice());
        jsonObject.put("date", ticket.getDate());
        jsonObject.put("owner", ticket.getOwnerID());
        return jsonObject;
    }


}
