package com.epam.tat.encryptor.encryptor;

public interface ISimpleEncryptor {

    void changeLetters(char oldChar, char newChar);

    void byteEncryption();

    void rot1();
}
