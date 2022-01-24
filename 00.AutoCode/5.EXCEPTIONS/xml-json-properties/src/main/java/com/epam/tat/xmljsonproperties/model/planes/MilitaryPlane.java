package com.epam.tat.xmljsonproperties.model.planes;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "MilitaryPlane")
public class MilitaryPlane extends AbstractPlane {

    @JsonProperty("MilitaryType")
    private String militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, String militaryType) {
        super(model, maxSpeed, maxFlightDistance);
        this.militaryType = militaryType;
    }

    public MilitaryPlane() {
        super();
    }

    public String getMilitaryType() {
        return militaryType;
    }

    @XmlElement(name = "MilitaryType")
    public void setMilitaryType(String militaryType) {
        this.militaryType = militaryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MilitaryPlane that = (MilitaryPlane) o;
        return Objects.equals(militaryType, that.militaryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }

    @Override
    public String toString() {
        return "MilitaryPlane{" +
                "militaryType='" + militaryType + '\'' +
                "} " + super.toString();
    }

}
