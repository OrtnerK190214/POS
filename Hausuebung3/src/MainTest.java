import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main;

    @org.junit.jupiter.api.Test
    void sortdamage() {
        List<Weapon> test = new ArrayList<>();
        List<Weapon> ergebnis = new ArrayList<>();

        test.add(new Weapon("Carsomyr", combatType.valueOf("MELEE"), damageType.valueOf("SLASHING"), 17, 5, 14, 20000));
        test.add(new Weapon("Strong Arm", combatType.valueOf("RANGED"), damageType.valueOf("MISSILE"), 3, 5, 19, 5500));
        test.add(new Weapon("Crom Faeyr", combatType.valueOf("MELEE"), damageType.valueOf("BLUNT"), 16, 1, 25, 15500));
        test = main.sortdamage(test);
        ergebnis.add(new Weapon("Strong Arm", combatType.valueOf("RANGED"), damageType.valueOf("MISSILE"), 3, 5, 19, 5500));
        ergebnis.add(new Weapon("Crom Faeyr", combatType.valueOf("MELEE"), damageType.valueOf("BLUNT"), 16, 1, 25, 15500));
        ergebnis.add(new Weapon("Carsomyr", combatType.valueOf("MELEE"), damageType.valueOf("SLASHING"), 17, 5, 14, 20000));
        assertEquals(ergebnis, test);
    }

    @org.junit.jupiter.api.Test
    void sortalphabetisch() {
        List<Weapon> test = new ArrayList<>();
        List<Weapon> ergebnis = new ArrayList<>();

        test.add(new Weapon("Carsomyr", combatType.valueOf("MELEE"), damageType.valueOf("SLASHING"), 17, 5, 14, 20000));
        test.add(new Weapon("Strong Arm", combatType.valueOf("RANGED"), damageType.valueOf("MISSILE"), 3, 5, 19, 5500));
        test.add(new Weapon("Crom Faeyr", combatType.valueOf("MELEE"), damageType.valueOf("BLUNT"), 16, 1, 25, 15500));
        test = main.sortalphabetisch(test);
        ergebnis.add(new Weapon("Carsomyr", combatType.valueOf("MELEE"), damageType.valueOf("SLASHING"), 17, 5, 14, 20000));
        ergebnis.add(new Weapon("Crom Faeyr", combatType.valueOf("MELEE"), damageType.valueOf("BLUNT"), 16, 1, 25, 15500));
        ergebnis.add(new Weapon("Strong Arm", combatType.valueOf("RANGED"), damageType.valueOf("MISSILE"), 3, 5, 19, 5500));
        assertEquals(ergebnis, test);
    }
}