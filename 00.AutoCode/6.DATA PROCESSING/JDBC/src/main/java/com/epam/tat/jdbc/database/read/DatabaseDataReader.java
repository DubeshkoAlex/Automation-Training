package com.epam.tat.jdbc.database.read;

import com.epam.tat.jdbc.database.DatabaseUtils;
import com.epam.tat.jdbc.model.TravelAgency;
import com.epam.tat.jdbc.model.tours.AbstractTour;
import com.epam.tat.jdbc.model.types.MealType;
import com.epam.tat.jdbc.model.types.TourType;
import com.epam.tat.jdbc.model.types.TransportType;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseDataReader extends AbstractDataReader {

    public DatabaseDataReader(String sourceIdentifier) {
        super(sourceIdentifier);
    }

    @Override
    public TravelAgency readFromDataBase() {
        String tableName = "tours";
        DatabaseUtils databaseUtils = new DatabaseUtils(getSourceIdentifier(),tableName);
        Connection connection = databaseUtils.getConnection();
        String query = "SELECT * FROM " + tableName;
        Map<Integer, Map<String,String>> dataRows;
        dataRows = databaseUtils.readFromDBTable(query);
        List<AbstractTour> abstractTours = new ArrayList<>();

        int rowsCount = dataRows.size();
        for (int i = 1; i <= rowsCount; i++) {
            AbstractTour abstractTour = new AbstractTour();
            abstractTour.setPrice(Integer.parseInt(dataRows.get(i).get("PRICE"))); // there is need to be an exception
            abstractTour.setTourDuration(Integer.parseInt(dataRows.get(i).get("TOURDURATION")));
            abstractTour.setType(TourType.valueOf(dataRows.get(i).get("TOURTYPE")));
            abstractTour.setTrasport(TransportType.valueOf(dataRows.get(i).get("TRANSPORTTYPE")));
            abstractTour.setMealType(MealType.valueOf(dataRows.get(i).get("MEALTYPE")));
            abstractTours.add(abstractTour);
        }
        return new TravelAgency(abstractTours);
    }

}
