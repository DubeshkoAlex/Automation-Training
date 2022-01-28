package com.epam.tat.encryptor.datasource.impl;


import com.epam.tat.encryptor.datasource.IDataSource;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataSource implements IDataSource {

    private final String inputEndpoint;
    private final String outputEndpoint;

    public FileDataSource(String inputEndpoint, String outputEndpoint) {
        this.inputEndpoint = inputEndpoint;
        this.outputEndpoint = outputEndpoint;
    }

    @Override
    public void writeData(List<String> data) {
        try{
            FileWriter writer = new FileWriter(Paths.get(outputEndpoint).toFile());
            for (String string:data) {
                writer.write(string + "\n");
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readData() {
        return readData(inputEndpoint);
    }

    @Override
    public List<String> readData(String path) {
        List<String> data = null;
        try {
            FileReader fileReader = new FileReader(Paths.get(inputEndpoint).toFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.lines().collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
