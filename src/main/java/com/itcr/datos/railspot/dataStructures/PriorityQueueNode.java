package com.itcr.datos.railspot.dataStructures;


public class PriorityQueueNode<T> extends Node<T> {
    protected Node<T> next;
    private int priority;
    /**
     * Constructor that sets the data to the node
     *
     * @param data data of generic type saved on new node
     */
    public PriorityQueueNode(T data) {
        super(data);
    }

    /**
     * Gets the next node on both singly and doubly node
     *
     * @return next node
     */
    @Override
    public Node<T> getNext() {
        return null;
    }

    /**
     * Sets the next reference on both singly and doubly node
     *
     * @param next next reference
     */
    @Override
    public void setNext(Node<T> next) {

    }

    /**
     * Getter for int priority
     * @return returns priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Setter for int priority
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
