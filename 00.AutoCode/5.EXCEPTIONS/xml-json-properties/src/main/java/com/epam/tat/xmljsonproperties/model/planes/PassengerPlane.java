package com.epam.tat.xmljsonproperties.model.planes;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "PassengerPlane")
public class PassengerPlane extends AbstractPlane {

    @JsonProperty("Capacity")
    private int maxPassengerCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxPassengerCapacity, int maxFlightDistance) {
        super(model, maxSpeed, maxFlightDistance);
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public PassengerPlane() {
        super();
    }

    public int getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    @XmlElement(name = "Capacity")
    public void setMaxPassengerCapacity(int maxPassengerCapacity) {
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return maxPassengerCapacity == that.maxPassengerCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxPassengerCapacity);
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "maxPassengerCapacity=" + maxPassengerCapacity +
                "} " + super.toString();
    }
}
