package ru.manuvika.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public final class FileUtils {

    private FileUtils() {}

    public static String getResourceAsBase64(String resourceName) throws URISyntaxException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FileUtils.class.getResource(resourceName).toURI()));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] getResourceAsByteArray(String resource) throws Exception {
        return Files.readAllBytes(Paths.get(FileUtils.class.getResource(resource).toURI()));
    }
}
