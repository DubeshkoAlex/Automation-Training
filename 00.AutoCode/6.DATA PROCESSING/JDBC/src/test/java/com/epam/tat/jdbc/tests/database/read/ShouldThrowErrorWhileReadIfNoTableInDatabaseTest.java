package com.epam.tat.jdbc.tests.database.read;

import com.epam.tat.jdbc.exceptions.DatabaseReadException;
import com.epam.tat.jdbc.tests.base.BaseDatabaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShouldThrowErrorWhileReadIfNoTableInDatabaseTest extends BaseDatabaseTest {

    @Test
    public void shouldThrowErrorWhileReadIfNoTableInDatabaseTest() {
        databaseUtils.dropTable();
        Assertions.assertThrows(DatabaseReadException.class, () ->
                dataReader.readFromDataBase());
    }
}
