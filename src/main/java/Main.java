import com.google.common.collect.Ordering;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Bro> bros = Arrays.asList(
                new Bro("Bro", 2, new Ti("white", 2)),
                new Bro("TI", 5, new Ti("green", 6)),
                new Bro("MA", 2, new Ti("white", 2)),
                new Bro("Bro", 1, new Ti("bloo", 1)),
                new Bro("TI", 2, new Ti("red", 6)),
                new Bro("MA", 3, new Ti("white", 1)));

        //ordering!!!
        Comparator<Ti> comparing = Comparator.comparing(Ti::getAnInt);

        Comparator<Pair<Bro, Ti>> pairComparator2 = Comparator.<Pair<Bro, Ti>, Bro>comparing(Pair::getLeft, Comparator.comparing(Bro::getName))
                .thenComparing(Pair::getRight, comparing.thenComparing(Ti::getColor));

        bros.stream()
                .map(bro1 -> Pair.of(bro1, bro1.getTi()))
                .sorted(pairComparator2)
                .forEachOrdered(broTiPair -> {
                    System.out.println(broTiPair.getKey());
//                    System.out.println(broTiPair.getValue());
//                    System.out.println(broTiPair.getLeft());
//                    System.out.println(broTiPair.getRight());
                });
//Ordering.explicit
    }
}

class Bro {
    private String name;
    private int number;
    private Ti ti;

    public Ti getTi() {
        return ti;
    }

    public void setTi(Ti ti) {
        this.ti = ti;
    }

    public Bro(String name, int number, Ti ti) {
        this.name = name;
        this.number = number;
        this.ti = ti;
    }

    @Override
    public String toString() {
        return "Bro{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", ti=" + ti +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}

class Ti {
    private String color;
    private int anInt;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "Ti{" +
                "color='" + color + '\'' +
                ", anInt=" + anInt +
                '}';
    }

    public Ti(String color, int anInt) {
        this.color = color;
        this.anInt = anInt;
    }
}
