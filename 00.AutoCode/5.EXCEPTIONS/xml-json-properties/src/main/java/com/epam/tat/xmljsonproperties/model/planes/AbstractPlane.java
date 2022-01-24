package com.epam.tat.xmljsonproperties.model.planes;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.Objects;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "Type"
)
@JsonSubTypes(
        {
           @JsonSubTypes.Type( name = "military", value = MilitaryPlane.class ),
           @JsonSubTypes.Type( name = "passenger", value = PassengerPlane.class ),
        }
)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlSeeAlso({MilitaryPlane.class,PassengerPlane.class})
public abstract class AbstractPlane {

    @JsonProperty("Model")
    private String model;
    @JsonProperty("Speed")
    private int maxSpeed;
    @JsonProperty("Distance")
    private int maxFlightDistance;

    public AbstractPlane() {
        super();
    }

    public AbstractPlane(String model, int maxSpeed, int maxFlightDistance) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
    }

    public String getModel() {
        return model;
    }

    @XmlAttribute(name = "model")
    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @XmlElement(name = "Speed")
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    @XmlElement(name = "Distance")
    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;
        return maxSpeed == that.maxSpeed &&
                maxFlightDistance == that.maxFlightDistance &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance);
    }

    @Override
    public String toString() {
        return "AbstractPlane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                '}';
    }

}
