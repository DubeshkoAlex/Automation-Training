package com.epam.tat.jdbc.model.tours;

import com.epam.tat.jdbc.model.types.MealType;
import com.epam.tat.jdbc.model.types.TourType;
import com.epam.tat.jdbc.model.types.TransportType;

import java.util.Objects;

public class AbstractTour {

    private int price;
    private int tourDuration;
    private TourType type;
    private TransportType transportType;
    private MealType mealType;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public TransportType getTrasport() {
        return transportType;
    }

    public void setTrasport(TransportType transportType) {
        this.transportType = transportType;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTour that = (AbstractTour) o;
        return price == that.price && tourDuration == that.tourDuration && type == that.type && transportType == that.transportType && mealType == that.mealType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, tourDuration, type, transportType, mealType);
    }

    @Override
    public String toString() {
        return "AbstractTour{" +
                "price=" + price +
                ", tourDuration=" + tourDuration +
                ", type=" + type +
                ", transportType=" + transportType +
                ", mealType=" + mealType +
                '}';
    }
}
