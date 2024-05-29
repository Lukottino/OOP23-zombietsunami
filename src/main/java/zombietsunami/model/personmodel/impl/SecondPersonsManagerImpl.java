package zombietsunami.model.personmodel.impl;

import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import zombietsunami.Pair;
import zombietsunami.model.personmodel.api.SecondPerson;
import zombietsunami.model.personmodel.api.SecondPersonsManager;

/**
 * Class that manages everthing about SecondPersons.
 */
public class SecondPersonsManagerImpl implements SecondPersonsManager {

    private List<SecondPerson> secondPersonList = new ArrayList<>();

    /**
     * Method that allows to remove a SecondPerson from the list.
     * 
     * @param index index of the SecondPerson.
     */
    @Override
    public void removeSecondPersonFromList(final int index) {
        secondPersonList.set(index, null);
    }

    /**
     * Returns the SecondPerson list.
     * 
     * @return the SecondPerson list.
     */
    @SuppressFBWarnings(justification = "SecondPersons inside secondPersonList must be"
            + " set null when colliding in CollisionImpl, otherwise the code won't work.")
    @Override
    public List<SecondPerson> getSecondPersonList() {
        return secondPersonList;
    }

    /**
     * Returns the list of SecondPerson from the map.
     */
    @Override
    public void setSecondPersonFromMap(final List<Integer> secondpersonlist, final List<Pair<Integer, Integer>> coords,
            final Integer strenght) {
        secondPersonList = new ArrayList<>();
        for (int i = 0; i < secondpersonlist.size(); i++) {
            if (secondpersonlist.get(i) == 2 && coords.get(i) != null) {
                final SecondPerson secondPerson = new SecondPersonImpl();

                secondPerson.setX(coords.get(i).getX());
                secondPerson.setY(coords.get(i).getY());

                secondPersonList.add(i, secondPerson);
            } else {
                secondPersonList.add(i, null);
            }
        }
    }

    /**
     * Adds a SecondPerson into the SecondPerson list.
     * 
     * @param secondPerson the SecondPerson that needs to be added.
     */
    @Override
    public void addSecondPerson(final SecondPerson secondPerson) {
        if (secondPerson != null) {
            secondPersonList.add(secondPerson);
        }
    }

}
