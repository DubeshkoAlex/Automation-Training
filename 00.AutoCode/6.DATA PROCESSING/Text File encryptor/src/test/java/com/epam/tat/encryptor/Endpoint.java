package com.epam.tat.encryptor;

import java.io.File;

public enum Endpoint {
    INPUT_TEXT_BASE("src/test/resources/encryptorData/input/inputText.txt"),
    CHANGE_LETTERS_OUTPUT("src/test/resources/encryptorData/expectedoutputs/changeLettersOutput.txt"),

    OUTPUT_TEXT_BASE("target/encryptorData/output/outputText.txt");

    private final String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String getAbsolutePathToEndpoint() {
        return new File(path.replaceAll("//", File.separator)).getAbsolutePath();
    }
}
