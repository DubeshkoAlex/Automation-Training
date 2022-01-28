package com.epam.tat.encryptor.datasource;

import java.util.List;

public interface IDataSource {

    void writeData(List<String> data);

    List<String> readData();

    List<String> readData(String path);
}
