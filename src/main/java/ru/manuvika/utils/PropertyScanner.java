package ru.manuvika.utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyScanner {

    private final Properties properties;

    public PropertyScanner() throws IOException {
        properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/main/resources/utils/application.properties")));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

