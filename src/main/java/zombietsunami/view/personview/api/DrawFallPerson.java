package zombietsunami.view.personview.api;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.List;

import zombietsunami.Pair;
import zombietsunami.view.api.VController;

/**
 * Interfaces representing the drawing of FallPerson.
 */
public interface DrawFallPerson {

    /**
     * Draws the FallPerson on the graphics context based on the same controller.
     * 
     * @param g2                  The graphics context.
     * @param fallPersonIndexList List of FallPerson.
     * @param screenTilePos       Coordinates of the FallPerson.
     * @param tileSize            Tile size.
     * @param controller          The controller with the game-related information.
     */
    void drawFallPersonV(Graphics2D g2, List<Integer> fallPersonIndexList, List<Pair<Integer, Integer>> screenTilePos,
            int tileSize, VController controller);

    /**
     * Gets the image representation of the FallPerson.
     * 
     * @return The BufferedImage representing the FallPerson.
     */
    BufferedImage getFallPerson();

    /**
     * Checks the proximity of the zombie with FallPerson.
     * 
     * @param controller          The controller with the game-related information.
     * @param fallPersonIndexList List of FallPerson.
     * @param screenTilePos       Coordinates of FallPerson.
     */
    /*
     * void checkZombieProximity(VController controller, List<Integer>
     * fallPersonIndexList,
     * List<Pair<Integer, Integer>> screenTilePos);
     */
}
