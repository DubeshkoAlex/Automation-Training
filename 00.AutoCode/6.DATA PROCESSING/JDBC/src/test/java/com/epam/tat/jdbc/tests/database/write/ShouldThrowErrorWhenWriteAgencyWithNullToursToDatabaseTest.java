package com.epam.tat.jdbc.tests.database.write;

import com.epam.tat.jdbc.exceptions.DatabaseWriteException;
import com.epam.tat.jdbc.model.TravelAgency;
import com.epam.tat.jdbc.model.tours.AbstractTour;
import com.epam.tat.jdbc.tests.base.BaseDatabaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShouldThrowErrorWhenWriteAgencyWithNullToursToDatabaseTest extends BaseDatabaseTest {

    @Test
    public void shouldThrowErrorWhenWriteAgencyWithNullToursToDatabase() {
        List<AbstractTour> emptyTours = new ArrayList<>();
        emptyTours.add(null);
        emptyTours.add(null);
        TravelAgency expectedTravelAgency = new TravelAgency(emptyTours);
        Assertions.assertThrows(DatabaseWriteException.class, () ->
                dataWriter.writeToDatabase(expectedTravelAgency));
    }
}
