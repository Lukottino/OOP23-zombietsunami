package zombietsunami.model.personmodel.impl;

import zombietsunami.model.EntityImpl;
import zombietsunami.model.personmodel.api.FallPerson;

/**
 * Class implementing the FallPerson functionalities.
 * 
 * @see zombietsunami.model.personmodel.api.FallPerson
 * @see zombietsunami.model.EntityImpl
 */
public class FallPersonImpl implements FallPerson {

    private final EntityImpl entity = new EntityImpl();

    /**
     * Gets the X coordinate of the FallPerson.
     */
    @Override
    public int getX() {
        return this.entity.getX();
    }

    /**
     * Gets the Y coordinate of the FallPerson.
     */
    @Override
    public int getY() {
        return this.entity.getY();
    }

    /**
     * Sets the X coordinate of the FallPerson.
     */
    @Override
    public void setX(final int x) {
        this.entity.setX(x);
    }

    /**
     * Sets the Y coordinate of the FallPerson.
     */
    @Override
    public void setY(final int y) {
        this.entity.setY(y);
    }
}
