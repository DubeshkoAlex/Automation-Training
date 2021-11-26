import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import Planes.*;
import models.MilitaryType;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = new ArrayList<>(planes);
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> getListOfRequiredTypeOfPlanes(Class<T> tClass) {
        List<T> requiredTypeOfPlane = new ArrayList<>();

        for (int i = 0; i < planes.size(); i++) {
            if((planes.get(i).getClass()).equals(tClass)){
                requiredTypeOfPlane.add((T)planes.get(i));
            }
        }
        return  requiredTypeOfPlane;
    }

    private List<MilitaryPlane> getListOfRequiredTypeOfMilitaryPlane(MilitaryType typeOfMilitaryPlane){
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> requiredMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane: militaryPlanes) {
            if(militaryPlane.getMilitaryType() == typeOfMilitaryPlane){
                requiredMilitaryPlanes.add(militaryPlane);
            }
        }
        return requiredMilitaryPlanes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return this.getListOfRequiredTypeOfPlanes(PassengerPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
         return this.getListOfRequiredTypeOfPlanes(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.getListOfRequiredTypeOfPlanes(ExperimentalPlane.class);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        return Collections.max(passengerPlanes, (o1, o2) -> o1.getPassengersCapacity() - o2.getPassengersCapacity());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.BOMBER);
    }

    public List<MilitaryPlane> getFighterMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.FIGHTER);
    }

    public Airport sortByMaxDistance() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(planes, airport.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=\n" + planes.toString() +
                "} \n";
    }
}
