package com.example.administrator.mycustomertest;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/12/16.
 */
class Node {
    Node prev;
    Object obj;
    Node next;

    Node(Node prev, Object obj, Node next) {
        this.prev = prev;
        this.obj = obj;
        this.next = next;
    }
}

// class ArrayListIterator implements Iterator{
//        private int currentIndex=0;
//       @Override
//      public boolean hasNext() {
//            if(currentIndex>=index){
//
//               return false;
//           }
//            else {
//               return true;
//            }
//        }
//
//        @Override
//        public Object next() {
//            Node temp = new Node(null, obj, node);
//           Object object=objects[currentIndex];
//            currentIndex++;
//           return object;
//      }
//    }

public class NewList implements List {
    private Node first;
    private Node last;
    private int size;

    public NewList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        int index = 0;
        Boolean flag = false;
        for (Node temp = first; temp != null; ) {
            if (temp.obj.equals(o)) {
                flag = true;
                temp = temp.next;
                index++;
            } else {
                temp = temp.next;
                index++;
            }
        }
        return flag;
    }

    @NonNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        linkLast(o);
        size++;
        return true;
    }

    private void linkLast(Object obj) {
        Node temp = new Node(last, obj, null);
        if (first == null)
            first = last = temp;
        else {
            last.next = temp;
            last = temp;
        }

    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        Boolean flag = false;
        for (Node temp = first; temp != null; ) {
            if (temp.obj.equals(o)) {
                flag = true;
                temp = temp.next;
                remove(index);
            } else {
                temp = temp.next;
                index++;
            }
        }
        return flag;
    }

    @Override
    public boolean addAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node temp = first; temp != null; ) {
            Node next = temp.next;
            temp.prev = null;
            temp.obj = null;
            temp.next = null;
            temp = next;
        }
        size = 0;
        first = last = null;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        Node temp = node(index);
        return temp == null ? null : temp.obj;
    }

    @Override
    public Object set(int index, Object element) {
        rangCheck(index);
        Node temp = node(index);
        Object preObj = temp.obj;
        temp.obj = element;
        return preObj;
    }

    /**
     * Judge whether the index is valid
     *
     * @param index the index of edit
     */
    private void rangCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(int index, Object element) {
        // Can be equal to size, if equal to size, the element is added to the last
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));

        size++;
    }

    /**
     * Add elements to the specified node
     *
     * @param obj  the obj of edit
     * @param node the index of node
     */
    private void linkBefore(Object obj, Node node) {
        Node temp = new Node(null, obj, node);

        Node up = node.prev;
        if (up != null) {
            up.next = temp;
            temp.prev = up;
            node.prev = temp;
        } else {
            first = temp;
        }

    }

    /**
     * Returns the node at the specified index
     *
     * @param index
     * @return the node at the specified index
     */
    private Node node(int index) {
        Node node = first;
        if (node != null) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    @Override
    public Object remove(int index) {
        rangCheck(index);
        // Get the index node
        Node temp = node(index);
        Object preObj = temp.obj;

        // Get the previous node and the next node of this node
        Node up = temp.prev;
        Node down = temp.next;

        // If you delete the first node
        if (up == null) {
            down.prev = null;
            first = down;
            size--;
            return preObj;
        }

        //If you delete the last node
        if (down == null) {
            up.next = null;
            last = up;
            size--;
            return preObj;
        }
        // Reset the connection
        up.next = down;
        down.prev = up;
        size--;
        return preObj;
    }

    @Override
    public int indexOf(Object o) {
        // Used to record the index
        int index = 0;

        for (Node temp = first; temp != null; ) {
            if (temp.obj.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        // The collection does not exist in the object, it returns -1
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;

        for (Node temp = last; temp != null; ) {
            if (temp.obj.equals(o)) {
                return index;
            }
            temp = temp.prev;
            index--;
        }
        // The collection does not exist in the object, it returns -1
        return -1;
    }

    /**
     * Traverse the output
     */
    public void out() {
        int index = 0;
        for (Node temp = first; temp != null; ) {
            temp = temp.next;
            index++;
            System.out.println(temp.obj);
        }
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @NonNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection c) {
        return false;
    }

    @NonNull
    @Override
    public Object[] toArray(@NonNull Object[] a) {
        return new Object[0];
    }
}
