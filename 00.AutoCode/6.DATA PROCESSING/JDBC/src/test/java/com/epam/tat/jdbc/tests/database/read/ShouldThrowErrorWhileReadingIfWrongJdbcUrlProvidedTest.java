package com.epam.tat.jdbc.tests.database.read;

import com.epam.tat.jdbc.database.read.DataReader;
import com.epam.tat.jdbc.database.read.DatabaseDataReader;
import com.epam.tat.jdbc.exceptions.DatabaseConnectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShouldThrowErrorWhileReadingIfWrongJdbcUrlProvidedTest {

    @Test
    public void shouldThrowErrorWhileReadingIfWrongJdbcUrlProvidedTest() {
        DataReader reader = new DatabaseDataReader("fake identifier");
        Assertions.assertThrows(DatabaseConnectionException.class, () ->
                reader.readFromDataBase());
    }
}
