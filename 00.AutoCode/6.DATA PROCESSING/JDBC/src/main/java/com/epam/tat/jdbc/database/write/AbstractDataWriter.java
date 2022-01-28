package com.epam.tat.jdbc.database.write;

public abstract class AbstractDataWriter implements DataWriter {

    private String sourceIdentifier;

    public AbstractDataWriter(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }
}
