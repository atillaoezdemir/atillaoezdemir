package de.thws.lektion16.cyborg;

public class Mensch implements Reaktionsverhalten{
    public Entscheidung entscheide(Gefahrensituation situation) {
        return switch (situation) {
            case GEFAHR_LINKS -> Entscheidung.RECHTS;
            case GEFAHR_RECHTS -> Entscheidung.LINKS;
            case GEFAHR_VORNE -> Entscheidung.BREMSEN;
            default -> Entscheidung.UNENTSCHIEDEN;
        };
    }
    public class Main {
        public static void main(String[] args) {
            int gun = 3;

            switch (gun) {
                case 1: System.out.println("Pazartesi");
                    break;
                case 2:
                    System.out.println("Salı");
                    break;
                case 3:
                    System.out.println("Çarşamba");
                    break;
                case 4:
                    System.out.println("Perşembe");
                    break;
                case 5:
                    System.out.println("Cuma");
                    break;
                case 6:
                    System.out.println("Cumartesi");
                    break;
                case 7:
                    System.out.println("Pazar");
                    break;
                default:
                    System.out.println("Geçersiz gün");
                    break;
            }
        }
    }

}
