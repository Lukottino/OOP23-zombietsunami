package zombietsunami.view.personview.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import zombietsunami.Pair;
import zombietsunami.view.api.VController;
import zombietsunami.view.personview.api.DrawSecondPerson;

/**
 * Implementation of the DrawSecondPerson interface, responsible
 * for drawing the SecondPerson.
 */
public class DrawSecondPersonImpl implements DrawSecondPerson {
    private boolean change = true;
    private int changeCounter;
    private static final int FRAMESCHANGE = 15;
    private static final String SEP = "/";
    private static final String ROOT = SEP + "zombietsunami" + SEP + "person" + SEP;
    private static final String PERSON_20 = ROOT + "person_20.png";
    private static final String PERSON_21 = ROOT + "person_21.png";

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
    @Override
    public void drawSecondPersonV(final Graphics2D g2, final List<Integer> secondPersonIndexList,
            final List<Pair<Integer, Integer>> screenTilePos,
            final int tileSize, final VController controller) {
        for (int i = 0; i < secondPersonIndexList.size(); i++) {
            if (secondPersonIndexList.get(i) == 2 && screenTilePos.get(i) != null) {
                controller.setSecondPersonFromMapC();
                drawSecondPerson(getSecondPerson(), g2, screenTilePos, tileSize, i);
            }
        }
    }

    /**
     * Draws the SecondPerson.
     * 
     * @param image         Image of SecondPerson.
     * @param g2            Graphics.
     * @param screenTilePos Coordinates of SecondPerson.
     * @param tileSize      Tile size.
     * @param i             Index of the SecondPerson in the list.
     */
    private void drawSecondPerson(final BufferedImage image, final Graphics2D g2,
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
     * Gets the image of the SecondPerson.
     */
    @Override
    public BufferedImage getSecondPerson() {
        final Logger logger = Logger.getLogger(DrawSecondPersonImpl.class.getName());
        BufferedImage image = null;
        try {
            if (change) {
                image = ImageIO.read(DrawSecondPersonImpl.class.getResource(PERSON_20));
            } else {
                image = ImageIO.read(DrawSecondPersonImpl.class.getResource(PERSON_21));
            }
            increaseChange();
            if (getChange() > FRAMESCHANGE) {
                change = !change;
                changeCounter = 0;
            }
        } catch (IOException e) {
            logger.severe("Errore durante il caricamento dell'immagine della seconda persona: " + e.getMessage());
        }
        return image;
    }
}
