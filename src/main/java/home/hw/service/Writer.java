package home.hw.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Writer {
    public String saveImage(int code, byte[] stream) {
        String path = String.format("%s.jpg", code);
        try {
            Files.write(Path.of(path), stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;
    }
}
