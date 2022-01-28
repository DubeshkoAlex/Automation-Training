package com.epam.tat.jdbc.tests.database.write;

import com.epam.tat.jdbc.exceptions.DatabaseWriteException;
import com.epam.tat.jdbc.tests.base.BaseDatabaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShouldThrowErrorWhenWriteNullAgencyToDatabaseTest extends BaseDatabaseTest {

    @Test
    public void shouldThrowErrorWhenWriteNullAgencyToDatabase() {
        Assertions.assertThrows(DatabaseWriteException.class, () ->
                dataWriter.writeToDatabase(null));
    }
}
