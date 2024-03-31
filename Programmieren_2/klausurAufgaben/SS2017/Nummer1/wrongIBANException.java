package de.thws.klausurAufgaben.SS2017.Nummer1;

public class wrongIBANException extends Exception {
    wrongIBANException() {
        super("FEHLER: Datei enthält ungültige IBAN!");
    }

    wrongIBANException(String msg) {
        super(msg);
    }
}
