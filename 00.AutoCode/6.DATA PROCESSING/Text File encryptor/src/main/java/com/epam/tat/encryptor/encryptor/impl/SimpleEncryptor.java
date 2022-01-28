package com.epam.tat.encryptor.encryptor.impl;

import com.epam.tat.encryptor.datasource.IDataSource;
import com.epam.tat.encryptor.encryptor.ISimpleEncryptor;

import java.awt.image.PackedColorModel;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleEncryptor implements ISimpleEncryptor {

    private IDataSource dataSource;

    public SimpleEncryptor(IDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void changeLetters(char oldChar, char newChar) {
        List<String> resultSet = dataSource.readData();
        resultSet.remove(0);
       dataSource.writeData (resultSet.stream().map(s -> {
            Pattern pattern = Pattern.compile(String.valueOf(oldChar));
            Matcher matcher = pattern.matcher(s);
            StringBuilder newString = new StringBuilder(s);
            while (matcher.find()){
                newString.replace(matcher.start(),matcher.end(),String.valueOf(newChar));
            }
            return newString.toString();
        }).collect(Collectors.toList())
       );
    }

    @Override
    public void byteEncryption() {
        List<String> resultSet = dataSource.readData();
        resultSet.remove(0);
        dataSource.writeData(resultSet.stream().map(s-> new String(Base64.getEncoder().encode(s.getBytes()))).collect(Collectors.toList())
        );
    }

    @Override
    public void rot1() {
        List<String> resultSet = dataSource.readData();
        resultSet.remove(0);
        dataSource.writeData(resultSet.stream().map(s->{
                Pattern pattern = Pattern.compile("[A-za-z0-9]");
                Matcher matcher = pattern.matcher(s);
                StringBuilder newString = new StringBuilder(s);
                while (matcher.find()){
                    char newChar = s.substring(matcher.start(), matcher.end()).charAt(0);
                    switch (s.substring(matcher.start(), matcher.end())){
                        case "9":
                            newChar = Character.toChars('0')[0];
                            break;
                        case "z":
                            newChar = Character.toChars('a')[0];
                            break;
                        case "Z":
                            newChar = Character.toChars('A')[0];
                            break;
                        default:
                            newChar = Character.toChars(newChar +1)[0];
                    }
                    newString.replace(matcher.start(),matcher.end(),String.valueOf(newChar));
                }
                return newString.toString();
            }).collect(Collectors.toList())
        );
    }
}
