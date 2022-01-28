package com.epam.tat.jdbc.model.tours;

import com.epam.tat.jdbc.model.types.TourType;

public class LeisureTour extends AbstractTour {

    public LeisureTour() {
        super();
        setType(TourType.LEISURE);
    }
}
