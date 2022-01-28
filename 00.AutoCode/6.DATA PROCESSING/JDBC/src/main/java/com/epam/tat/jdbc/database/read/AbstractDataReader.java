package com.epam.tat.jdbc.database.read;

public abstract class AbstractDataReader implements DataReader {

    private String sourceIdentifier;

    public AbstractDataReader(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }
}
