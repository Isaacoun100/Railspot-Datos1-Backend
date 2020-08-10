package com.itcr.datos.railspot.dataStructures;

import java.util.Comparator;

/**
 * Public class for the priority queue based off https://www.geeksforgeeks.org/priority-queue-using-linked-list/
 */
public class PQList<T> {
    private PriorityQueueNode<T> head;
    private int len = 0;
    private Comparator<T> comparable;

    public PQList(Comparator<T> comparator){
        this.head = null;
        this.comparable = comparator;
    }

    public void insert(T data){
        PriorityQueueNode<T> temp = new PriorityQueueNode<>(data);
        if (this.head == null) {
            this.head = temp;
        }
        else {
            PriorityQueueNode<T> current = this.head;
            while(current.getNext() != null) {
                int compare = comparable.compare(data, current.getData());
                if (compare >= 0) {
                    // tmp still has higher priority, value is to be compared with next vertex/node
                    current = (PriorityQueueNode<T>) current.getNext();
                }
                else{
                    // value has higher priority, must take tmp's place in the queue
                    current.getPrevious().setNext(temp);
                    temp.setNext(current);
                    temp.setPrevious(current.getPrevious());
                    current.setPrevious(temp);
                }
            }
        }
        length++;
    }

}
