package com.epam.tat.encryptor;

import com.epam.tat.encryptor.datasource.IDataSource;
import com.epam.tat.encryptor.datasource.impl.FileDataSource;
import com.epam.tat.encryptor.encryptor.ISimpleEncryptor;
import com.epam.tat.encryptor.encryptor.impl.SimpleEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class EncryptorTests {
    private IDataSource dataSource;
    private ISimpleEncryptor encryptor;

    private static final String INPUT_ENDPOINT = Endpoint.INPUT_TEXT_BASE.getAbsolutePathToEndpoint();
    private static final String OUTPUT_ENDPOINT = Endpoint.OUTPUT_TEXT_BASE.getAbsolutePathToEndpoint();

    @BeforeAll
    public static void createOutputDirectory() {
        String pathToFolder = OUTPUT_ENDPOINT.substring(0, OUTPUT_ENDPOINT.lastIndexOf(File.separator));
        new File(pathToFolder).mkdirs();
    }

    @BeforeEach
    void setUp() {
        dataSource = new FileDataSource(INPUT_ENDPOINT, OUTPUT_ENDPOINT);
        encryptor = new SimpleEncryptor(dataSource);
    }

    @Test
    void shouldChangeLettersEncode() {
        List<String> expected = dataSource.readData(Endpoint.CHANGE_LETTERS_OUTPUT.getAbsolutePathToEndpoint());
        encryptor.changeLetters('c', '#');
        List<String> actual = dataSource.readData(Endpoint.OUTPUT_TEXT_BASE.getAbsolutePathToEndpoint());
        Assertions.assertEquals(expected, actual, "Encode is working wrong");
    }
}
