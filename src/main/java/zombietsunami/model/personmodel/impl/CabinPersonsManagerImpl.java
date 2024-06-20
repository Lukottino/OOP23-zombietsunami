package zombietsunami.model.personmodel.impl;

import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import zombietsunami.Pair;
import zombietsunami.model.personmodel.api.CabinPerson;
import zombietsunami.model.personmodel.api.CabinPersonsManager;

/**
 * Class that manages everthing about CabinPersons.
 */
public class CabinPersonsManagerImpl implements CabinPersonsManager {

    private List<CabinPerson> cabinPersonList = new ArrayList<>();
    private static final int MIN_STRENGHT = 4;

    /**
     * Method that allows to remove a CabinPerson from the list.
     * 
     * @param index index of the CabinPerson.
     */
    @Override
    public void removeCabinPersonFromList(final int index) {
        cabinPersonList.set(index, null);
    }

    /**
     * Returns the CabinPerson list.
     * 
     * @return the CabinPerson list.
     */
    @SuppressFBWarnings(justification = "Persons inside personList must be"
            + " set null when colliding in CollisionImpl, otherwise the code won't work.")
    @Override
    public List<CabinPerson> getCabinPersonList() {
        return cabinPersonList;
    }

    /**
     * Returns the list of CabinPerson from the map.
     */
    @Override
    public void setCabinPersonFromMap(final List<Integer> cabinpersonlist, final List<Pair<Integer, Integer>> coords) {
        cabinPersonList = new ArrayList<>();
        for (int i = 0; i < cabinpersonlist.size(); i++) {
            if (cabinpersonlist.get(i) == 4 && coords.get(i) != null) {
                final CabinPerson cabinPerson = new CabinPersonImpl(MIN_STRENGHT);

                cabinPerson.setX(coords.get(i).getX());
                cabinPerson.setY(coords.get(i).getY());
                cabinPersonList.add(i, cabinPerson);
            } else {
                cabinPersonList.add(i, null);
            }
        }
    }

    /**
     * Adds a CabinPerson into the CabinPerson list.
     * 
     * @param cabinPerson the CabinPerson that needs to be added.
     */
    @Override
    public void addCabinPerson(final CabinPerson cabinPerson) {
        if (cabinPerson != null) {
            cabinPersonList.add(cabinPerson);
        }
    }

}
