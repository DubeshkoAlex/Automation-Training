package cars;

import carsEnum.BodyCar;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class EconomyCar extends Car {
    @JsonProperty("AudioPlayer")
    private boolean AudioPlayer;

    public EconomyCar(){}

    public EconomyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, int maxSpeed, int releaseYear, BodyCar bodyCar, boolean AudioPlayer) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.AudioPlayer = AudioPlayer;
    }

    public EconomyCar(String brand, String model, String maxLoadCapacity, String priceForKm, String cost, String fuelConsumption, String maxSpeed, String releaseYear, String bodyCar, String AudioPlayer){
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.AudioPlayer = Boolean.parseBoolean(AudioPlayer);
    }

    public boolean isAudioPlayer() {
        return AudioPlayer;
    }

    public void setAudioPlayer(boolean audioPlayer) {
        AudioPlayer = audioPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EconomyCar that = (EconomyCar) o;
        return AudioPlayer == that.AudioPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), AudioPlayer);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", AudioPlayer=" + AudioPlayer +"}");
    }
}
