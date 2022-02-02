package Greneric_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUTiltiy 
{
    public String getPropertyKeyValue(String key) throws IOException 
    {
    	FileInputStream fis = new FileInputStream("./data/commdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
    	String value = pobj.getProperty(key);
		return value;
		 
    }
}

