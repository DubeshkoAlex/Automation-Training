package com.epam.tat.xmljsonproperties.model;

import com.epam.tat.xmljsonproperties.model.planes.AbstractPlane;
import com.epam.tat.xmljsonproperties.model.planes.MilitaryPlane;
import com.epam.tat.xmljsonproperties.model.planes.PassengerPlane;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@XmlRootElement(name = "planes")
public class AirCompany {
    @XmlElements({
            @XmlElement(name = "MilitaryPlane", type = MilitaryPlane.class),
            @XmlElement(name = "PassengerPlane", type = PassengerPlane.class)
    })
    private List<AbstractPlane> planes;

    public AirCompany() {
        planes = new ArrayList<>();
    }

    public AirCompany(List<AbstractPlane> planes) {
        this.planes = planes;
    }

    @JsonIgnore
    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    @JsonIgnore
    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> passengerPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                passengerPlanes.add((MilitaryPlane) plane);
            }
        }
        return passengerPlanes;
    }

    @JsonIgnore
    public int getTotalNumberOfPlanes() {
        return planes.size();
    }

    public List<AbstractPlane> getPlanes() {
        return planes;
    }

}
