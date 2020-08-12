package com.itcr.datos.railspot.management;

import com.itcr.datos.railspot.objects.Ticket;
import org.json.simple.JSONObject;

public class TicketManagement {

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
