package de.thws.lektion19.uebung3;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
public class Browser {
    public Optional<URL> back() {
        try {
            return Math.random() < 0.5 ? Optional.of(new URL("http://google.de")) : Optional.empty();
        }
        catch(MalformedURLException e) {
            return Optional.empty();
        }
    }

    public String retrieveSite(Optional<URL> url) {
        return url.toString();
    }

    public static void main(String[] args) {
        System.out.println("Normal back");
        Browser browser = new Browser();
        Optional<URL> back = browser.back();
        System.out.println(browser.retrieveSite(back));
    }
}
