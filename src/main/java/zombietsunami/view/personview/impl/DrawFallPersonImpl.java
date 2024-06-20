package zombietsunami.view.personview.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import zombietsunami.Pair;
// import zombietsunami.api.Controller;
// import zombietsunami.controller.ControllerImpl;
import zombietsunami.view.api.VController;
import zombietsunami.view.personview.api.DrawFallPerson;

/**
 * Implementation of the DrawPerson interface, responsible
 * for drawing the Person.
 */
public class DrawFallPersonImpl implements DrawFallPerson {
    private boolean change = true;
    private int changeCounter;
    private static final int FRAMESCHANGE = 15;
    /* private static final int PROXIMITY = 1000; */
    private static final String SEP = "/";
    private static final String ROOT = SEP + "zombietsunami" + SEP + "person" + SEP;
    private static final String PERSON_30 = ROOT + "person_30.png";
    private static final String PERSON_31 = ROOT + "person_31.png";

    /**
     * Draws the FallPerson on the graphics context based on the same controller.
     * 
     * @param g2                  The graphics context.
     * @param fallPersonIndexList List of FallPerson.
     * @param screenTilePos       Coordinates of the FallPerson.
     * @param tileSize            Tile size.
     * @param controller          The controller with the game-related information.
     */
    @Override
    public void drawFallPersonV(final Graphics2D g2, final List<Integer> fallPersonIndexList,
            final List<Pair<Integer, Integer>> screenTilePos,
            final int tileSize, final VController controller) {
        for (int i = 0; i < fallPersonIndexList.size(); i++) {
            if (fallPersonIndexList.get(i) == 3 && screenTilePos.get(i) != null) {
                controller.setFallPersonFromMapC();
                drawFallPerson(getFallPerson(), g2, screenTilePos, tileSize, i);
            }
        }
    }

    /**
     * Draws the FallPerson.
     * 
     * @param image         Image of FallPerson.
     * @param g2            Graphics.
     * @param screenTilePos Coordinates of FallPerson.
     * @param tileSize      Tile size.
     * @param i             Index of the FallPerson in the list.
     */
    private void drawFallPerson(final BufferedImage image, final Graphics2D g2,
            final List<Pair<Integer, Integer>> screenTilePos, final int tileSize, final int i) {
        g2.drawImage(image, screenTilePos.get(i).getX(), screenTilePos.get(i).getY(), tileSize, tileSize, null);
    }

    private int getChange() {
        return changeCounter;
    }

    private int increaseChange() {
        return changeCounter++;
    }

    /**
     * Gets the image of the FallPerson.
     */
    @Override
    public BufferedImage getFallPerson() {
        final Logger logger = Logger.getLogger(DrawFallPersonImpl.class.getName());
        BufferedImage image = null;
        try {
            if (change) {
                image = ImageIO.read(DrawFallPersonImpl.class.getResource(PERSON_30));
            } else {
                image = ImageIO.read(DrawFallPersonImpl.class.getResource(PERSON_31));
            }
            increaseChange();
            if (getChange() > FRAMESCHANGE) {
                change = !change;
                changeCounter = 0;
            }
        } catch (IOException e) {
            logger.severe("Errore durante il caricamento dell'immagine della fall persona: " + e.getMessage());
        }
        return image;
    }

    /*
     * private void updateFallPerson(final VController controller) {
     * controller.updateFallPerson();
     * }
     */

    /**
     * Checks the proximity of the zombie with FallPerson.
     * 
     * @param controller          The controller with the game-related information.
     * @param fallPersonIndexList List of FallPerson.
     * @param screenTilePos       Coordinates of FallPerson.
     */
    /*
     * public void checkZombieProximity(final VController controller, final
     * List<Integer> fallPersonIndexList,
     * final List<Pair<Integer, Integer>> screenTilePos) {
     * for (int i = 0; i < fallPersonIndexList.size(); i++) {
     * if (fallPersonIndexList.get(i) == 3 && screenTilePos.get(i) != null) {
     * if (controller.getZombieScreenX() >= (screenTilePos.get(i).getY() -
     * PROXIMITY)) {
     * updateFallPerson(controller);
     * }
     * }
     * }
     * }
     */
}
