package com.epam.tat.jdbc.database.write;

import com.epam.tat.jdbc.database.DatabaseUtils;
import com.epam.tat.jdbc.exceptions.DatabaseWriteException;
import com.epam.tat.jdbc.model.TravelAgency;

import java.util.Locale;

public class DatabaseDataWriter extends AbstractDataWriter {

    public DatabaseDataWriter(String sourceIdentifier) {
        super(sourceIdentifier);
    }

    @Override
    public void writeToDatabase(TravelAgency travelAgency) {
        String tableName = "tours";
        DatabaseUtils databaseUtils = new DatabaseUtils(getSourceIdentifier(),tableName);
        databaseUtils.dropTable();
        databaseUtils.createTable();
        StringBuilder queryInsert = new StringBuilder();
        queryInsert.append("INSERT INTO " + tableName.toUpperCase(Locale.ROOT) + " (Price, TourDuration, TourType, TransportType, MealType) VALUES ");
        try {
            travelAgency.getAvailableTours().forEach(abstractTour -> {
                if(abstractTour.getPrice()==0 && abstractTour.getTourDuration() == 0 && abstractTour.getTrasport() == null && abstractTour.getMealType() == null){
                    throw new DatabaseWriteException("Incorrect tour value!");
                }
                queryInsert.append("(" + abstractTour.getPrice() + ","
                        + abstractTour.getTourDuration() + ","
                        + "\'" + abstractTour.getType() + "\',"
                        + "\'" + abstractTour.getTrasport() + "\',"
                        + "\'" + abstractTour.getMealType() + "\'),");
            });
        }catch (NullPointerException e){
            throw new DatabaseWriteException("Incorrect travelAgency value!");
        }
        queryInsert.replace(queryInsert.length()-1, queryInsert.length(),"");
        databaseUtils.writeDataIntoDBTable(queryInsert.toString());

    }

}
