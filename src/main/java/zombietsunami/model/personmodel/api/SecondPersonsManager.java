package zombietsunami.model.personmodel.api;

import java.util.List;

import zombietsunami.Pair;

/**
 * Interface whose purpose is to manage all SecondPersons.
 */
public interface SecondPersonsManager {

    /**
     * Removes the "index" SecondPerson from the list.
     * 
     * @param index the index of the SecondPerson in the list.
     */
    void removeSecondPersonFromList(int index);

    /**
     * Returns the SecondPerson list.
     * 
     * @return the SecondPerson list.
     */
    List<SecondPerson> getSecondPersonList();

    /**
     * Sets the SecondPerson list from the map.
     * 
     * @param secondpersonlist The list of SecondPerson.
     * @param coords           The coordinates of SecondPerson.
     * @param strenght         The strenght of SecondPerson.
     */
    void setSecondPersonFromMap(List<Integer> secondpersonlist, List<Pair<Integer, Integer>> coords, Integer strenght);

    /**
     * Adds a SecondPerson into the SecondPerson list.
     * 
     * @param secondPerson the SecondPerson that needs to be added.
     */
    void addSecondPerson(SecondPerson secondPerson);
}
