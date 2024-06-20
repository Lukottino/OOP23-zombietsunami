package zombietsunami;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import zombietsunami.model.MapData;
import zombietsunami.model.mapmodel.api.GameMap;
import zombietsunami.model.mapmodel.impl.GameMapImpl;
import zombietsunami.model.personmodel.api.CabinPersonsManager;
import zombietsunami.model.personmodel.impl.CabinPersonsManagerImpl;
import zombietsunami.model.personmodel.impl.CabinPersonImpl;
import zombietsunami.model.zombiemodel.api.Zombie;
import zombietsunami.model.zombiemodel.impl.ZombieImpl;

/**
 * Class that tests the funcionalities of CabinPersonManager.
 */
class TestCabinPersonManager {

    private final CabinPersonsManager cabinPersonsManager = new CabinPersonsManagerImpl();
    private final GameMap gameMap = new GameMapImpl();
    private final Zombie zombie = new ZombieImpl();

    /**
     * Checks if the list of CabinPerson are setted.
     */
    @Test
    void checkCabinPersonListSetted() {
        cabinPersonsManager.setCabinPersonFromMap(gameMap.getLoadedPersonList(),
                gameMap.getScreenTilePos(MapData.getMaxWorldRow(), MapData.getMaxWorldCol(),
                        MapData.getTitSize(), zombie.getX(), zombie.getY(),
                        this.zombie.getScreenX(), this.zombie.getScreenY()));

        assertNotEquals(cabinPersonsManager.getCabinPersonList().size(), 0);
    }

    /**
     * Tests if the CabinPerson are added correctly to the list.
     */
    @Test
    void testAddCabinPerson() {
        final int cabinPersonListSize = cabinPersonsManager.getCabinPersonList().size();
        cabinPersonsManager.addCabinPerson(new CabinPersonImpl(1));

        assertNotEquals(cabinPersonListSize, cabinPersonsManager.getCabinPersonList());
    }

    /**
     * Tests if the CabinPerson are removed correctly from the list.
     */
    @Test
    void testRemoveCabinPerson() {
        cabinPersonsManager.addCabinPerson(new CabinPersonImpl(1));
        cabinPersonsManager.removeCabinPersonFromList(0);
        assertEquals(cabinPersonsManager.getCabinPersonList().get(0), null);
    }

    /**
     * Tests if GetCabinPersonList() return correctly.
     */
    @Test
    void testGetCabinPersonList() {
        assertNotEquals(cabinPersonsManager.getCabinPersonList(), null);
    }
}
