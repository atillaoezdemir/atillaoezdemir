package de.thws.lektion16.stack;

import java.util.ArrayList;
public class StackVererbung extends ArrayList<Object> {
    public void push(Object element) {
        add(element);
    }
    public Object pop() {
        if (size() > 0) {
            return remove(size() - 1);
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }
}
