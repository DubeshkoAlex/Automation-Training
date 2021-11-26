package cars;

import carsEnum.BodyCar;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public abstract class Car {
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("maxLoadCapacity")
    private int maxLoadCapacity;
    @JsonProperty("priceForKm")
    private double priceForKm;
    @JsonProperty("cost")
    private double cost;
    @JsonProperty("fuelConsumption")
    private double fuelConsumption;
    @JsonProperty("maxSpeed")
    private int maxSpeed;
    @JsonProperty("releaseYear")
    private int releaseYear;
    @JsonProperty("bodyCar")
    private BodyCar bodyCar;

    public Car(){}

    public Car(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, int maxSpeed, int releaseYear, BodyCar bodyCar) {
        this.brand = brand;
        this.model = model;
        this.maxLoadCapacity = maxLoadCapacity;
        this.priceForKm = priceForKm;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.releaseYear = releaseYear;
        this.bodyCar = bodyCar;
    }

    public Car(String brand, String model, String maxLoadCapacity, String priceForKm, String cost, String fuelConsumption, String maxSpeed, String releaseYear, String bodyCar){
        this.brand = brand;
        this.model = model;
        this.maxLoadCapacity = Integer.parseInt(maxLoadCapacity);
        this.priceForKm = Double.parseDouble(priceForKm);
        this.cost = Double.parseDouble(cost);
        this.fuelConsumption = Double.parseDouble(fuelConsumption);
        this.maxSpeed = Integer.parseInt(maxSpeed);
        this.releaseYear = Integer.parseInt(releaseYear);
        this.bodyCar = BodyCar.valueOf(bodyCar);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public double getPriceForKm() {
        return priceForKm;
    }

    public double getCost() {
        return cost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public BodyCar getBodyCar() {
        return bodyCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return maxLoadCapacity == car.maxLoadCapacity && Double.compare(car.priceForKm, priceForKm) == 0 && Double.compare(car.cost, cost) == 0 && Double.compare(car.fuelConsumption, fuelConsumption) == 0 && Double.compare(car.maxSpeed, maxSpeed) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", maxLoadCapacity=" + maxLoadCapacity +
                ", priceForKm=" + priceForKm +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                ", releaseYear=" + releaseYear +
                ", bodyCar=" + bodyCar +
                "}\n";
    }
}
