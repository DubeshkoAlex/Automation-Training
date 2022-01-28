package com.epam.tat.jdbc.model;

import com.epam.tat.jdbc.model.tours.AbstractTour;
import com.epam.tat.jdbc.model.types.TourType;

import java.util.ArrayList;
import java.util.List;

public class TravelAgency {

    private List<AbstractTour> availableTours;

    public TravelAgency(List<AbstractTour> availableTours) {
        this.availableTours = availableTours;
    }

    public List<AbstractTour> getAvailableTours() {
        return availableTours;
    }

    public List<AbstractTour> getTourByType(TourType type) {
        List<AbstractTour> toursOfSpecificType = new ArrayList<>();
        for (AbstractTour tour : availableTours) {
            if (tour.getType().equals(type)) {
                toursOfSpecificType.add(tour);
            }
        }
        return toursOfSpecificType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TravelAgency that = (TravelAgency) o;
        return availableTours != null ? availableTours.equals(that.availableTours) : that.availableTours == null;
    }

    @Override
    public int hashCode() {
        return availableTours != null ? availableTours.hashCode() : 0;
    }
}
