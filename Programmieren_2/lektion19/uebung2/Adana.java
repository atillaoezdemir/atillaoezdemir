package de.thws.lektion19.uebung2;
import java.util.ArrayList;
public class Adana<E> extends ArrayList<E> {
    public void push(E element) {
        add(element);
    }
    public E pop() {
        if (size() > 0) {
            return remove(size() - 1);
        } else {
            throw new RuntimeException("Stack is empty.");
        }
    }
    public static void main(String[] args) {
        Adana<String> s = new Adana<>();
        s.push("Hallo");
        s.push("Welt");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
