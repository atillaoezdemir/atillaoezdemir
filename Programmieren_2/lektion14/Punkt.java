package de.thws.lektion14;
public class Punkt {
    
    int x;
    int y;
    
    public void verschiebePunkt(int zielX, int zielY) throws RuntimeException {
        if (zielX > 1920 || zielY > 1080 || zielX < 0 || zielY < 0)
            throw new RuntimeException("Ungültige Zahlen!");
    
        else {
            this.x = zielX;
            this.y = zielY;
        }
    }
}
