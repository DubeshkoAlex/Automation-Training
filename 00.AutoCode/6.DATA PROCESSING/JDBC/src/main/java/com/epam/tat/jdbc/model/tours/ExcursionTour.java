package com.epam.tat.jdbc.model.tours;

import com.epam.tat.jdbc.model.types.TourType;

public class ExcursionTour extends AbstractTour {

    public ExcursionTour() {
        super();
        setType(TourType.EXCURSION);
    }
}
