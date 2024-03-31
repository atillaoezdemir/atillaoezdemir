package de.thws.lektion16.stack;

import java.util.ArrayList;

public class StackImpl implements Stack {
    private ArrayList<Object> list = new ArrayList<>();

    public void push(Object element) {
        list.add(element);
    }

    public Object pop() {
        if (list.size() > 0) {
            return list.remove(list.size() - 1);
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }
}
