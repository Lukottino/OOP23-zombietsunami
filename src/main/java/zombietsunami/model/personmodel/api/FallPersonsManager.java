package zombietsunami.model.personmodel.api;

import java.util.List;

import zombietsunami.Pair;

/**
 * Interface whose purpose is to manage all FallPersons.
 */
public interface FallPersonsManager {

    /**
     * Updates the state of the FallPerson.
     */
    /*
     * void updateFallPerson(List<Integer> fallpersonlist, List<Pair<Integer,
     * Integer>> coords);
     */

    /**
     * Removes the "index" FallPerson from the list.
     * 
     * @param index the index of the FallPerson in the list.
     */
    void removeFallPersonFromList(int index);

    /**
     * Returns the FallPerson list.
     * 
     * @return the FallPerson list.
     */
    List<FallPerson> getFallPersonList();

    /**
     * Sets the FallPerson list from the map.
     * 
     * @param fallpersonlist The list of FallPerson.
     * @param coords         The coordinates of FallPerson.
     */
    void setFallPersonFromMap(List<Integer> fallpersonlist, List<Pair<Integer, Integer>> coords);

    /**
     * Adds a FallPerson into the FallPerson list.
     * 
     * @param fallPerson the FallPerson that needs to be added.
     */
    void addFallPerson(FallPerson fallPerson);
}
