package zombietsunami.view.personview.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import zombietsunami.Pair;
import zombietsunami.view.api.VController;
import zombietsunami.view.personview.api.DrawCabinPerson;

/**
 * Implementation of the DrawCabinPerson interface, responsible
 * for drawing the CabinPerson.
 */
public class DrawCabinPersonImpl implements DrawCabinPerson {
    private boolean change = true;
    private int changeCounter;
    private static final int FRAMESCHANGE = 15;
    private static final String SEP = "/";
    private static final String ROOT = SEP + "zombietsunami" + SEP + "person" + SEP;
    private static final String PERSON_40 = ROOT + "person_40.png";
    private static final String PERSON_41 = ROOT + "person_41.png";

    /**
     * Draws the CabinPerson on the graphics context based on the same controller.
     * 
     * @param g2                   The graphics context.
     * @param cabinPersonIndexList List of CabinPerson.
     * @param screenTilePos        Coordinates of the CabinPerson.
     * @param tileSize             Tile size.
     * @param controller           The controller with the game-related information.
     */
    @Override
    public void drawCabinPersonV(final Graphics2D g2, final List<Integer> cabinPersonIndexList,
            final List<Pair<Integer, Integer>> screenTilePos,
            final int tileSize, final VController controller) {
        for (int i = 0; i < cabinPersonIndexList.size(); i++) {
            if (cabinPersonIndexList.get(i) == 4 && screenTilePos.get(i) != null) {
                controller.setCabinPersonFromMapC();
                drawCabinPerson(getCabinPerson(), g2, screenTilePos, tileSize, i);
            }
        }
    }

    /**
     * Draws the CabinPerson.
     * 
     * @param image         Image of CabinPerson.
     * @param g2            Graphics.
     * @param screenTilePos Coordinates of CabinPerson.
     * @param tileSize      Tile size.
     * @param i             Index of the CabinPerson in the list.
     */
    private void drawCabinPerson(final BufferedImage image, final Graphics2D g2,
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
     * Gets the image of the CabinPerson.
     */
    @Override
    public BufferedImage getCabinPerson() {
        final Logger logger = Logger.getLogger(DrawCabinPersonImpl.class.getName());
        BufferedImage image = null;
        try {
            if (change) {
                image = ImageIO.read(DrawCabinPersonImpl.class.getResource(PERSON_40));
            } else {
                image = ImageIO.read(DrawCabinPersonImpl.class.getResource(PERSON_41));
            }
            increaseChange();
            if (getChange() > FRAMESCHANGE) {
                change = !change;
                changeCounter = 0;
            }
        } catch (IOException e) {
            logger.severe("Errore durante il caricamento dell'immagine della cabin persona: " + e.getMessage());
        }
        return image;
    }
}
