package zombietsunami.model.personmodel.api;

import java.util.List;

import zombietsunami.Pair;

/**
 * Interface whose purpose is to manage all CabinPersons.
 */
public interface CabinPersonsManager {

    /**
     * Removes the "index" CabinPerson from the list.
     * 
     * @param index the index of the CabinPerson in the list.
     */
    void removeCabinPersonFromList(int index);

    /**
     * Returns the CabinPerson list.
     * 
     * @return the CabinPerson list.
     */
    List<CabinPerson> getCabinPersonList();

    /**
     * Sets the CabinPerson list from the map.
     * 
     * @param cabinpersonlist The list of CabinPerson.
     * @param coords          The coordinates of CabinPerson.
     */
    void setCabinPersonFromMap(List<Integer> cabinpersonlist, List<Pair<Integer, Integer>> coords);

    /**
     * Adds a CabinPerson into the CabinPerson list.
     * 
     * @param cabinPerson the CabinPerson that needs to be added.
     */
    void addCabinPerson(CabinPerson cabinPerson);
}
