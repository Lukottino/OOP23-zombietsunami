package zombietsunami;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import zombietsunami.model.zombiemodel.api.Zombie;
import zombietsunami.model.zombiemodel.impl.ZombieImpl;
import zombietsunami.model.personmodel.api.SecondPerson;
import zombietsunami.model.personmodel.impl.SecondPersonImpl;

/**
 * Test class for SecondPerson.
 * 
 * This class test the increase of the SecondPerson and if the SecondPerson is set properly.
 */
class TestSecondPerson {
    private final Zombie zombie = new ZombieImpl();
    private final SecondPerson secondPerson = new SecondPersonImpl();
    private static final int NUM_VALUE = 15;

    /**
     * Checks if the increase has been dealt correctly to the Zombie.
     */
    @Test
    void checkDoubleIncrease() {
        zombie.increaseStrength();
        zombie.increaseStrength();
        assertEquals(zombie.getStrength(), 3);
    }

    /**
     * Checks if the Person is set properly.
     */
    @Test
    void testCoordinates() {
        secondPerson.setX(NUM_VALUE);
        assertEquals(NUM_VALUE, secondPerson.getX());
        secondPerson.setY(NUM_VALUE);
        assertEquals(NUM_VALUE, secondPerson.getY());
    }
}
