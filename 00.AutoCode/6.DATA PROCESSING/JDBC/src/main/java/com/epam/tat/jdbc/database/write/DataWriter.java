package com.epam.tat.jdbc.database.write;

import com.epam.tat.jdbc.model.TravelAgency;

public interface DataWriter {

    void writeToDatabase(TravelAgency travelAgency);
}
