package com.itcr.datos.railspot.management;

import com.itcr.datos.railspot.dataStructures.AVLTree;
import com.itcr.datos.railspot.dataStructures.NodeAVL;
import com.itcr.datos.railspot.dataStructures.SinglyList;
import com.itcr.datos.railspot.objects.Ticket;
import com.itcr.datos.railspot.objects.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class used for managing the user AVL tree
 */
public class UserTree {

    public static AVLTree<User> userTree;

    /**
     * Funcion that instatiates the user tree
     */
    public static void initUserTree(){
        userTree = new AVLTree<>();
        updateUserList();
    }

    /**
     * Function that reads the JSON
     */
    public static void updateUserList(){
        userTree.clear();

        JSONParser userParser = new JSONParser();
        try {
            JSONObject usersJSON = (JSONObject) userParser.parse(new FileReader("res/data/Users.json"));
            getBranch(usersJSON);
            System.out.println(userTree.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function that
     * @param jsonObject
     */
    private static void getBranch(JSONObject jsonObject){
        User newUser = new User();

        try{newUser.setID(Integer.parseInt(jsonObject.get("ID").toString()));}
        catch (NullPointerException e){ newUser.setID(0);}

        JSONArray jsonArray = objectToJSONArray(jsonObject.get("tickets"));
        SinglyList<Ticket> tickets = new SinglyList<>();

        for (Object object : jsonArray) { tickets.add((Ticket) object); }

        try{ newUser.setTickets(tickets); }
        catch (NullPointerException e){ newUser.setTickets(new SinglyList<>()); }

        userTree.add(newUser, newUser.getID());

        if(jsonObject.get("right")!=null){
            getBranch((JSONObject) jsonObject.get("right"));
        }
        if(jsonObject.get("left")!=null){
            getBranch((JSONObject) jsonObject.get("left"));
        }
    }

    /**
     * Method that casts an object into a JSON array
     * @param object the object
     * @return returns the JSON array
     */
    @SuppressWarnings("unchecked")
    public static JSONArray objectToJSONArray(Object object){
        JSONArray jsonArray = new JSONArray();
        ArrayList<Object> arrayList = objectArray(object);
        int count, size = count = 0;

        try{ size=arrayList.size(); }
        catch (NullPointerException e){ e.printStackTrace(); }

        while (count<size){
            jsonArray.add(arrayList.get(count));
            count++;
        }
        return jsonArray;
    }

    /**
     * Function that puts and object into a JSON array
     * @param object a new object
     * @return returns a JSON array with the object
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Object> objectArray(Object object){
        return (ArrayList<Object>) object;
    }

    /**
     * Function that adds a new user
     * @param user the object user
     */
    public static void addUser(User user){
        userTree.add(user, user.getID());
    }

    /**
     * Function for searching the user
     * @param ID the integer for searching the user
     * @return returns search user function with a new parameter
     */
    public static NodeAVL<User> searchUser(int ID){
        return searchUser(ID, userTree.getRoot());
    }

    /**
     * Recursive function for searching for the user
     * @param ID the ID of the user searched
     * @param root the new node AVL
     * @return returns null
     */
    private static NodeAVL<User> searchUser(int ID, NodeAVL<User> root){
        if(root.getData().getID()==ID){ return root; }
        else if(root.getData().getID()>ID){
            if(root.getRight()!=null){ searchUser(ID, root.getRight()); }
        }
        else if(root.getData().getID()<ID){
            if(root.getLeft()!=null){ searchUser(ID, root.getLeft()); }
        }
        return null;
    }

    /**
     * Function that stores the user into the JSON
     */
    public static void saveUser(){
        try(FileWriter file = new FileWriter("res/data/Users.json")){
            System.out.println(userTree.getRoot().getData().getID());
            file.write(binaryTravel(userTree.getRoot(), new JSONObject()).toString());
            file.flush();

        }
        catch (IOException e) { e.printStackTrace();}
    }

    /**
     * Function that adds the data to Users.json
     * @param user root
     * @param jsonObject needed to search
     * @return JSONObject you where looking for
     */
    @SuppressWarnings("unchecked")
    private static JSONObject binaryTravel(NodeAVL<User> user, JSONObject jsonObject){
        jsonObject=userToJSON(user);
        jsonObject.put("left", null);
        jsonObject.put("right",null);

        if(user.getLeft()!=null){
            jsonObject.replace("left", binaryTravel(user.getLeft(), new JSONObject()));
        }
        if(user.getRight()!=null){
            jsonObject.replace("right", binaryTravel(user.getRight(), new JSONObject()));
        }
        return jsonObject;
    }

    /**
     * Function for casting user into JSON
     * @param user the new node avl
     * @return returns an json object
     */
    @SuppressWarnings("unchecked")
    public static JSONObject userToJSON(NodeAVL<User> user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID", user.getData().getID() );

        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<user.getData().getTickets().getLength(); i++){
            jsonArray.add(TicketManagement.ticketToJSON(user.getData().getTickets().get(i).getData()));
        }

        jsonObject.put("tickets", jsonArray);
        return jsonObject;

    }



}
