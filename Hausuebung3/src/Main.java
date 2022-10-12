import java.util.*;

public class Main {

    private List<Weapon> weaponslist = new ArrayList<>();

    private Comparator<Weapon> absteigendamage = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon o1, Weapon o2) {
            return o1.getDamage() - o2.getDamage();
        }
    };

    private Comparator<Weapon> alphabetisch = new Comparator<Weapon>() {
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

    private Printable printable = new Printable() {
        @Override
        public void print(List<Weapon> weapons) {
            for (int i = 0; i<weapons.size(); i++)
            {
                System.out.println(weapons.get(i));
            }
        }
    };

    public static void main(String[] args) {

    }

    public List<Weapon> sortdamage(List<Weapon> weapons)
    {
        Collections.sort(weapons, absteigendamage);
        return weapons;
    }

    public List<Weapon> sortalphabetisch(List<Weapon> weapons)
    {
        Collections.sort(weapons, alphabetisch);
        return weapons;
    }
}