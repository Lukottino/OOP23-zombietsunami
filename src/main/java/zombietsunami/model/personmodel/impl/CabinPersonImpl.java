package zombietsunami.model.personmodel.impl;

import zombietsunami.model.EntityImpl;
import zombietsunami.model.personmodel.api.CabinPerson;

/**
 * Class implementing the CabinPerson functionalities.
 * 
 * @see zombietsunami.model.personmodel.api.CabinPerson
 * @see zombietsunami.model.EntityImpl
 */
public class CabinPersonImpl implements CabinPerson {

    private final EntityImpl entity = new EntityImpl();
    private final int minStrenght;

    /**
     * Constructor that sets the default values for the CabinPerson.
     * 
     * @param minStrenght the minimum strenght to break the CabinPerson.
     */
    public CabinPersonImpl(final int minStrenght) {
        this.minStrenght = minStrenght;
    }

    /**
     * Gets the X coordinate of the CabinPerson.
     */
    @Override
    public int getX() {
        return this.entity.getX();
    }

    /**
     * Gets the Y coordinate of the CabinPerson.
     */
    @Override
    public int getY() {
        return this.entity.getY();
    }

    /**
     * Sets the X coordinate of the CabinPerson.
     */
    @Override
    public void setX(final int x) {
        this.entity.setX(x);
    }

    /**
     * Sets the Y coordinate of the CabinPerson.
     */
    @Override
    public void setY(final int y) {
        this.entity.setY(y);
    }

    /**
     * Returns the minimum strenght to break the CabinPerson.
     */
    @Override
    public int getMinStrenght() {
        return this.minStrenght;
    }

    /**
     * Method that checks if the zombie can break the CabinPerson.
     */
    @Override
    public boolean canBreakCabinPerson(final int zombieStrenght) {
        return this.getMinStrenght() <= zombieStrenght;
    }
}
