package zombietsunami.model.personmodel.impl;

import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import zombietsunami.Pair;
import zombietsunami.model.personmodel.api.FallPerson;
import zombietsunami.model.personmodel.api.FallPersonsManager;

/**
 * Class that manages everthing about Persons.
 */
public class FallPersonsManagerImpl implements FallPersonsManager {

    private List<FallPerson> fallPersonList = new ArrayList<>();
    /*
     * private static final int FALL_SPEED = 6;
     * private static final int FINALFALLPERSON_Y = 270;
     */

    /**
     * Updates the FallPerson's position on its fall speed.
     */
    /*
     * @Override
     * public void updateFallPerson(final List<Integer> fallpersonlist, final
     * List<Pair<Integer, Integer>> coords) {
     * 
     * INSIEME DI PROVE FATTE
     * if(entity.getY() < FINALFALLPERSON_Y){
     * entity.setY(entity.getY() - FALL_SPEED);
     * }
     * for (int i = 0; i < fallpersonlist.size(); i++) {
     * if (fallpersonlist.get(i) == 3 && coords.get(i) != null) {
     * entity.setY(coords.get(i).getY() - FALL_SPEED);
     * for(int m=entity.getY();m < FINALFALLPERSON_Y;m++){
     * entity.setY(entity.getY() - FALL_SPEED);
     * }
     * }
     * }
     * for(int i=0; i<fallPersonList.size(); i++){
     * fallPersonList.get(i).setY(fallPersonList.get(i).getY()-FALL_SPEED);
     * }
     * fallPersonList.get(1).setY(fallPersonList.get(1).getY() - FALL_SPEED);
     * List<FallPerson> fallPersons = new ArrayList<>();
     * fallPersons = getFallPersonList();
     * int counter=fallPersonList.size();
     * for (int i = 550; i < fallPersons.size(); i++) {
     * setFallPersonFromMap(fallpersonlist, coords);
     * 
     * IDEA FINALE
     * for (int i = 0; i < fallPersonList.size(); i++) {
     * if (fallPersonList.get(i) != null && fallPersonList.get(i).getY() <
     * FINALFALLPERSON_Y) {
     * fallPersonList.get(i).setY(fallPersonList.get(i).getY() + FALL_SPEED);
     * }
     * }
     * }
     */

    /**
     * Method that allows to remove a FallPerson from the list.
     * 
     * @param index index of the FallPerson.
     */
    @Override
    public void removeFallPersonFromList(final int index) {
        fallPersonList.set(index, null);
    }

    /**
     * Returns the FallPerson list.
     * 
     * @return the FallPerson list.
     */
    @SuppressFBWarnings(justification = "FallPersons inside fallPersonList must be"
            + " set null when colliding in CollisionImpl, otherwise the code won't work.")
    @Override
    public List<FallPerson> getFallPersonList() {
        return fallPersonList;
    }

    /**
     * Returns the list of FallPerson from the map.
     */
    @Override
    public void setFallPersonFromMap(final List<Integer> fallpersonlist, final List<Pair<Integer, Integer>> coords) {
        fallPersonList = new ArrayList<>();
        for (int i = 0; i < fallpersonlist.size(); i++) {
            if (fallpersonlist.get(i) == 3 && coords.get(i) != null) {
                final FallPerson fallPerson = new FallPersonImpl();

                fallPerson.setX(coords.get(i).getX());
                fallPerson.setY(coords.get(i).getY());

                fallPersonList.add(i, fallPerson);
            } else {
                fallPersonList.add(i, null);
            }
        }
    }

    /**
     * Adds a FallPerson into the FallPerson list.
     * 
     * @param fallPerson the FallPerson that needs to be added.
     */
    @Override
    public void addFallPerson(final FallPerson fallPerson) {
        if (fallPerson != null) {
            fallPersonList.add(fallPerson);
        }
    }

}
