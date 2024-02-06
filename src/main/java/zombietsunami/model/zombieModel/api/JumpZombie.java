package zombietsunami.model.zombieModel.api;

/**
 * This interface defines the jumping behavior of a Zombie, enabling it to perform jumps.
 */
public interface JumpZombie {

    /**
     * Initiates the jump action for the zombie.
     */
    void jumpPress();

    /**
     * Checks if the zombie is currently jumping.
     * @return true if the zombie is jumping.
     */
    boolean getJumping();

    /**
     * Updates the jump action for the zombie.
     */
    void updateJumpZombie();
}

