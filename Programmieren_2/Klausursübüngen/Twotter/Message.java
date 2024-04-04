package de.thws.klausurAufgaben.Twotter;

import java.io.Serializable;

public class Message implements Serializable {
    
    private final String content;

    public Message(String content) {
        this.content = content;
    }
}
