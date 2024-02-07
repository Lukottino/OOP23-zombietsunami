package zombietsunami.view.mapView.impl;

import java.util.ArrayList;
import java.util.List;

import zombietsunami.view.mapView.api.TileImage;
/**
 * This class implements the TielImage interface {@link zombietsunami.view.mapView.api.TileImage}.
 */
public final class TileImageImpl implements TileImage {

    private static final String SEP = "/";
    private static final String ROOT = SEP + "zombietsunami" + SEP + "tile" + SEP;

    private final List<TileImpl> itemMap = new ArrayList<>();

    @Override
    public List<TileImpl> setTileImage(final List<String> element) {
        for (int i = 0; i < element.size(); i++) {
            setSingleTile(i, element.get(i));
        }
        return itemMap;

    }

    /**
     * This method sets at the @param index of the list a new Tile with a new
     * BufferedImage.
     * 
     * @param index  the index of the List, which match the value of the tile
     * @param source the image file source name
     */
    private void setSingleTile(final int index, final String source) {
        this.itemMap.add(index, new TileImpl());
        this.itemMap.get(index).setImage(ROOT + source);
    }

}
