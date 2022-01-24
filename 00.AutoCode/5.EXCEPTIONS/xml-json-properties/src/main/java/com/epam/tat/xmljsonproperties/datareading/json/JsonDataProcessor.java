package com.epam.tat.xmljsonproperties.datareading.json;

import com.epam.tat.xmljsonproperties.datareading.AbstractDataProcessor;
import com.epam.tat.xmljsonproperties.exceptions.DataSourceFileNotExistsException;
import com.epam.tat.xmljsonproperties.exceptions.UbableToParseDataSourceException;
import com.epam.tat.xmljsonproperties.exceptions.UbableToWriteDataToSourceException;
import com.epam.tat.xmljsonproperties.model.AirCompany;
import com.epam.tat.xmljsonproperties.model.planes.AbstractPlane;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JsonDataProcessor extends AbstractDataProcessor {

    public JsonDataProcessor(String sourceIdentifier) {
        super(sourceIdentifier);
    }

    @Override
    public AirCompany readDataFromSource() {
        ObjectMapper mapper = new ObjectMapper();
        AbstractPlane[] abstractPlanes;
        try {
            abstractPlanes = mapper.readValue(Paths.get(getSourceIdentifier()).toFile(),AbstractPlane[].class);
        }catch (FileNotFoundException e) {
            throw new DataSourceFileNotExistsException("File doesn't exist!");
        }catch (IOException e){
            throw new UbableToParseDataSourceException("Incorrect data in file!");
        }
        return new AirCompany(Arrays.asList(abstractPlanes));
    }

    @Override
    public void writeDataToSource(AirCompany aircompany) {
        try {
            if(aircompany == null){
                throw new UbableToWriteDataToSourceException("airCompany is null!");
            }
            if(!new File(getSourceIdentifier()).exists()) {
                new File(getSourceIdentifier().substring(0,getSourceIdentifier().lastIndexOf("/"))).mkdirs();
                new File(getSourceIdentifier()).createNewFile();
            }
            new File(getSourceIdentifier()).delete();
            new File(getSourceIdentifier()).createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            StringBuilder jsonString = new StringBuilder(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aircompany));
            jsonString.replace(jsonString.length()-1,jsonString.length(),"").replace(0,1,"");
            Pattern patternPassenger = Pattern.compile("\"Type\" : \"passenger\",");
            Matcher matcherPassenger = patternPassenger.matcher(jsonString);
            while (matcherPassenger.find()) {
                jsonString.insert(matcherPassenger.end(),"\n  \"MilitaryType\": null,");
            }
            Pattern patternMilitary = Pattern.compile("\"Type\" : \"military\",");
            Matcher matcherMilitary = patternMilitary.matcher(jsonString);
            while (matcherMilitary.find()) {
                jsonString.insert(matcherMilitary.end(),"\n  \"Capacity\": null,");
            }
            Writer writer = new FileWriter(getSourceIdentifier());
            writer.write(jsonString.toString());
            writer.close();
        }catch (NullPointerException e){
            throw new UbableToWriteDataToSourceException("Incorrect data for writing!");
        }
        catch (IOException e){
            throw new DataSourceFileNotExistsException("File doesn't exist!");
        }
    }
}
