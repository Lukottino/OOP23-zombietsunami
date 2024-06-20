package zombietsunami.model;

import java.util.List;
import java.util.Random;

import zombietsunami.model.zombiemodel.api.Zombie;
import zombietsunami.api.Collision;
import zombietsunami.model.mapmodel.api.GameMap;
import zombietsunami.model.obstaclemodel.api.Bomb;
import zombietsunami.model.obstaclemodel.api.Breakable;
import zombietsunami.model.personmodel.api.Person;
import zombietsunami.model.personmodel.api.SecondPerson;
import zombietsunami.model.personmodel.api.FallPerson;
import zombietsunami.model.personmodel.api.CabinPerson;

/**
 * Class whose purpose is to manage all the collisions
 * between the zombie and the obstacles.
 */
public class CollisionImpl implements Collision {

    private static final int THRESHOLD_1 = 70;
    private static final int THRESHOLD_2 = 95;
    private static final int RANGE = 100;
    private final Random rand = new Random();
    private boolean gameOver;

    /**
     * Checks whether the zombie has hit an obstacle.
     * 
     * @param bombList      the bomb list.
     * @param breakableList the bomb list.
     * @param tileSize      the size of one tile.
     * @param zombie        the zombie entity.
     * @param gameMap       the game map.
     */
    @Override
    public void collisionZombieObstacle(final List<Bomb> bombList, final List<Breakable> breakableList,
            final int tileSize, final Zombie zombie, final GameMap gameMap) {
        for (int i = bombList.size() - 1; i >= 0; i--) {
            if (!bombList.isEmpty() && bombList.get(i) != null
                    && bombList.get(i).getX() > THRESHOLD_1
                    && bombList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > bombList.get(i).getY() - tileSize
                    && zombie.getScreenY() < bombList.get(i).getY() + tileSize) {
                if (zombie.getStrength() - bombList.get(i).getDamage() < 0) {
                    gameOver = true;
                }
                zombie.decreaseStrength();
                bombList.set(i, null);
                gameMap.removeObstacleListItem(i);
            }
        }
        for (int i = breakableList.size() - 1; i >= 0; i--) {
            if (!breakableList.isEmpty() && breakableList.get(i) != null
                    && breakableList.get(i).getX() > THRESHOLD_1
                    && breakableList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > breakableList.get(i).getY() - tileSize
                    && zombie.getScreenY() < breakableList.get(i).getY() + tileSize) {
                if (breakableList.get(i).canBreakObstacle(zombie.getStrength())) {
                    gameMap.removeObstacleListItem(i);
                    breakableList.set(i, null);
                } else {
                    gameOver = true;
                }
            }
        }
    }

    /**
     * Checks if the strength is less than 0,
     * or if the zombie can't break the obstacle or the CabinPerson.
     * 
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Checks when the zombie hit a Persons.
     * 
     * @param personList       the Person list
     * @param secondPersonList the SecondPerson list
     * @param fallPersonList   the FallPerson list
     * @param cabinPersonList  the CabinPerson list
     * @param tileSize         the size of one tile
     * @param zombie           the Zombie entity
     * @param gameMap          the game map
     */
    @Override
    public void collisionZombiePersons(final List<Person> personList, final List<SecondPerson> secondPersonList,
            final List<FallPerson> fallPersonList, final List<CabinPerson> cabinPersonList, final int tileSize,
            final Zombie zombie, final GameMap gameMap) {
        for (int i = personList.size() - 1; i >= 0; i--) {
            if (!personList.isEmpty() && personList.get(i) != null && personList.get(i).getX() > THRESHOLD_1
                    && personList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > personList.get(i).getY() - tileSize
                    && zombie.getScreenY() < personList.get(i).getY() + tileSize) {
                zombie.increaseStrength();
                personList.set(i, null);
                gameMap.removePersonListItem(i);
            }
        }
        for (int i = secondPersonList.size() - 1; i >= 0; i--) {
            if (!secondPersonList.isEmpty() && secondPersonList.get(i) != null
                    && secondPersonList.get(i).getX() > THRESHOLD_1
                    && secondPersonList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > secondPersonList.get(i).getY() - tileSize
                    && zombie.getScreenY() < secondPersonList.get(i).getY() + tileSize) {
                zombie.increaseStrength();
                zombie.increaseStrength();
                secondPersonList.set(i, null);
                gameMap.removePersonListItem(i);
            }
        }
        for (int i = fallPersonList.size() - 1; i >= 0; i--) {
            if (!fallPersonList.isEmpty() && fallPersonList.get(i) != null
                    && fallPersonList.get(i).getX() > THRESHOLD_1
                    && fallPersonList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > fallPersonList.get(i).getY() - tileSize
                    && zombie.getScreenY() < fallPersonList.get(i).getY() + tileSize) {
                zombie.increaseStrength();
                fallPersonList.set(i, null);
                gameMap.removePersonListItem(i);
            }
        }
        for (int i = cabinPersonList.size() - 1; i >= 0; i--) {
            if (!cabinPersonList.isEmpty() && cabinPersonList.get(i) != null
                    && cabinPersonList.get(i).getX() > THRESHOLD_1
                    && cabinPersonList.get(i).getX() < THRESHOLD_2
                    && zombie.getScreenY() > cabinPersonList.get(i).getY() - tileSize
                    && zombie.getScreenY() < cabinPersonList.get(i).getY() + tileSize) {
                if (cabinPersonList.get(i).canBreakCabinPerson(zombie.getStrength())) {
                    final int randomInt = rand.nextInt(RANGE);
                    if (randomInt % 2 == 0) {
                        zombie.increaseStrength();
                    } else {
                        zombie.increaseStrength();
                        zombie.increaseStrength();
                    }
                    gameMap.removePersonListItem(i);
                    cabinPersonList.set(i, null);
                } else {
                    gameOver = true;
                }
            }
        }
    }
}
