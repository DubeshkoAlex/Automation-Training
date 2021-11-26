package cars;

import carsEnum.BodyCar;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ComfortCar extends Car {
    @JsonProperty("airbagCount")
    private int airbagCount;
    @JsonProperty("conditioner")
    private boolean conditioner;

    public ComfortCar(){}

    public ComfortCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, int maxSpeed, int releaseYear, BodyCar bodyCar, int airbagCount, boolean conditioner) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.airbagCount = airbagCount;
        this.conditioner = conditioner;
    }

    public int getAirbagCount() {
        return airbagCount;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComfortCar that = (ComfortCar) o;
        return airbagCount == that.airbagCount && conditioner == that.conditioner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), airbagCount, conditioner);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", airbagCount=" + airbagCount +
                ", conditioner=" + conditioner +
                "}");
    }
}
