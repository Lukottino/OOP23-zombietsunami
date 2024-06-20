package zombietsunami;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import zombietsunami.model.MapData;
import zombietsunami.model.mapmodel.api.GameMap;
import zombietsunami.model.mapmodel.impl.GameMapImpl;
import zombietsunami.model.personmodel.api.SecondPersonsManager;
import zombietsunami.model.personmodel.impl.SecondPersonsManagerImpl;
import zombietsunami.model.personmodel.impl.SecondPersonImpl;
import zombietsunami.model.zombiemodel.api.Zombie;
import zombietsunami.model.zombiemodel.impl.ZombieImpl;

/**
 * Class that tests the funcionalities of SecondPersonManager.
 */
class TestSecondPersonManager {

    private final SecondPersonsManager secondPersonsManager = new SecondPersonsManagerImpl();
    private final GameMap gameMap = new GameMapImpl();
    private final Zombie zombie = new ZombieImpl();

    /**
     * Checks if the list of SecondPerson are setted.
     */
    @Test
    void checkSecondPersonListSetted() {
        secondPersonsManager.setSecondPersonFromMap(gameMap.getLoadedPersonList(),
                gameMap.getScreenTilePos(MapData.getMaxWorldRow(), MapData.getMaxWorldCol(),
                        MapData.getTitSize(), zombie.getX(), zombie.getY(),
                        this.zombie.getScreenX(), this.zombie.getScreenY()));

        assertNotEquals(secondPersonsManager.getSecondPersonList().size(), 0);
    }

    /**
     * Tests if the SecondPerson are added correctly to the list.
     */
    @Test
    void testAddSecondPerson() {
        final int secondPersonListSize = secondPersonsManager.getSecondPersonList().size();
        secondPersonsManager.addSecondPerson(new SecondPersonImpl());

        assertNotEquals(secondPersonListSize, secondPersonsManager.getSecondPersonList());
    }

    /**
     * Tests if the SecondPerson are removed correctly from the list.
     */
    @Test
    void testRemoveSecondPerson() {
        secondPersonsManager.addSecondPerson(new SecondPersonImpl());
        secondPersonsManager.removeSecondPersonFromList(0);
        assertEquals(secondPersonsManager.getSecondPersonList().get(0), null);
    }

    /**
     * Tests if GetSecondPersonList() return correctly.
     */
    @Test
    void testGetSecondPersonList() {
        assertNotEquals(secondPersonsManager.getSecondPersonList(), null);
    }
}
