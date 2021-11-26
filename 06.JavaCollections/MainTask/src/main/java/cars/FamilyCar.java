package cars;

import carsEnum.BodyCar;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class FamilyCar extends Car{
    @JsonProperty("babySeatCount")
    private int babySeatCount;
    @JsonProperty("tabletsCount")
    private int tabletsCount;

    public FamilyCar(){}

    public FamilyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, int maxSpeed, int releaseYear, BodyCar bodyCar, int babySeatCount, int tabletsCount) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.babySeatCount = babySeatCount;
        this.tabletsCount = tabletsCount;
    }

    public FamilyCar(String brand, String model, String maxLoadCapacity, String priceForKm, String cost, String fuelConsumption, String maxSpeed, String releaseYear, String bodyCar, String babySeatCount, String tabletsCount){
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.babySeatCount = Integer.parseInt(babySeatCount);
        this.tabletsCount = Integer.parseInt(tabletsCount);
    }

    public int getBabySeatCount() {
        return babySeatCount;
    }

    public int getTabletsCount() {
        return tabletsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FamilyCar familyCar = (FamilyCar) o;
        return babySeatCount == familyCar.babySeatCount && tabletsCount == familyCar.tabletsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), babySeatCount, tabletsCount);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", babySeatCount=" + babySeatCount +
                ", tabletsCount=" + tabletsCount +
                "}");
    }
}
