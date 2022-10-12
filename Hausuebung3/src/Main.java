import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    private static List<Weapon> weaponslist = new ArrayList<>();

    private static Comparator<Weapon> absteigendamage = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon o1, Weapon o2) {
            return o1.getDamage() - o2.getDamage();
        }
    };

    private static Comparator<Weapon> alphabetisch = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon o1, Weapon o2) {
            int i1 = o1.getCombatType().compareTo(o2.getCombatType());
            int i2 = -1;
            if (i1 == 0)
                i2 = o1.getDamageType().compareTo(o2.getDamageType());
            if (i2 == 0)
                return o1.getName().compareTo(o2.getName());
            return i1;
        }
    };

    private static Printable printable = new Printable() {
        @Override
        public void print(List<Weapon> weapons) {
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println(weapons.get(i));
            }
        }
    };

    public static void main(String[] args) {
        //Beispiel 1
        String fileName = "weapons.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(a ->  addWeapon(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printable.print(weaponslist);
        System.out.println("--------------------------------");
        sortdamage(weaponslist);
        printable.print(weaponslist);
        System.out.println("--------------------------------");
        sortalphabetisch(weaponslist);
        printable.print(weaponslist);

        //Beispiel 3
        final Predicate<Integer> isEven = a -> (a % 2 == 0);
        final Predicate<Integer> isPositive = a -> (a > 0);
        final Predicate<Integer> isZero = a -> (a == 0);
        final Predicate<Integer> notEven = a -> (a % 2 != 0);

        int test = 2347;
        boolean ergebnis = isEven.and(isPositive).test(test);
        boolean ergebnis2 = notEven.and(isPositive).test(test);

        final Predicate<String> isShortWord = a -> (a.length() != 4);
        String test2 = "Test";
        boolean ergebnis3 = isShortWord.test(test2);

        System.out.println(ergebnis + ", " + ergebnis2 + ", " + ergebnis3);
    }

    public static List<Weapon> sortdamage(List<Weapon> weapons) {
        Collections.sort(weapons, absteigendamage);
        return weapons;
    }

    public static List<Weapon> sortalphabetisch(List<Weapon> weapons) {
        Collections.sort(weapons, alphabetisch);
        return weapons;
    }

    public static void addWeapon(String a)
    {
        String[] splitted = a.split(";");
        Weapon weapon = new Weapon(splitted[0], combatType.valueOf(splitted[1]), damageType.valueOf(splitted[2]), Integer.valueOf(splitted[3]), Integer.valueOf(splitted[4]), Integer.valueOf(splitted[5]), Integer.valueOf(splitted[6]));
        weaponslist.add(weapon);
    }
}