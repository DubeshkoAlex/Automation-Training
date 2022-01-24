package com.epam.tat.xmljsonproperties.datareading.xml;

import com.epam.tat.xmljsonproperties.datareading.AbstractDataProcessor;
import com.epam.tat.xmljsonproperties.exceptions.DataSourceFileNotExistsException;
import com.epam.tat.xmljsonproperties.exceptions.UbableToParseDataSourceException;
import com.epam.tat.xmljsonproperties.exceptions.UbableToWriteDataToSourceException;
import com.epam.tat.xmljsonproperties.model.AirCompany;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlDataProcessor extends AbstractDataProcessor {

    public XmlDataProcessor(String sourceIdentifier) {
        super(sourceIdentifier);
    }

    @Override
    public AirCompany readDataFromSource() {
        try {
            File file  = new File(getSourceIdentifier());
            if(!file.exists()){
                throw new DataSourceFileNotExistsException("File doesn't exist!");
            }
            JAXBContext context = JAXBContext.newInstance(AirCompany.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return  (AirCompany) unmarshaller.unmarshal(file);
        }
        catch (JAXBException e){
            throw new UbableToParseDataSourceException("Unable to read from XML file!");
        }

    }

    @Override
    public void writeDataToSource(AirCompany aircompany) {
        try {
            String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            if(!new File(getSourceIdentifier()).exists()) {
                new File(getSourceIdentifier().substring(0,getSourceIdentifier().lastIndexOf("/"))).mkdirs();
                new File(getSourceIdentifier()).createNewFile();
            }
            new File(getSourceIdentifier()).delete();
            File file = new File(getSourceIdentifier());
            JAXBContext context = JAXBContext.newInstance(AirCompany.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            Writer writer = new FileWriter(file);
            if(aircompany.getPlanes().size() != 0) {
                writer.write(xmlHead);
                marshaller.marshal(aircompany,writer);
            }
            else {
                writer.write(xmlHead + "<planes></planes>");
            }
            writer.close();
        }catch (JAXBException | IllegalArgumentException | IOException e){
            throw new UbableToWriteDataToSourceException("Unable to write into XML file");
        }
    }

}
