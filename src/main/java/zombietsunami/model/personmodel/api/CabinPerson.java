package zombietsunami.model.personmodel.api;

/**
 * Defines the CabinPerson object.
 */
public interface CabinPerson {

    /**
     * Gets the X coordinate of the CabinPerson.
     * 
     * @return the X coordinate of the CabinPerson.
     */
    int getX();

    /**
     * Gets the Y coordinate of the CabinPerson.
     * 
     * @return the Y coordinate of the CabinPerson.
     */
    int getY();

    /**
     * Sets the X coordinate of the CabinPerson.
     * 
     * @param x X coordinate.
     */
    void setX(int x);

    /**
     * Sets the Y coordinate of the CabinPerson.
     * 
     * @param y Y coordinate.
     */
    void setY(int y);

    /**
     * Returns the minimum strenght to break the CabinPerson.
     * 
     * @return the minimum strenght to break the CabinPerson.
     */
    int getMinStrenght();

    /**
     * Method that checks if the zombie can break the CabinPerson.
     * 
     * @return true if the zombie's strenght is greater than the CabinPerson's
     *         value, false otherwise.
     * @param zombieStrenght the strenght of the Zombie.
     */
    boolean canBreakCabinPerson(int zombieStrenght);
}
