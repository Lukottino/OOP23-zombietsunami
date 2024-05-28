package zombietsunami.model.personmodel.impl;

import zombietsunami.model.EntityImpl;
import zombietsunami.model.personmodel.api.SecondPerson;

/**
 * Class implementing the SecondPerson functionalities.
 * 
 * @see zombietsunami.model.personmodel.api.SecondPerson
 * @see zombietsunami.model.EntityImpl
 */
public class SecondPersonImpl implements SecondPerson {

    private final EntityImpl entity = new EntityImpl();

    /**
     * Gets the X coordinate of the SecondPerson.
     */
    @Override
    public int getX() {
        return this.entity.getX();
    }

    /**
     * Gets the Y coordinate of the SecondPerson.
     */
    @Override
    public int getY() {
        return this.entity.getY();
    }

    /**
     * Sets the X coordinate of the SecondPerson.
     */
    @Override
    public void setX(final int x) {
        this.entity.setX(x);
    }

    /**
     * Sets the Y coordinate of the SecondPerson.
     */
    @Override
    public void setY(final int y) {
        this.entity.setY(y);
    }
}
