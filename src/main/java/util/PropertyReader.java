package util;


import groovyjarjarasm.asm.tree.TryCatchBlockNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static Properties property = null;
    public static String getProperty(String key) {
        if(property==null)
        {
            property=new Properties();
        }
        try {
            property.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property.getProperty(key);
    }

}
