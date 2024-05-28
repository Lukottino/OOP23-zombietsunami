package zombietsunami.view.personview.api;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.List;

import zombietsunami.Pair;
import zombietsunami.view.api.VController;

/**
 * Interfaces representing the drawing of SecondPerson.
 */
public interface DrawSecondPerson {

    /**
     * Draws the SecondPerson on the graphics context based on the same controller.
     * 
     * @param g2                    The graphics context.
     * @param secondPersonIndexList List of SecondPerson.
     * @param screenTilePos         Coordinates of the SecondPerson.
     * @param tileSize              Tile size.
     * @param controller            The controller with the game-related
     *                              information.
     */
    void drawSecondPersonV(Graphics2D g2, List<Integer> secondPersonIndexList,
            List<Pair<Integer, Integer>> screenTilePos,
            int tileSize, VController controller);

    /**
     * Gets the image representation of the SecondPerson.
     * 
     * @return The BufferedImage representing the SecondPerson.
     */
    BufferedImage getSecondPerson();
}
