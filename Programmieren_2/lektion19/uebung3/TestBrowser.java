package de.thws.lektion19.uebung3;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
public class TestBrowser {
    @Test
    public void testBack() throws MalformedURLException {
        Browser browser = new Browser();
        Optional<URL> test = browser.back();

        if (test.isPresent()) {
            assertEquals(new URL("http://google.de"), test.get());
        }
        else {
            testBack();
        }
    }
    @Test
    public void testRetrieveSite() throws MalformedURLException {
        System.out.println("Normal back");
        Browser browser = new Browser();
        Optional<URL> back = browser.back();
        if (back.isPresent()) assertEquals("Optional[http://google.de]", browser.retrieveSite(back));
        else testRetrieveSite();
    }
}
