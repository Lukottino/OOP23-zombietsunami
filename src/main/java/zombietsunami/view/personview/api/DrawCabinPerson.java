package zombietsunami.view.personview.api;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.List;

import zombietsunami.Pair;
import zombietsunami.view.api.VController;

/**
 * Interfaces representing the drawing of CabinPerson.
 */
public interface DrawCabinPerson {

    /**
     * Draws the CabinPerson on the graphics context based on the same controller.
     * 
     * @param g2                   The graphics context.
     * @param cabinPersonIndexList List of CainPerson.
     * @param screenTilePos        Coordinates of the CabinPerson.
     * @param tileSize             Tile size.
     * @param controller           The controller with the game-related information.
     */
    void drawCabinPersonV(Graphics2D g2, List<Integer> cabinPersonIndexList, List<Pair<Integer, Integer>> screenTilePos,
            int tileSize, VController controller);

    /**
     * Gets the image representation of the CabinPerson.
     * 
     * @return The BufferedImage representing the CabinPerson.
     */
    BufferedImage getCabinPerson();
}
