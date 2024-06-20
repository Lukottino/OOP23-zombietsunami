package zombietsunami;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import zombietsunami.model.zombiemodel.api.Zombie;
import zombietsunami.model.zombiemodel.impl.ZombieImpl;
import zombietsunami.model.personmodel.api.CabinPerson;
import zombietsunami.model.personmodel.impl.CabinPersonImpl;
import zombietsunami.model.personmodel.api.CabinPersonsManager;
import zombietsunami.model.personmodel.impl.CabinPersonsManagerImpl;

/**
 * Test class for CabinPerson.
 * 
 * This class test various functionalities of the CabinPerson
 */
class TestCabinPerson {
    private final CabinPerson cabinPerson = new CabinPersonImpl(1);
    private final CabinPersonsManager cabinPersonsManager = new CabinPersonsManagerImpl();
    private final Zombie zombie = new ZombieImpl();
    private static final int NUM_VALUE = 15;

    /**
     * Checks if the zombie can break the CabinPerson.
     */
    @Test
    void checkIfCanBreakCabinPerson() {
        cabinPersonsManager.addCabinPerson(cabinPerson);
        assertTrue(cabinPerson.canBreakCabinPerson(zombie.getStrength()));

        zombie.decreaseStrength(); //Zombie Strenght = 0, CabinForce Force = 1.

        assertFalse(cabinPerson.canBreakCabinPerson(zombie.getStrength()));
    }

    /**
     * Checks if the CabinPerson is set properly.
     */
    @Test
    void testCoordinates() {
        cabinPerson.setX(NUM_VALUE);
        assertEquals(NUM_VALUE, cabinPerson.getX());
        cabinPerson.setY(NUM_VALUE);
        assertEquals(NUM_VALUE, cabinPerson.getY());
    }
}
