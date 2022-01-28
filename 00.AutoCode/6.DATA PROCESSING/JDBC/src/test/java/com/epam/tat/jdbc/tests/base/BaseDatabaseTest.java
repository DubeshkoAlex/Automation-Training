package com.epam.tat.jdbc.tests.base;

import com.epam.tat.jdbc.database.read.DataReader;
import com.epam.tat.jdbc.database.read.DatabaseDataReader;
import com.epam.tat.jdbc.database.write.DataWriter;
import com.epam.tat.jdbc.database.write.DatabaseDataWriter;
import com.epam.tat.jdbc.utils.DatabaseUtils;
import org.junit.jupiter.api.BeforeEach;


public class BaseDatabaseTest {

    protected DataReader dataReader;
    protected DataWriter dataWriter;
    protected DatabaseUtils databaseUtils;

    public BaseDatabaseTest() {
        dataReader = new DatabaseDataReader(DatabaseUtils.URL);
        dataWriter = new DatabaseDataWriter(DatabaseUtils.URL);
        databaseUtils = new DatabaseUtils();
    }

    @BeforeEach
    public void refreshDataBaseTable() {
        databaseUtils.refreshTable();
    }

}
