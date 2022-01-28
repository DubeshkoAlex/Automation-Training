package com.epam.tat.jdbc.model.tours;

import com.epam.tat.jdbc.model.types.TourType;

public class ShoppingTour extends AbstractTour {

    public ShoppingTour() {
        super();
        setType(TourType.SHOPPING);
    }
}
