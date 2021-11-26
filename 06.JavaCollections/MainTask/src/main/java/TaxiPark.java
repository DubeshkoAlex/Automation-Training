import cars.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiPark {
    private List<? extends Car> cars;

    public TaxiPark(List<? extends Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public List<? extends Car> getCars() {
        return cars;
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> getListOfRequiredTypeOfCars(Class<T> tClass) {
        List<T> requiredTypeOfCars = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if((cars.get(i).getClass()).equals(tClass)){
                requiredTypeOfCars.add((T)cars.get(i));
            }
        }
        return  requiredTypeOfCars;
    }

    public List<? extends Car> getEconomyCars(){
        return this.getListOfRequiredTypeOfCars(EconomyCar.class);
    }

    public List<? extends Car> getComfortCars(){
        return this.getListOfRequiredTypeOfCars(ComfortCar.class);
    }

    public List<? extends Car> getFamilyCars(){
        return this.getListOfRequiredTypeOfCars(FamilyCar.class);
    }

    public List<? extends Car> getBusinessCars(){
        return this.getListOfRequiredTypeOfCars(BusinessCar.class);
    }

    public double TaxiParkCost(){
        double cost = 0;
        for (Car car:cars) {
            cost+=car.getCost();
        }
        return cost;
    }

    public TaxiPark sortByFuelConsumption(){
        cars.sort((Comparator<Car>)(o1,o2) -> (int) (o1.getFuelConsumption() - o2.getFuelConsumption()));
        return this;
    }

    public List<? extends Car> findCarsInSpeedRange(int lowLimit, int highLimit){
        List<Car> carsInSpeedRange = new ArrayList<>();
        for (Car car:cars) {
            if(car.getMaxSpeed()>=lowLimit && car.getMaxSpeed()<=highLimit){
                carsInSpeedRange.add(car);
            }
        }
        return carsInSpeedRange;
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                "cars=\n" + cars +
                '}';
    }
}
