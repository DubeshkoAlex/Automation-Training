package com.epam.tat.xmljsonproperties.datareading.property;

import com.epam.tat.xmljsonproperties.datareading.AbstractDataProcessor;
import com.epam.tat.xmljsonproperties.exceptions.DataSourceFileNotExistsException;
import com.epam.tat.xmljsonproperties.exceptions.UbableToWriteDataToSourceException;
import com.epam.tat.xmljsonproperties.model.AirCompany;
import com.epam.tat.xmljsonproperties.model.planes.AbstractPlane;
import com.epam.tat.xmljsonproperties.model.planes.MilitaryPlane;
import com.epam.tat.xmljsonproperties.model.planes.PassengerPlane;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyDataProcessor extends AbstractDataProcessor {

    public PropertyDataProcessor(String sourceIdentifier) {
        super(sourceIdentifier);
    }

    @Override
    public AirCompany readDataFromSource() {
        List<AbstractPlane> abstractPlanes = new ArrayList<>();
        try {
            File file = new File(getSourceIdentifier());
            PropertiesConfiguration config = new PropertiesConfiguration();
            PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
            layout.load(config, new InputStreamReader(new FileInputStream(file)));
            int i = 0;
            while (config.getString(("plane" + i + ".type")) != null){
                if(config.getString(("plane" + i + ".type")).equals("military")){
                    MilitaryPlane militaryPlane = new MilitaryPlane();
                    militaryPlane.setModel(config.getString(("plane" + i + ".model")));
                    militaryPlane.setMilitaryType(config.getString(("plane" + i + ".militaryType")));
                    militaryPlane.setMaxSpeed(config.getInt(("plane" + i + ".speed")));
                    militaryPlane.setMaxFlightDistance(config.getInt(("plane" + i + ".distance")));
                    abstractPlanes.add(militaryPlane);
                }
                else if(config.getString(("plane" + i + ".type")).equals("passenger")){
                    PassengerPlane passengerPlane = new PassengerPlane();
                    passengerPlane.setModel(config.getString(("plane" + i + ".model")));
                    passengerPlane.setMaxPassengerCapacity(config.getInt(("plane" + i + ".capacity")));
                    passengerPlane.setMaxSpeed(config.getInt(("plane" + i + ".capacity")));
                    passengerPlane.setMaxFlightDistance(config.getInt(("plane" + i + ".distance")));
                    abstractPlanes.add(passengerPlane);
                }
                i++;
            }
        }catch (FileNotFoundException | ConfigurationException e){
            throw new DataSourceFileNotExistsException("File doesn't exist!");
        }
        return new AirCompany(abstractPlanes);
    }

    @Override
    public void writeDataToSource(AirCompany aircompany) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration();
            PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
            layout.setHeaderComment("#" + new Date());
            layout.setComment("plane0.distance","military planes");
            List<MilitaryPlane> militaryPlanes = aircompany.getMilitaryPlanes();
            for (int i = 0; i < militaryPlanes.size(); i++) {
                config.setProperty(("plane" + i + ".distance"),String.valueOf(militaryPlanes.get(i).getMaxFlightDistance()));
                layout.setSingleLine(("plane" + i + ".distance"),true);
                config.setProperty(("plane" + i + ".militaryType"), militaryPlanes.get(i).getMilitaryType());
                layout.setSingleLine(("plane" + i + ".militaryType"),true);
                config.setProperty(("plane" + i + ".model"),militaryPlanes.get(i).getModel());
                layout.setSingleLine(("plane" + i + ".model"),true);
                config.setProperty(("plane" + i + ".speed"),String.valueOf(militaryPlanes.get(i).getMaxSpeed()));
                layout.setSingleLine(("plane" + i + ".speed"),true);
                config.setProperty(("plane" + i + ".type"),"military");
                layout.setSingleLine(("plane" + i + ".type"),true);
                layout.setBlancLinesBefore("plane" + (i+1) + ".distance",1);
            }
            layout.setBlancLinesBefore("plane" + militaryPlanes.size() + ".distance",1);
            layout.setComment("plane" + militaryPlanes.size() + ".distance","passenger planes");
            List<PassengerPlane> passengerPlanes = aircompany.getPassengerPlanes();
            for (int i = militaryPlanes.size(); i < (passengerPlanes.size()+ militaryPlanes.size()); i++) {
                config.setProperty(("plane" + i + ".distance"),String.valueOf(passengerPlanes.get(i- militaryPlanes.size()).getMaxFlightDistance()));
                layout.setSingleLine(("plane" + i + ".distance"),true);
                config.setProperty(("plane" + i + ".capacity"), String.valueOf(passengerPlanes.get(i- militaryPlanes.size()).getMaxPassengerCapacity()));
                layout.setSingleLine(("plane" + i + ".capacity"),true);
                config.setProperty(("plane" + i + ".model"),passengerPlanes.get(i- militaryPlanes.size()).getModel());
                layout.setSingleLine(("plane" + i + ".model"),true);
                config.setProperty(("plane" + i + ".speed"),String.valueOf(passengerPlanes.get(i- militaryPlanes.size()).getMaxSpeed()));
                layout.setSingleLine(("plane" + i + ".speed"),true);
                config.setProperty(("plane" + i + ".type"),"passenger");
                layout.setSingleLine(("plane" + i + ".type"),true);
                layout.setBlancLinesBefore("plane" + (i+1) + ".distance",1);
            }
            layout.save(config, new FileWriter(getSourceIdentifier(), false));
        }catch (NullPointerException | IOException | ConfigurationException e){
            throw new UbableToWriteDataToSourceException("Unable to write in .properties file!");
        }
    }
}
