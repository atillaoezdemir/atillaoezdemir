package de.thws.lektion19aa;

// Jenerik sınıf
public class Pair<T> {
    private T left;
    private T right;

    public Pair(T l, T r) {
        left = l;
        right = r;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public String toString() {
        return "(l=" + left.toString() + ", r=" + right.toString() + ")";
    }

    public static void main(String[] args) {
        // Tip olarak String belirtilen bir Pair oluşturuyoruz
        Pair<String> stringPair = new Pair<>("sol", "sağ");
        System.out.println(stringPair);

        // Tip olarak Integer belirtilmiş bir Pair oluşturuyoruz (String beklenen, ancak derleme hatası alacağız)
        // Bu örnekte bilerek hata oluşturulmuştur.
        Pair<Integer> integerPair = new Pair<>(1, 2);
        System.out.println(integerPair);
        // Aşağıdaki satır hata verecektir, çünkü beklenen tip String, ancak Integer verildi.
        // String leftValue = integerPair.getLeft();
    }
}
