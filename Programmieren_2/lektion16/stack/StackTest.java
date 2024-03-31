package de.thws.lektion16.stack;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new StackImpl();
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
    }

    @Test
    public void testStackVererbung() {
        StackVererbung stacks = new StackVererbung();
        stacks.push("1");
        stacks.push("2");
        assertEquals("2", stacks.pop());
        assertEquals("1", stacks.pop());
    }

    @Test
    public void testEmptyStack() {
        Stack stack = new StackImpl();
        try {
            stack.pop();
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Stack is empty", errorMessage);
        }
    }
}