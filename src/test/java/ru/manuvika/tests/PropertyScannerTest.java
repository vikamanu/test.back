package ru.manuvika.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.manuvika.utils.PropertyScanner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyScannerTest {

    private PropertyScanner propertyScanner;

    @BeforeEach
    void setUp() throws IOException {
        propertyScanner = new PropertyScanner();
    }

    @Test
    @DisplayName("Тест получения значения свойства")
    void testGetProperty() {
        String expected = "ololo";
        assertEquals(expected, propertyScanner.getProperty("test.prop"));
    }
}
